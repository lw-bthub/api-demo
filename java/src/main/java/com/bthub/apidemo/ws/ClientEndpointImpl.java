package com.bthub.apidemo.ws;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class ClientEndpointImpl {

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Session is open.");
	}

	@OnMessage
	public void onMessage(String message) {
		System.out.println("Client onMessage: " + message);
	}

	@OnError
	public void onError(Throwable t) {
		t.printStackTrace();
	}

	@OnClose
	public void onClose() {
		System.out.println("Session is closed.");
	}

}