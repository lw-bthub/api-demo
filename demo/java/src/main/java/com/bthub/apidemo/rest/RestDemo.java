package com.bthub.apidemo.rest;

import org.apache.commons.lang3.StringUtils;

public class RestDemo {
	
	static String param = "";
	
	public static void main(String[] args) throws Exception {

		RestServiceImpl service = new RestServiceImpl();
		
		// login
		String token = service.getToken("Jerry02", "123456");
		if (StringUtils.isBlank(token))
			return;
		System.out.println("token:" + token);

		// cps
		System.out.println("cps: " + service.cps(token));

		// symbols
		System.out.println("symbols: " + service.symbols(token));

		// cpAccount
		System.out.println("cpAccount: " + service.cpAccount(token, "huobi"));

        // getMakingConfig
        System.out.println("search makingConfig: " + service.getMakingConfig(token, "ampex", "EOSUSDT"));

        // updateMakingConfig
        param = "{\"frequency\":4,\"l1Config\":\"EOSUSDT\",\"l1ConfigType\":\"SOURCE_LIQUIDITY\",\"l1LadderDepth\":4,\"l1MaxDeviation\":\"4\",\"l1MinSpread\":\"4\",\"l1OrderActive\":true,\"l1StepHeight\":\"4\",\"l1TickSize\":\"4\",\"l2LadderDepth\":4,\"l2MaxDeviation\":\"4\",\"l2MaxVolume\":\"4\",\"l2MinSpread\":\"4\",\"l2MinThreshold\":\"0.4\",\"l2MinVolume\":\"4\",\"l2OrderActive\":true,\"l2TickSize\":\"4\",\"maxTradeVolumeRatio\":\"4\",\"minTradeVolumeRatio\":\"4\",\"symbol\":\"EOSUSDT\",\"tradeActive\":true,\"tradePriceAdjustRatio\":\"4\",\"tradePriceType\":\"LIQUIDITY_DEMANDER\",\"tradeRefSpread\":\"4\",\"tradeSendRatio\":\"4\",\"tradeType\":\"TOB\",\"tradeVolumeDeduct\":true,\"tradeVolumeLowerLimit\":\"4\",\"tradeVolumeUpperLimit\":\"4\"}";
        System.out.println("update makingConfig: " + service.updateMakingConfig(token,"ampex","EOSUSDT", param));

        //deleteMakingConfig
        System.out.println("delete makingConfig: " + service.deleteMakingConfig(token, "ampex", "EOSUSDT"));

        //addMakingConfig
        param = "{\"cp\":\"ampex\",\"frequency\":1,\"l1Config\":\"EOSUSDT\",\"l1ConfigType\":\"SOURCE_LIQUIDITY\",\"l1LadderDepth\":2,\"l1MaxDeviation\":\"3\",\"l1MinSpread\":\"4\",\"l1OrderActive\":true,\"l1StepHeight\":\"5\",\"l1TickSize\":\"1\",\"l2LadderDepth\":7,\"l2MaxDeviation\":\"8\",\"l2MaxVolume\":\"9\",\"l2MinSpread\":\"10\",\"l2MinThreshold\":\"1\",\"l2MinVolume\":\"1\",\"l2OrderActive\":true,\"l2TickSize\":\"13\",\"maxTradeVolumeRatio\":\"14\",\"minTradeVolumeRatio\":\"1\",\"symbol\":\"EOSUSDT\",\"tradeActive\":true,\"tradePriceAdjustRatio\":\"16\",\"tradePriceType\":\"LIQUIDITY_DEMANDER\",\"tradeRefSpread\":\"17\",\"tradeSendRatio\":\"18\",\"tradeType\":\"MID\",\"tradeVolumeDeduct\":true,\"tradeVolumeLowerLimit\":\"19\",\"tradeVolumeUpperLimit\":\"20\"}";
        System.out.println("save makingConfig: " + service.saveMakingConfig(token,param));
        
        //getSourceLiquidityConfig
        System.out.println("get sourceLiquidityConfig: " + service.getSourceLiquidityConfig(token,"ETHUSDT"));

        //updateSourceLiquidityConfig
        param ="{\"askPriceAdjustRatio\":\"3\",\"askPriceAdjustValue\":\"3\",\"askVolumeAdjustRatio\":\"3\",\"baseCp\":\"huobi\",\"bidPriceAdjustRatio\":\"3\",\"bidPriceAdjustValue\":\"3\",\"bidVolumeAdjustRatio\":\"3\",\"maxVolume\":\"3\",\"maxVolumeRatio\":\"3\",\"name\":\"ETHUSDT3\",\"priceAdjustType\":\"VALUE\",\"refCps\":[\"huobi\"]}";
        System.out.println("update sourceLiquidityConfig: " + service.updateSourceLiquidityConfig(token,"ETHUSDT","ETHUSDT1",param));

        //deleteMakingConfig
        System.out.println("delete makingConfig: " + service.deleteSourceLiquidityConfig(token, "ETHUSDT1", "ETHUSDT"));

        //addSourceLiquidityConfig
        param ="{\"askPriceAdjustRatio\":\"2\",\"askPriceAdjustValue\":\"2\",\"askVolumeAdjustRatio\":\"2\",\"baseCp\":\"huobi\",\"bidPriceAdjustRatio\":\"2\",\"bidPriceAdjustValue\":\"2\",\"bidVolumeAdjustRatio\":\"2\",\"maxVolume\":\"2\",\"maxVolumeRatio\":\"2\",\"name\":\"ETHUSDT1\",\"priceAdjustType\":\"VALUE\",\"refCps\":[\"huobi\"],\"symbol\":\"ETHUSDT\"}";
        System.out.println("save SourceLiquidityConfig: " + service.saveSourceLiquidityConfig(token,param));
        
        //placeOrder
        param = "{\"book\":\"\",\"clientOrderId\":\"0001\",\"cps\":[\"bc\",\"huobi\",\"okex\"],\"slippage\":0.01,\"orderPrice\":0,\"orderType\":\"SLIPPAGE\",\"orderVolume\":0.01,\"side\":\"SELL\",\"symbol\":\"BTCUSDT\",\"timeInForce\":\"IOC\"}";
        System.out.println("placeOrder: " + service.placeOrder(token, param));

        //orderHistory
        System.out.println("orderHistory: " + service.orderHistory(token, null, null, "", 1572969600000L, 1573142399000L, 1));

        // orderDetail
        System.out.println("orderDetail: " + service.orderDetail(token, 1019385207034916885L));

        // cpOrderHistory
        System.out.println("cpOrderHistory: " + service.cpOrderHistory(token, "", "", "", 1572969600000L, 1573142399000L, 1));

        // cpExecutionHistory
        System.out.println("cpExecutionHistory: " + service.cpExecutionHistory(token, "", "", 1573056000000L, 1573142399000L, 1));

        // cpExecutionDetail
        System.out.println("cpExecutionDetail: " + service.cpExecutionDetail(token, 1019385207034917397L));
	}

}
