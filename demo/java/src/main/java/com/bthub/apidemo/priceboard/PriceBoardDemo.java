package com.bthub.apidemo.priceboard;

import static com.bthub.apidemo.common.Consts.HOST;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import com.bthub.apidemo.dto.Cp;
import com.bthub.apidemo.dto.RestMessage;
import com.bthub.apidemo.dto.Symbol;
import com.bthub.apidemo.rest.RestServiceImpl;

public class PriceBoardDemo {
    private static String uri = "ws://" + HOST + "/api/realtime?X-API-TOKEN=";

    public static void main(String[] args) throws Exception {
        RestServiceImpl service = new RestServiceImpl();
        String token = service.getToken("mhuangwei", "1qaz1qaz");
        RestMessage<List<Symbol>> restMessage = service.symbols(token);
        Symbol symbol = restMessage.getData().stream().filter(t -> t.getName().equals("BTCUSDT")).findFirst().get();
        //
        List<Cp> cps = service.cps(token).getData();
        Map<String, Cp> cpMaps = new HashMap<String, Cp>();
        for (Cp cp : cps) cpMaps.put(cp.getName(), cp);
        PriceBoard priceBoard = new PriceBoard(symbol, cpMaps);
        PriceBoardEndpointImpl.PRICE_BOARD = priceBoard;
        //
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        URI r = URI.create(uri + token);
        Session session = container.connectToServer(PriceBoardEndpointImpl.class, r);
        // Quote推送
        session.getBasicRemote().sendText("subscribe:apiQuote:BTCUSDT");
        // 交易结果推送
        session.getBasicRemote().sendText("subscribe:apiOrder");

        while (true) {
            Thread.sleep(10 * 1000);
            priceBoard.print();
        }
    }
}
