package com.bthub.apidemo.dto;

import java.math.BigDecimal;
import java.util.List;

public class Quote {
	private Integer bkSymbolId;
	private BigDecimal commission;
	private List<Band> asks;
	private List<Band> bids;

	@Override
	public String toString() {
		return String.format("Quote [bkSymbolId=%s, commission=%s, asks=%s, bids=%s]", bkSymbolId, commission, asks, bids);
	}

	public Integer getBkSymbolId() {
		return bkSymbolId;
	}

	public void setBkSymbolId(Integer bkSymbolId) {
		this.bkSymbolId = bkSymbolId;
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
