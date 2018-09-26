package com.bthub.apidemo.dto;

public class WsMessage<T> {
	private String event;
	private T data;

	@Override
	public String toString() {
		return String.format("Message [event=%s, data=%s]", event, data);
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
