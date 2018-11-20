package com.bthub.apidemo.rest;

public class RestDemo {

	public static void main(String[] args) throws Exception {
		RestServiceImpl service = new RestServiceImpl();

		//login
		String token = service.getToken("mhuangwei", "1qaz1qaz");

//		//cpAccount
		System.out.println("cpAccount: "+service.cpAccount(token,"huobi"));
//
//		//cps
		System.out.println("cps: "+service.cps(token));
//
//		//symbols
		System.out.println("symbols: "+service.symbols(token));
//
//		//placeOrder
		System.out.println("placeOrder: "+service.placeOrder(token, "", 6400, "MARKET", 0.01, "BUY", "BTCUSDT", "IOC"));

        //orderHistory
		System.out.println("orderHistory: "+service.orderHistory(token,null,null,"",1542668400000l,1542753600000l,1));

		//orderDetail
		System.out.println("orderDetail: "+service.orderDetail(token,764554782160463391l));

		//cpOrderHistory
		System.out.println("cpOrderHistory: "+service.cpOrderHistory(token,"","","",1542668400000l,1542753600000l,1));

		//cpExecutionHistory
		System.out.println("cpExecutionHistory: "+service.cpExecutionHistory(token,"","",1542668400000l,1542753600000l,1));

		//cpExecutionDetail
		System.out.println("cpExecutionDetail: "+service.cpExecutionDetail(token,764554782160463903l));
	}

}
