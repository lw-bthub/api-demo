package com.bthub.apidemo.dto;

public class Cp {

	private Integer id;
	private String name;
	private Boolean tradingEnabled;

	@Override
	public String toString() {
		return String.format("Cp [id=%s, name=%s, tradingEnabled=%s]", id, name, tradingEnabled);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getTradingEnabled() {
		return tradingEnabled;
	}

	public void setTradingEnabled(Boolean tradingEnabled) {
		this.tradingEnabled = tradingEnabled;
	}

}
