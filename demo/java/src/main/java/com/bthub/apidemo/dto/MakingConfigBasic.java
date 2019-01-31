package com.bthub.apidemo.dto;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MakingConfigBasic {

    private String cp;
    private String symbol;
    private List<String> refCps;
    private String baseCp;
    private boolean orderActive;
    private boolean tradesActive;
    private boolean l2OrderActive;

    public MakingConfigBasic(String cp, String symbol, List<String> refCps, String baseCp,
                             boolean orderActive, boolean tradesActive, boolean l2OrderActive) {
        this.cp = cp;
        this.symbol = symbol;
        this.refCps = refCps;
        this.baseCp = baseCp;
        this.orderActive = orderActive;
        this.tradesActive = tradesActive;
        this.l2OrderActive = l2OrderActive;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<String> getRefCps() {
        return refCps;
    }

    public void setRefCps(List<String> refCps) {
        this.refCps = refCps;
    }

    public String getBaseCp() {
        return baseCp;
    }

    public void setBaseCp(String baseCp) {
        this.baseCp = baseCp;
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

    public boolean isL2OrderActive() {
        return l2OrderActive;
    }

    public void setL2OrderActive(boolean l2OrderActive) {
        this.l2OrderActive = l2OrderActive;
    }

    @Override
    public String toString() {
        return "{"
                + "\"cp\":\"" + this.cp + "\","
                + "\"symbol\":\"" + this.symbol + "\","
                + "\"refCps\":" + JSONArray.toJSONString(this.refCps) + ","
                + "\"baseCp\":" + (StringUtils.isBlank(this.baseCp) ? null + "," : "\"" + this.baseCp + "\",")
                + "\"orderActive\":" + this.orderActive + ","
                + "\"tradesActive\":" + this.tradesActive + ","
                + "\"l2OrderActive\":" + this.l2OrderActive
                + "}".replaceAll("\\\\\"", "\"");
    }

    static MakingConfigBasic init() {
        List<String> refCps = new ArrayList<String>() {{
            add("bc");
            add("huobi");
            add("okex");
        }};
        return new MakingConfigBasic("chainup", "ETHUSDT", refCps, null, false, false, false);
    }
}