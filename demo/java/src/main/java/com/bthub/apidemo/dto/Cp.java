package com.bthub.apidemo.dto;

public class Cp {
	private String name;
	private Boolean tradingEnabled;

	@Override
	public String toString() {
		return String.format("Cp [name=%s, tradingEnabled=%s]",name, tradingEnabled);
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
