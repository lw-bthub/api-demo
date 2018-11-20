package com.bthub.apidemo.priceboard;

import java.io.IOException;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import com.bthub.apidemo.dto.Quote;
import com.bthub.apidemo.dto.WsMessage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@ClientEndpoint
public class PriceBoardEndpointImpl {
	private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static TypeReference<WsMessage<Quote>> QUOTE_TYPE = new TypeReference<WsMessage<Quote>>() {};
	public static PriceBoard PRICE_BOARD;
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println(String.format("Session[%s] is open.", session));
	}

	@OnMessage
	public void onMessage(Session session, String message) {
		try {
			WsMessage<Quote> wsMessage = OBJECT_MAPPER.readValue(message, QUOTE_TYPE);
			PRICE_BOARD.onQuote(wsMessage.getData());
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