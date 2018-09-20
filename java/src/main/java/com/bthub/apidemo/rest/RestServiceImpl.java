package com.bthub.apidemo.rest;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class RestServiceImpl {

	public String login(String loginId, String password) throws IOException {
		URL url = new URL("http://192.168.1.215:8081/api/v1/operator/login?loginId=" + loginId + "&password=" + password);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		InputStream inputStream = con.getInputStream();
		return IOUtils.toString(inputStream, "utf8");
	}

	public String cps(String token) throws IOException {
		URL url = new URL("http://192.168.1.215:8081/api/v1/market/cps");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("X-API-TOKEN", token);
		InputStream inputStream = con.getInputStream();
		return IOUtils.toString(inputStream, "utf8");
	}

	public String symbols(String token) throws IOException {
		URL url = new URL("http://192.168.1.215:8081/api/v1/market/symbols");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("X-API-TOKEN", token);
		InputStream inputStream = con.getInputStream();
		return IOUtils.toString(inputStream, "utf8");
	}

	public String placeOrder(String token, int cpId, double orderPrice, String orderType, BigDecimal orderVolume, String side, int symbolId, String timeInForce) throws IOException {
		String template = "{\"cpId\": %s,\"orderPrice\": %s,\"orderType\": \"%s\",\"orderVolume\": %s,\"side\": \"%s\",\"symbolId\": %s,\"timeInForce\": \"%s\"}";
		String json = String.format(template, cpId, orderPrice, orderType, orderVolume, side, symbolId, timeInForce);
		URL url = new URL("http://192.168.1.215:8081/api/v1/trades/place");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		IOUtils.write(json, con.getOutputStream(), "utf8");
		con.setRequestProperty("X-API-TOKEN", token);
		con.setRequestMethod("POST");
		InputStream inputStream = con.getInputStream();
		return IOUtils.toString(inputStream, "utf8");
	}

	public String cpExecutionDetail(String token, long orderId) throws IOException {
		URL url = new URL("http://192.168.1.215:8081/api/v1/trades/cpExecutionDetail?orderId=" + orderId);
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
		URL url = new URL("http://192.168.1.215:8081/api/v1/trades/cpExecutionHistory?" + params);
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
		URL url = new URL("http://192.168.1.215:8081/api/v1/trades/cpOrderHistory?" + params);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("X-API-TOKEN", token);
		InputStream inputStream = con.getInputStream();
		return IOUtils.toString(inputStream, "utf8");
	}

	public String orderDetail(String token, long sourceId) throws IOException {
		URL url = new URL("http://192.168.1.215:8081/api/v1/trades/orderDetail?sourceId=" + sourceId);
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
		URL url = new URL("http://192.168.1.215:8081/api/v1/trades/orderHistory?" + params);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("X-API-TOKEN", token);
		InputStream inputStream = con.getInputStream();
		return IOUtils.toString(inputStream, "utf8");
	}

}
