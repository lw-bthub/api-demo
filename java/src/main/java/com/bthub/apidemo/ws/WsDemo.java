package com.bthub.apidemo.ws;

import static com.bthub.apidemo.common.Consts.HOST;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import com.bthub.apidemo.rest.RestServiceImpl;

public class WsDemo {
	private static String uri = "ws://" + HOST + "/api/realtime?X-API-TOKEN=";

	
	public static void main(String[] args) throws Exception {
		RestServiceImpl service = new RestServiceImpl();
		String token = service.getToken("API01", "1qaz1qaz");

		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		URI r = URI.create(uri + token);
		Session session = container.connectToServer(ClientEndpointImpl.class, r);
		// Quote推送
		session.getBasicRemote().sendText("subscribe:apiQuote:65537");
		// 交易结果推送
		session.getBasicRemote().sendText("subscribe:apiOrder:65537");

		Thread.sleep(Long.MAX_VALUE);
	}

}