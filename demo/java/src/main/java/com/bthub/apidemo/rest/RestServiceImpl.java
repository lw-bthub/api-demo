package com.bthub.apidemo.rest;

import com.bthub.apidemo.dto.Cp;
import com.bthub.apidemo.dto.RestMessage;
import com.bthub.apidemo.dto.Symbol;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import static com.bthub.apidemo.common.Consts.HOST;

public class RestServiceImpl {

    private static final String PREFIX = "http://" + HOST;
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final TypeReference<RestMessage<List<Symbol>>> SYMBOL_TYPE = new TypeReference<RestMessage<List<Symbol>>>() {
    };
    private static final TypeReference<RestMessage<List<Cp>>> CP_TYPE = new TypeReference<RestMessage<List<Cp>>>() {
    };

    @SuppressWarnings("rawtypes")
    public String getToken(String loginId, String password) throws IOException {
        String json = this.login(loginId, password);
        Map readValue = mapper.readValue(json, Map.class);
        return (String) ((Map) readValue.get("data")).get("token");
    }

    public String login(String loginId, String password) throws IOException {
        URL url = new URL(PREFIX + "/api/v1/operator/login?loginId=" + loginId + "&password=" + password);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        InputStream inputStream = con.getInputStream();
        return IOUtils.toString(inputStream, "utf8");
    }

    public String cpAccount(String token, String cp) throws IOException {
        URL url = new URL(PREFIX + "/api/v1/market/cpAccountInfo?cp=" + cp);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("X-API-TOKEN", token);
        InputStream inputStream = con.getInputStream();
        return IOUtils.toString(inputStream, "utf8");
    }


    public RestMessage<List<Cp>> cps(String token) throws IOException {
        URL url = new URL(PREFIX + "/api/v1/market/cps");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("X-API-TOKEN", token);
        InputStream inputStream = con.getInputStream();
        return mapper.readValue(IOUtils.toString(inputStream, "utf8"), CP_TYPE);
    }

    public RestMessage<List<Symbol>> symbols(String token) throws IOException {
        URL url = new URL(PREFIX + "/api/v1/market/symbols");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("X-API-TOKEN", token);
        InputStream inputStream = con.getInputStream();
        return mapper.readValue(IOUtils.toString(inputStream, "utf8"), SYMBOL_TYPE);
    }

    public String placeOrder(String token, String param) throws IOException {
//        String template = "{\"cp\": \"%s\",\"orderPrice\": %s,\"orderType\": \"%s\",\"orderVolume\": %s,\"side\": \"%s\",\"symbol\": \"%s\",\"timeInForce\": \"%s\"}";
//        String json = String.format(template, cp, orderPrice, orderType, orderVolume, side, symbol, timeInForce);
        System.out.println("request place order json: " + param);
        URL url = new URL(PREFIX + "/api/v1/trades/place");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("X-API-TOKEN", token);
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        IOUtils.write(param, con.getOutputStream(), "utf8");
        InputStream inputStream = con.getInputStream();
        return IOUtils.toString(inputStream, "utf8");
    }

    public String cpExecutionDetail(String token, long cpOrderId) throws IOException {
        URL url = new URL(PREFIX + "/api/v1/trades/cpExecutionDetail?cpOrderId=" + cpOrderId);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("X-API-TOKEN", token);
        InputStream inputStream = con.getInputStream();
        return IOUtils.toString(inputStream, "utf8");
    }

    public String cpExecutionHistory(String token, String cp, String symbol, long from, long to, Integer pageNo) throws IOException {
        String params = "";
        if (cp != null) {
            params += String.format("cp=%s&", cp);
        }
        if (symbol != null) {
            params += String.format("symbol=%s&", symbol);
        }
        if (pageNo != null) {
            params += String.format("pageNo=%s&", pageNo);
        }
        params += String.format("from=%s&to=%s", from, to);
        URL url = new URL(PREFIX + "/api/v1/trades/cpExecutionHistory?" + params);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("X-API-TOKEN", token);
        InputStream inputStream = con.getInputStream();
        return IOUtils.toString(inputStream, "utf8");
    }

    public String cpOrderHistory(String token, String cp, String symbol, String status, long from, long to, Integer pageNo) throws IOException {
        String params = "";
        if (cp != null) {
            params += String.format("cp=%s&", cp);
        }
        if (symbol != null) {
            params += String.format("symbol=%s&", symbol);
        }
        if (pageNo != null) {
            params += String.format("pageNo=%s&", pageNo);
        }
        if (status != null) {
            params += String.format("status=%s&", status);
        }
        params += String.format("from=%s&to=%s", from, to);
        URL url = new URL(PREFIX + "/api/v1/trades/cpOrderHistory?" + params);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("X-API-TOKEN", token);
        InputStream inputStream = con.getInputStream();
        return IOUtils.toString(inputStream, "utf8");
    }

    public String orderDetail(String token, long orderId) throws IOException {
        URL url = new URL(PREFIX + "/api/v1/trades/orderDetail?orderId=" + orderId);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("X-API-TOKEN", token);
        InputStream inputStream = con.getInputStream();
        return IOUtils.toString(inputStream, "utf8");
    }

    public String orderHistory(String token, String cp, String symbol, String status, long from, long to, Integer pageNo) throws IOException {
        String params = "";
        if (cp != null) {
            params += String.format("cp=%s&", cp);
        }
        if (symbol != null) {
            params += String.format("symbol=%s&", symbol);
        }
        if (pageNo != null) {
            params += String.format("pageNo=%s&", pageNo);
        }
        if (status != null) {
            params += String.format("status=%s&", status);
        }
        params += String.format("from=%s&to=%s", from, to);
        URL url = new URL(PREFIX + "/api/v1/trades/orderHistory?" + params);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("X-API-TOKEN", token);
        InputStream inputStream = con.getInputStream();
        return IOUtils.toString(inputStream, "utf8");
    }

    public String getSourceLiquidityConfig(String token,String symbol) throws IOException {
        String params = "symbol=" + symbol;
        URL url = new URL(PREFIX + "/api/v1/making/sourceLiquidityConfigs?" + params);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-API-TOKEN", token);
        InputStream inputStream = con.getInputStream();
        return IOUtils.toString(inputStream, "utf8");
    }

    public String updateSourceLiquidityConfig(String token,String symbol,String name,String param) throws IOException {
        String params = "symbol=" + symbol + "&name=" + name;
        URL url = new URL(PREFIX + "/api/v1/making/sourceLiquidityConfigs/update?"+ params);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("X-API-TOKEN", token);
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        con.setDoInput(true);
        IOUtils.write(param, con.getOutputStream(), "utf8");
        InputStream inputStream = con.getInputStream();
        return IOUtils.toString(inputStream, "utf8");
    }

    public String saveSourceLiquidityConfig(String token,String param) throws IOException {
        URL url = new URL(PREFIX + "/api/v1/making/sourceLiquidityConfigs/create");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("X-API-TOKEN", token);
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        con.setDoInput(true);
        IOUtils.write(param, con.getOutputStream(), "utf8");
        InputStream inputStream = con.getInputStream();
        return IOUtils.toString(inputStream, "utf8");
    }

    public String deleteSourceLiquidityConfig(String token, String name, String symbol) throws IOException {
        String params = "name=" + name + "&symbol=" + symbol;
        URL url = new URL(PREFIX + "/api/v1/making/sourceLiquidityConfigs/delete?" + params);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("X-API-TOKEN", token);
        InputStream inputStream = con.getInputStream();
        return IOUtils.toString(inputStream, "utf8");
    }


    public String getMakingConfig(String token, String cp, String symbol) throws IOException {
        String params = "cp=" + cp + "&symbol=" + symbol;
        URL url = new URL(PREFIX + "/api/v1/making/makingConfigs?" + params);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-API-TOKEN", token);
        InputStream inputStream = con.getInputStream();
        return IOUtils.toString(inputStream, "utf8");
    }

    public String saveMakingConfig(String token,String param) throws IOException {
        URL url = new URL(PREFIX + "/api/v1/making/makingConfigs/create");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("X-API-TOKEN", token);
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        con.setDoInput(true);
        IOUtils.write(param, con.getOutputStream(), "utf8");
        InputStream inputStream = con.getInputStream();
        return IOUtils.toString(inputStream, "utf8");
    }

    public String updateMakingConfig(String token,String cp,String symbol, String param) throws IOException {
        String params = "cp=" + cp + "&symbol=" + symbol;
        URL url = new URL(PREFIX + "/api/v1/making/makingConfigs/update?"+ params);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("X-API-TOKEN", token);
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        con.setDoInput(true);
        IOUtils.write(param, con.getOutputStream(), "utf8");
        InputStream inputStream = con.getInputStream();
        return IOUtils.toString(inputStream, "utf8");
    }

    public String deleteMakingConfig(String token, String cp, String symbol) throws IOException {
        String params = "cp=" + cp + "&symbol=" + symbol;
        URL url = new URL(PREFIX + "/api/v1/making/makingConfigs/delete?" + params);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("X-API-TOKEN", token);
        InputStream inputStream = con.getInputStream();
        return IOUtils.toString(inputStream, "utf8");
    }
}
