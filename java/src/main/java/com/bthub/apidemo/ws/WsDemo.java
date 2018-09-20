package com.bthub.apidemo.ws;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import com.bthub.apidemo.rest.RestServiceImpl;

public class WsDemo {
	private static String uri = "ws://192.168.1.215:8081/api/realtime?X-API-TOKEN=";

	public static void main(String[] args) throws Exception {
		RestServiceImpl service = new RestServiceImpl();
		String token = service.getToken("API01", "1qaz1qaz");

		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		URI r = URI.create(uri + token);
		Session session = container.connectToServer(ClientEndpointImpl.class, r);
		session.getBasicRemote().sendText("subscribe:apiQuote:65547");

		Thread.sleep(Long.MAX_VALUE);
	}

}