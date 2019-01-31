package com.bthub.apidemo.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

public class MakingConfigL2 {

    private BigDecimal minSpread;
    private byte ladderDepth;
    private BigDecimal tickSize;
    private BigDecimal maxDeviation;
    private BigDecimal minVolume;
    private BigDecimal maxVolume;
    private BigDecimal minThreshold;

    public BigDecimal getMinSpread() {
        return minSpread;
    }

    public void setMinSpread(BigDecimal minSpread) {
        this.minSpread = minSpread;
    }

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

    public BigDecimal getMaxDeviation() {
        return maxDeviation;
    }

    public void setMaxDeviation(BigDecimal maxDeviation) {
        this.maxDeviation = maxDeviation;
    }

    public BigDecimal getMinThreshold() {
        return minThreshold;
    }

    public void setMinThreshold(BigDecimal minThreshold) {
        this.minThreshold = minThreshold;
    }

    public BigDecimal getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(BigDecimal minVolume) {
        this.minVolume = minVolume;
    }

    public BigDecimal getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(BigDecimal maxVolume) {
        this.maxVolume = maxVolume;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("minSpread", this.minSpread)
                .append("ladderDepth", this.ladderDepth)
                .append("tickSize", this.tickSize)
                .append("maxDeviation", this.maxDeviation)
                .append("minVolume", this.minVolume)
                .append("maxVolume", this.maxVolume)
                .append("minThreshold", this.minThreshold)
                .toString();
    }

    static MakingConfigL2 init() {
        MakingConfigL2 level2 = new MakingConfigL2();
        level2.setMinSpread(new BigDecimal(100));
        level2.setLadderDepth((byte) 5);
        level2.setTickSize(new BigDecimal("0.01"));
        level2.setMaxDeviation(new BigDecimal("0.5"));
        level2.setMinVolume(new BigDecimal("0.1"));
        level2.setMaxVolume(new BigDecimal("0.5"));
        level2.setMinThreshold(new BigDecimal(40));
        return level2;
    }
}
