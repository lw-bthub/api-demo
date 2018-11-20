package com.bthub.apidemo.dto;

public class Symbol {

	private String name;
	private String tradingMaxVolume;
	private String tradingMinVolume;
	private Integer tradingPriceScale;
	private Integer tradingVolumeScale;

	@Override
	public String toString() {
		return String.format("Symbol [ name=%s, tradingMaxVolume=%s, tradingMinVolume=%s, tradingPriceScale=%s, tradingVolumeScale=%s]", name, tradingMaxVolume, tradingMinVolume, tradingPriceScale, tradingVolumeScale);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTradingMaxVolume() {
		return tradingMaxVolume;
	}

	public void setTradingMaxVolume(String tradingMaxVolume) {
		this.tradingMaxVolume = tradingMaxVolume;
	}

	public String getTradingMinVolume() {
		return tradingMinVolume;
	}

	public void setTradingMinVolume(String tradingMinVolume) {
		this.tradingMinVolume = tradingMinVolume;
	}

	public Integer getTradingPriceScale() {
		return tradingPriceScale;
	}

	public void setTradingPriceScale(Integer tradingPriceScale) {
		this.tradingPriceScale = tradingPriceScale;
	}

	public Integer getTradingVolumeScale() {
		return tradingVolumeScale;
	}

	public void setTradingVolumeScale(Integer tradingVolumeScale) {
		this.tradingVolumeScale = tradingVolumeScale;
	}

}
