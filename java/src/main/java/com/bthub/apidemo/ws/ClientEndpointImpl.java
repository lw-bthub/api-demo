package com.bthub.apidemo.ws;

import java.io.IOException;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import com.bthub.apidemo.dto.Message;
import com.bthub.apidemo.dto.Quote;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@ClientEndpoint
public class ClientEndpointImpl {
	private static ObjectMapper objectMapper = new ObjectMapper();
	private static TypeReference<Message<Quote>> QUOTE_TYPE = new TypeReference<Message<Quote>>() { };
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println(String.format("Session[%s] is open.", session));
	}

	@OnMessage
	public void onMessage(Session session, String message) {
		System.out.println(String.format("Session[%s] client onMessage: [%s]", session, message));
		try {
			Message<Quote> quote = objectMapper.readValue(message, QUOTE_TYPE);
			System.out.println(String.format("Session[%s] client onMessage: [%s]", session, quote));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnError
	public void onError(Session session, Throwable t) {
		System.out.println(String.format("Session[%s] error", session));
		t.printStackTrace();
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		System.out.println(String.format("Session[%s] is closed. ref: [%s]", session, closeReason));
	}

}