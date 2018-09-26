package com.bthub.apidemo.dto;

public class RestMessage<T> {
	private String type;
	private String result;
	private T data;

	@Override
	public String toString() {
		return String.format("RestMessage [type=%s, result=%s, data=%s]", type, result, data);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
