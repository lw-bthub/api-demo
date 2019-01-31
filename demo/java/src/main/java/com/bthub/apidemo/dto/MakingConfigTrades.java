package com.bthub.apidemo.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

public class MakingConfigTrades {

    private String tradesType;
    private BigDecimal tradeSendRatio;
    private boolean tradeVolumeDeduct;
    private BigDecimal minTradesRatio;
    private BigDecimal maxTradesRatio;
    private BigDecimal tradePriceAdjustRatio;
    private BigDecimal tradeRefSpread;
    private BigDecimal minTradeVolume;
    private BigDecimal maxTradeVolume;

    public String getTradesType() {
        return tradesType;
    }

    public void setTradesType(String tradesType) {
        this.tradesType = tradesType;
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

    public BigDecimal getTradePriceAdjustRatio() {
        return tradePriceAdjustRatio;
    }

    public void setTradePriceAdjustRatio(BigDecimal tradePriceAdjustRatio) {
        this.tradePriceAdjustRatio = tradePriceAdjustRatio;
    }

    public BigDecimal getTradeRefSpread() {
        return tradeRefSpread;
    }

    public void setTradeRefSpread(BigDecimal tradeRefSpread) {
        this.tradeRefSpread = tradeRefSpread;
    }

    public BigDecimal getMinTradeVolume() {
        return minTradeVolume;
    }

    public void setMinTradeVolume(BigDecimal minTradeVolume) {
        this.minTradeVolume = minTradeVolume;
    }

    public BigDecimal getMaxTradeVolume() {
        return maxTradeVolume;
    }

    public void setMaxTradeVolume(BigDecimal maxTradeVolume) {
        this.maxTradeVolume = maxTradeVolume;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("tradesType", this.tradesType)
                .append("tradeSendRatio", this.tradeSendRatio)
                .append("tradeVolumeDeduct", this.tradeVolumeDeduct)
                .append("minTradesRatio", this.minTradesRatio)
                .append("maxTradesRatio", this.maxTradesRatio)
                .append("tradePriceAdjustRatio", this.tradePriceAdjustRatio)
                .append("tradeRefSpread", this.tradeRefSpread)
                .append("minTradeVolume", this.minTradeVolume)
                .append("maxTradeVolume", this.maxTradeVolume)
                .toString();
    }

    static MakingConfigTrades init() {
        MakingConfigTrades trades = new MakingConfigTrades();
        trades.setTradesType("TOB");
        trades.setTradeSendRatio(new BigDecimal("0.1"));
        trades.setTradeVolumeDeduct(false);
        trades.setMinTradesRatio(new BigDecimal("0.1"));
        trades.setMaxTradesRatio(new BigDecimal("0.1"));
        trades.setTradePriceAdjustRatio(new BigDecimal("0.1"));
        trades.setTradeRefSpread(new BigDecimal("0.1"));
        trades.setMinTradeVolume(new BigDecimal("0.5"));
        trades.setMaxTradeVolume(new BigDecimal("0.5"));
        return trades;
    }
}
