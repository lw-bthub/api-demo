package com.bthub.apidemo.ws;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class WsDemo {
	private static final String TOKEN = "eFFLdjN3TU9CVWRwdTdNc3ktM3JuZyIsImFsZyI6IkEyNTZHQ01LVyIsIml2IjoiOVNuRHZiNGIxZGhNVXQ2ViJ9.9URFbvjlt75sTW8Ro-acMLCewX5ozKwx3UOGIDBnnq4.2Fenbi5HSf8h3D94.xxV2EzFtAKLHfum2w4PG59fOnkjzDw3ls0KZKsGI2jwZbqCIpakjdQIFNyoTplM3e2FHwrSjsMP5yHV8fEm95EDtCjR0G127PUDCFBMmks0rtjiiNj0yKyTGAHuj9yII9y6jG_6slHXCj3rgP01JAvlNHtPnqqBWvykGx9IxoG_72W1ZHMA5PZCT2XUCFTxUqsURXN8QgA1IwQCbNDirHas.6ThyFHLsKgu4CGWU7N6H_A";
	private static String uri = "ws://192.168.1.215:8081/api/realtime?X-API-TOKEN=" + TOKEN;

	public static void main(String[] args) throws Exception {
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		URI r = URI.create(uri);
		Session session = container.connectToServer(ClientEndpointImpl.class, r);
		session.getBasicRemote().sendText("subscribe:apiQuote:65547");

		Thread.sleep(1000 * 10);
	}

}