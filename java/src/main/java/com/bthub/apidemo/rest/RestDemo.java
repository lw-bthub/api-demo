package com.bthub.apidemo.rest;

public class RestDemo {

	public static void main(String[] args) throws Exception {
		RestServiceImpl service = new RestServiceImpl();
		String token = service.getToken("API01", "1qaz1qaz");
		System.out.println(token);
//		System.out.println(service.cps(token));
//		System.out.println(service.symbols(token));
//		System.out.println(service.symbols(token));
		System.out.println(service.placeOrder(token, 257, 6400, "LIMIT", 0.001, "BUY", 1, "IOC"));
	}

}
