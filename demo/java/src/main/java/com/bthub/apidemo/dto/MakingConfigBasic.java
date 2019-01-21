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

    public MakingConfigBasic(String cp, String symbol, List<String> refCps, String baseCp) {
        this.cp = cp;
        this.symbol = symbol;
        this.refCps = refCps;
        this.baseCp = baseCp;
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

    @Override
    public String toString() {
        return "{"
                + "\"cp\":\"" + this.cp + "\","
                + "\"symbol\":\"" + this.symbol + "\","
                + "\"refCps\":" + JSONArray.toJSONString(this.refCps) + ","
                + "\"baseCp\":" + (StringUtils.isBlank(this.baseCp) ? null : "\"" + this.baseCp + "\"")
                + "}".replaceAll("\\\\\"", "\"");
    }

    static MakingConfigBasic init() {
        List<String> refCps = new ArrayList<String>() {{
            add("bc");
            add("huobi");
            add("okex");
        }};
        return new MakingConfigBasic("chainup", "ETHUSDT", refCps, null);
    }
}