package com.bthub.apidemo.rest;

public class RestDemo {

	private static RestServiceImpl SERVICE = new RestServiceImpl();
	// 从login方法获得, get from login
	private static final String TOKEN = "NmJDeVdsTmYtM2g5QW0zR3VPRkViQSIsImFsZyI6IkEyNTZHQ01LVyIsIml2IjoicklibWxXalBnSTEyLWVQdSJ9.ZN5Rs0t6TxR7_kDJoBAoMa0Ik_2ClogPWLPj3WmGin4.LoJBwQEJCoxau95A.eXfQaMTtouve-WZ7y4iHfjtjUsTwYm93s1Ayvahkb2DAfQkGXFZSkyn_qtFculrHTnWuHfl3Qi5rNZlLvvpG_pdlfByFDtgCAqI8HQ3EzicFLaV1DhBrjwkHVd9p3yYAgh4bq4FY2mDWkvt-4J8woINFCVvpCE3aB6MOms8GukB34-3pVz7Mg4WBlQAwMdr7APGuy0VjM5ODpvxRJ3YdYSQ.Fc-ouR7MPA0JrShAKRbbqg";
	
	public static void main(String[] args) throws Exception {
		System.out.println(SERVICE.login("API01", "1qaz1qaz"));
//		System.out.println(SERVICE.cps(TOKEN));
//		System.out.println(SERVICE.symbols(TOKEN));
//		System.out.println(SERVICE.symbols(TOKEN));
//		System.out.println(SERVICE.placeOrder(TOKEN, 257, 6400, orderType, orderVolume, side, symbolId, timeInForce));
	}

}
