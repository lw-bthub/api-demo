package com.bthub.apidemo.dto;

import java.math.BigDecimal;
import java.util.List;

public class Quote {
	private String symbol;
	private String cp;
	private BigDecimal commission;
	private List<Band> asks;
	private List<Band> bids;

	@Override
	public String toString() {
		return String.format("Quote [symbol=%s, cp=%s, commission=%s, asks=%s, bids=%s]", symbol, cp, commission, asks, bids);
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public List<Band> getAsks() {
		return asks;
	}

	public void setAsks(List<Band> asks) {
		this.asks = asks;
	}

	public List<Band> getBids() {
		return bids;
	}

	public void setBids(List<Band> bids) {
		this.bids = bids;
	}

}
