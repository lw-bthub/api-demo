package com.bthub.apidemo.priceboard;

import java.math.BigDecimal;

public class Ticker {
	private String cp;
	private BigDecimal price;
	private BigDecimal commissionPrice;
	private BigDecimal volume;

	public Ticker() {
	}

	public Ticker(String cp, BigDecimal price, BigDecimal commissionPrice, BigDecimal volume) {
		super();
		this.cp = cp;
		this.price = price;
		this.commissionPrice = commissionPrice;
		this.volume = volume;
	}

	@Override
	public String toString() {
		return String.format("Ticker [cp=%s, price=%s, commissionPrice=%s, volume=%s]", cp, price, commissionPrice, volume);
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getCommissionPrice() {
		return commissionPrice;
	}

	public void setCommissionPrice(BigDecimal commissionPrice) {
		this.commissionPrice = commissionPrice;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

}
