package com.bthub.apidemo.dto;

import java.math.BigDecimal;
import java.util.List;

public class Quote {
	private Integer symbolId;
	private Integer cpId;
	private BigDecimal commission;
	private List<Band> asks;
	private List<Band> bids;

	@Override
	public String toString() {
		return String.format("Quote [symbolId=%s, cpId=%s, commission=%s, asks=%s, bids=%s]", symbolId, cpId, commission, asks, bids);
	}

	public Integer getSymbolId() {
		return symbolId;
	}

	public void setSymbolId(Integer symbolId) {
		this.symbolId = symbolId;
	}

	public Integer getCpId() {
		return cpId;
	}

	public void setCpId(Integer cpId) {
		this.cpId = cpId;
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
