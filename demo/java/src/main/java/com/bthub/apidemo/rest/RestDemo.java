package com.bthub.apidemo.rest;

public class RestDemo {

	public static void main(String[] args) throws Exception {
		RestServiceImpl service = new RestServiceImpl();

		//login
		String token = service.getToken("mhuangwei", "1qaz1qaz");

		//cpAccount
		System.out.println("cpAccount: "+service.cpAccount(token,"huobi"));

		//cps
		System.out.println("cps: "+service.cps(token));

		//symbols
		System.out.println("symbols: "+service.symbols(token));

		//placeOrder
		System.out.println("placeOrder: "+service.placeOrder(token, "huobi", 6400, "MARKET", 0.01, "SELL", "BTCUSDT", "IOC"));
	}

}
