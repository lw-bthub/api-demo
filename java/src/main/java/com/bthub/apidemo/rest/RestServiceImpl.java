package com.bthub.apidemo.rest;

import static com.bthub.apidemo.common.Consts.HOST;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.bthub.apidemo.dto.CpAccount;
import org.apache.commons.io.IOUtils;

import com.bthub.apidemo.dto.Cp;
import com.bthub.apidemo.dto.RestMessage;
import com.bthub.apidemo.dto.Symbol;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestServiceImpl {
	private static final String PREFIX = "http://" + HOST;
	private static final ObjectMapper mapper = new ObjectMapper();
	private static final TypeReference<RestMessage<List<Symbol>>> SYMBOL_TYPE = new TypeReference<RestMessage<List<Symbol>>>() {};
	private static final TypeReference<RestMessage<List<Cp>>> CP_TYPE = new TypeReference<RestMessage<List<Cp>>>() {};

	@SuppressWarnings("rawtypes")
	public String getToken(String loginId, String password) throws IOException {
		String json = this.login("API01", "1qaz1qaz");
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

	public RestMessage<List<CpAccount>> cpAccount(String token, String cp) throws IOException {
		URL url = new URL(PREFIX + "/api/v1/market/cpAccountInfo");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("X-API-TOKEN", token);
		InputStream inputStream = con.getInputStream();
		return mapper.readValue(IOUtils.toString(inputStream, "utf8"), CP_TYPE);
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

	public String placeOrder(String token, int cpId, double orderPrice, String orderType, double orderVolume, String side, int symbolId, String timeInForce) throws IOException {
		String template = "{\"cpId\": %s,\"orderPrice\": %s,\"orderType\": \"%s\",\"orderVolume\": %s,\"side\": \"%s\",\"symbolId\": %s,\"timeInForce\": \"%s\"}";
		String json = String.format(template, cpId, orderPrice, orderType, orderVolume, side, symbolId, timeInForce);
		System.out.println("place order json: " + json);
		URL url = new URL(PREFIX + "/api/v1/trades/place");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("X-API-TOKEN", token);
		con.setRequestProperty("Content-Type", "application/json");
		con.setDoOutput(true);
		IOUtils.write(json, con.getOutputStream(), "utf8");
		InputStream inputStream = con.getInputStream();
		return IOUtils.toString(inputStream, "utf8");
	}

	public String cpExecutionDetail(String token, long orderId) throws IOException {
		URL url = new URL(PREFIX + "/api/v1/trades/cpExecutionDetail?orderId=" + orderId);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("X-API-TOKEN", token);
		InputStream inputStream = con.getInputStream();
		return IOUtils.toString(inputStream, "utf8");
	}

	public String cpExecutionHistory(String token, Integer cpId, Integer symbolId, long from, long to, Integer pageNo) throws IOException {
		String params = "";
		if (cpId != null) {
			params += String.format("cpId=%s&", cpId);
		}
		if (symbolId != null) {
			params += String.format("symbolId=%s&", symbolId);
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

	public String cpOrderHistory(String token, Integer cpId, Integer symbolId, String status, long from, long to, Integer pageNo) throws IOException {
		String params = "";
		if (cpId != null) {
			params += String.format("cpId=%s&", cpId);
		}
		if (symbolId != null) {
			params += String.format("symbolId=%s&", symbolId);
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

	public String orderDetail(String token, long sourceId) throws IOException {
		URL url = new URL(PREFIX + "/api/v1/trades/orderDetail?sourceId=" + sourceId);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("X-API-TOKEN", token);
		InputStream inputStream = con.getInputStream();
		return IOUtils.toString(inputStream, "utf8");
	}

	public String orderHistory(String token, Integer cpId, Integer symbolId, String status, long from, long to, Integer pageNo) throws IOException {
		String params = "";
		if (cpId != null) {
			params += String.format("cpId=%s&", cpId);
		}
		if (symbolId != null) {
			params += String.format("symbolId=%s&", symbolId);
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

}
