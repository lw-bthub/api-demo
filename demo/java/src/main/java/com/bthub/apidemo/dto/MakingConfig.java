package com.bthub.apidemo.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MakingConfig {

    private MakingConfigBasic basic;
    private MakingConfigL1 level1;
    private MakingConfigL2 level2;
    private MakingConfigTrades trades;
    private int version;

    public MakingConfig(MakingConfigBasic basic, MakingConfigL1 level1, MakingConfigL2 level2, MakingConfigTrades trades) {
        this.basic = basic;
        this.level1 = level1;
        this.level2 = level2;
        this.trades = trades;
    }

    public MakingConfigBasic getBasic() {
        return basic;
    }

    public void setBasic(MakingConfigBasic basic) {
        this.basic = basic;
    }

    public MakingConfigL1 getLevel1() {
        return level1;
    }

    public void setLevel1(MakingConfigL1 level1) {
        this.level1 = level1;
    }

    public MakingConfigL2 getLevel2() {
        return level2;
    }

    public void setLevel2(MakingConfigL2 level2) {
        this.level2 = level2;
    }

    public MakingConfigTrades getTrades() {
        return trades;
    }

    public void setTrades(MakingConfigTrades trades) {
        this.trades = trades;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public static MakingConfig init() {
        return new MakingConfig(MakingConfigBasic.init(), MakingConfigL1.init(), MakingConfigL2.init(), MakingConfigTrades.init());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("basic", this.basic)
                .append("level1", this.level1)
                .append("level2", this.level2)
                .append("trades", this.trades)
                .append("version", this.version)
                .toString();
    }
}
