package com.bthub.apidemo.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

public class MakingConfigL1 {

    private byte ladderDepth;
    private BigDecimal tickSize;
    private BigDecimal stepHeight;
    private BigDecimal minSpread;
    private BigDecimal maxVolume;
    private String priceAdjustType;
    private BigDecimal bidVolumeAdjustRatio;
    private BigDecimal askVolumeAdjustRatio;
    private BigDecimal bidPriceAdjustRatio;
    private BigDecimal askPriceAdjustRatio;
    private BigDecimal bidPriceAdjustValue;
    private BigDecimal askPriceAdjustValue;
    private BigDecimal minTradesRatio;
    private BigDecimal maxTradesRatio;
    private int orderFrequency;
    private long quoteExpiration;
    private BigDecimal tradeSendRatio;
    private boolean tradeVolumeDeduct;
    private boolean orderActive;
    private boolean tradesActive;

    public byte getLadderDepth() {
        return ladderDepth;
    }

    public void setLadderDepth(byte ladderDepth) {
        this.ladderDepth = ladderDepth;
    }

    public BigDecimal getTickSize() {
        return tickSize;
    }

    public void setTickSize(BigDecimal tickSize) {
        this.tickSize = tickSize;
    }

    public BigDecimal getStepHeight() {
        return stepHeight;
    }

    public void setStepHeight(BigDecimal stepHeight) {
        this.stepHeight = stepHeight;
    }

    public BigDecimal getMinSpread() {
        return minSpread;
    }

    public void setMinSpread(BigDecimal minSpread) {
        this.minSpread = minSpread;
    }

    public BigDecimal getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(BigDecimal maxVolume) {
        this.maxVolume = maxVolume;
    }

    public String getPriceAdjustType() {
        return priceAdjustType;
    }

    public void setPriceAdjustType(String priceAdjustType) {
        this.priceAdjustType = priceAdjustType;
    }

    public BigDecimal getBidVolumeAdjustRatio() {
        return bidVolumeAdjustRatio;
    }

    public void setBidVolumeAdjustRatio(BigDecimal bidVolumeAdjustRatio) {
        this.bidVolumeAdjustRatio = bidVolumeAdjustRatio;
    }

    public BigDecimal getAskVolumeAdjustRatio() {
        return askVolumeAdjustRatio;
    }

    public void setAskVolumeAdjustRatio(BigDecimal askVolumeAdjustRatio) {
        this.askVolumeAdjustRatio = askVolumeAdjustRatio;
    }

    public BigDecimal getBidPriceAdjustRatio() {
        return bidPriceAdjustRatio;
    }

    public void setBidPriceAdjustRatio(BigDecimal bidPriceAdjustRatio) {
        this.bidPriceAdjustRatio = bidPriceAdjustRatio;
    }

    public BigDecimal getAskPriceAdjustRatio() {
        return askPriceAdjustRatio;
    }

    public void setAskPriceAdjustRatio(BigDecimal askPriceAdjustRatio) {
        this.askPriceAdjustRatio = askPriceAdjustRatio;
    }

    public BigDecimal getBidPriceAdjustValue() {
        return bidPriceAdjustValue;
    }

    public void setBidPriceAdjustValue(BigDecimal bidPriceAdjustValue) {
        this.bidPriceAdjustValue = bidPriceAdjustValue;
    }

    public BigDecimal getAskPriceAdjustValue() {
        return askPriceAdjustValue;
    }

    public void setAskPriceAdjustValue(BigDecimal askPriceAdjustValue) {
        this.askPriceAdjustValue = askPriceAdjustValue;
    }

    public BigDecimal getMinTradesRatio() {
        return minTradesRatio;
    }

    public void setMinTradesRatio(BigDecimal minTradesRatio) {
        this.minTradesRatio = minTradesRatio;
    }

    public BigDecimal getMaxTradesRatio() {
        return maxTradesRatio;
    }

    public void setMaxTradesRatio(BigDecimal maxTradesRatio) {
        this.maxTradesRatio = maxTradesRatio;
    }

    public int getOrderFrequency() {
        return orderFrequency;
    }

    public void setOrderFrequency(int orderFrequency) {
        this.orderFrequency = orderFrequency;
    }

    public long getQuoteExpiration() {
        return quoteExpiration;
    }

    public void setQuoteExpiration(long quoteExpiration) {
        this.quoteExpiration = quoteExpiration;
    }

    public BigDecimal getTradeSendRatio() {
        return tradeSendRatio;
    }

    public void setTradeSendRatio(BigDecimal tradeSendRatio) {
        this.tradeSendRatio = tradeSendRatio;
    }

    public boolean isTradeVolumeDeduct() {
        return tradeVolumeDeduct;
    }

    public void setTradeVolumeDeduct(boolean tradeVolumeDeduct) {
        this.tradeVolumeDeduct = tradeVolumeDeduct;
    }

    public boolean isOrderActive() {
        return orderActive;
    }

    public void setOrderActive(boolean orderActive) {
        this.orderActive = orderActive;
    }

    public boolean isTradesActive() {
        return tradesActive;
    }

    public void setTradesActive(boolean tradesActive) {
        this.tradesActive = tradesActive;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("ladderDepth", this.ladderDepth)
                .append("tickSize", this.tickSize)
                .append("stepHeight", this.stepHeight)
                .append("minSpread", this.minSpread)
                .append("maxVolume", this.maxVolume)
                .append("priceAdjustType", this.priceAdjustType)
                .append("bidVolumeAdjustRatio", this.bidVolumeAdjustRatio)
                .append("askVolumeAdjustRatio", this.askVolumeAdjustRatio)
                .append("bidPriceAdjustRatio", this.bidPriceAdjustRatio)
                .append("askPriceAdjustRatio", this.askPriceAdjustRatio)
                .append("bidPriceAdjustValue", this.bidPriceAdjustValue)
                .append("askPriceAdjustValue", this.askPriceAdjustValue)
                .append("minTradesRatio", this.minTradesRatio)
                .append("maxTradesRatio", this.maxTradesRatio)
                .append("orderFrequency", this.orderFrequency)
                .append("quoteExpiration", this.quoteExpiration)
                .append("tradeSendRatio", this.tradeSendRatio)
                .append("tradeVolumDeduct", this.tradeVolumeDeduct)
                .append("orderActive", this.orderActive)
                .append("tradesActive", this.tradesActive)
                .toString();
    }

    static MakingConfigL1 init() {
        MakingConfigL1 level1 = new MakingConfigL1();
        level1.setLadderDepth((byte) 5);
        level1.setTickSize(new BigDecimal("0.01"));
        level1.setStepHeight(new BigDecimal("0.02"));
        level1.setMinSpread(new BigDecimal(2));
        level1.setMaxVolume(new BigDecimal(2));
        level1.setPriceAdjustType("VALUE");
        level1.setBidVolumeAdjustRatio(BigDecimal.ONE);
        level1.setAskVolumeAdjustRatio(BigDecimal.ONE);
        level1.setBidPriceAdjustRatio(new BigDecimal("0.2"));
        level1.setAskPriceAdjustRatio(new BigDecimal("0.8"));
        level1.setBidPriceAdjustValue(new BigDecimal("0.5"));
        level1.setAskPriceAdjustValue(BigDecimal.ONE);
        level1.setMinTradesRatio(new BigDecimal("0.1"));
        level1.setMaxTradesRatio(BigDecimal.ONE);
        level1.setOrderFrequency(60);
        level1.setQuoteExpiration(60000);
        level1.setTradeSendRatio(BigDecimal.ONE);
        level1.setTradeVolumeDeduct(false);
        level1.setOrderActive(false);
        level1.setTradesActive(false);
        return level1;
    }
}
