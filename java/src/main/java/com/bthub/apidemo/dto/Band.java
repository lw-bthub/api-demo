package com.bthub.apidemo.dto;

import java.math.BigDecimal;

public class Band {
	private BigDecimal price;
	private BigDecimal volume;

	@Override
	public String toString() {
		return String.format("Band [price=%s, volume=%s]", price, volume);
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

}
