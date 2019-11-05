package com.bthub.apidemo.rest;

import org.apache.commons.lang3.StringUtils;

public class RestDemo {

    public static void main(String[] args) throws Exception {

        RestServiceImpl service = new RestServiceImpl();

        // login
        String token = service.getToken("Jerry02", "123456");
        if(StringUtils.isBlank(token)) return;
        System.out.println("token:"+token);
        
        // getMakingConfig
        System.out.println("search makingConfig: " + service.getMakingConfig(token, "ampex", "EOSUSDT"));

        // updateMakingConfig
        String param = "{\"cp\":\"ampex\",\"frequency\":20,\"l1Config\":\"EOSUSDT\",\"l1ConfigType\":\"SOURCE_LIQUIDITY\",\"l1LadderDepth\":15,\"l1MaxDeviation\":\"99.99\",\"l1MinSpread\":\"0.001\",\"l1OrderActive\":false,\"l1StepHeight\":\"0.0001\",\"l1TickSize\":\"0.0001\",\"l2LadderDepth\":30,\"l2MaxDeviation\":\"0.1\",\"l2MaxVolume\":\"0.01\",\"l2MinSpread\":\"0.0213\",\"l2MinThreshold\":\"0.0073\",\"l2MinVolume\":\"0.01\",\"l2OrderActive\":false,\"l2TickSize\":\"0.0001\",\"maxTradeVolumeRatio\":\"100\",\"minTradeVolumeRatio\":\"100\",\"symbol\":\"EOSUSDT\",\"tradeActive\":false,\"tradePriceAdjustRatio\":\"99.99\",\"tradePriceType\":\"LIQUIDITY_DEMANDER\",\"tradeRefSpread\":\"0.008\",\"tradeSendRatio\":\"100\",\"tradeType\":\"MID\",\"tradeVolumeDeduct\":false,\"tradeVolumeLowerLimit\":\"0.1\",\"tradeVolumeUpperLimit\":\"20\"}";
        System.out.println("update makingConfig: " + service.updateMakingConfig(token,"ampex","EOSUSDT", param));

        //deleteMakingConfig
        System.out.println("delete makingConfig: " + service.deleteMakingConfig(token, "ampex", "EOSUSDT"));

        //addMakingConfig
        param = "{\"cp\":\"ampex\",\"frequency\":1,\"l1Config\":\"EOSUSDT\",\"l1ConfigType\":\"SOURCE_LIQUIDITY\",\"l1LadderDepth\":2,\"l1MaxDeviation\":\"3\",\"l1MinSpread\":\"4\",\"l1OrderActive\":false,\"l1StepHeight\":\"5\",\"l1TickSize\":\"1\",\"l2LadderDepth\":7,\"l2MaxDeviation\":\"8\",\"l2MaxVolume\":\"9\",\"l2MinSpread\":\"10\",\"l2MinThreshold\":\"1\",\"l2MinVolume\":\"1\",\"l2OrderActive\":false,\"l2TickSize\":\"13\",\"maxTradeVolumeRatio\":\"14\",\"minTradeVolumeRatio\":\"1\",\"symbol\":\"EOSUSDT\",\"tradeActive\":false,\"tradePriceAdjustRatio\":\"16\",\"tradePriceType\":\"LIQUIDITY_DEMANDER\",\"tradeRefSpread\":\"17\",\"tradeSendRatio\":\"18\",\"tradeType\":\"MID\",\"tradeVolumeDeduct\":false,\"tradeVolumeLowerLimit\":\"19\",\"tradeVolumeUpperLimit\":\"20\"}";
        System.out.println("save makingConfig: " + service.saveMakingConfig(token,param));

//        // cpAccount
//        System.out.println("cpAccount: " + service.cpAccount(token, "huobi"));
//
//        // cps
//        System.out.println("cps: " + service.cps(token));
//
//        // symbols
//        System.out.println("symbols: " + service.symbols(token));
//
//
//        //getSourceLiquidityConfig
//        System.out.println("get sourceLiquidityConfig: " + service.getSourceLiquidityConfig(token,"ETHUSDT"));
//
//        //updateSourceLiquidityConfig
//        param ="{\"askPriceAdjustRatio\":\"60\",\"askPriceAdjustValue\":\"80\",\"askVolumeAdjustRatio\":\"40\",\"baseCp\":\"huobi\",\"bidPriceAdjustRatio\":\"50\",\"bidPriceAdjustValue\":\"70\",\"bidVolumeAdjustRatio\":\"30\",\"maxVolume\":\"10\",\"maxVolumeRatio\":\"20\",\"name\":\"ETHUSDT\",\"priceAdjustType\":\"VALUE\",\"refCps\":[\"bc\",\"huobi\"],\"symbol\":\"ETHUSDT\"}";
//        System.out.println("update sourceLiquidityConfig: " + service.updateSourceLiquidityConfig(token,"ETHUSDT","ETHUSDT",param));
//
//        //deleteMakingConfig
//        System.out.println("delete makingConfig: " + service.deleteSourceLiquidityConfig(token, "ETHUSDT1", "ETHUSDT"));
//
//        //addSourceLiquidityConfig
//        param ="{\"askPriceAdjustRatio\":\"60\",\"askPriceAdjustValue\":\"80\",\"askVolumeAdjustRatio\":\"40\",\"baseCp\":\"huobi\",\"bidPriceAdjustRatio\":\"50\",\"bidPriceAdjustValue\":\"70\",\"bidVolumeAdjustRatio\":\"30\",\"maxVolume\":\"10\",\"maxVolumeRatio\":\"20\",\"name\":\"ETHUSDT1\",\"priceAdjustType\":\"VALUE\",\"refCps\":[\"bc\",\"huobi\"],\"symbol\":\"ETHUSDT\"}";
//        System.out.println("save SourceLiquidityConfig: " + service.saveSourceLiquidityConfig(token,param));
//        
//        //placeOrder
//        param = "{\"book\":\"\",\"clientOrderId\":\"0001\",\"cps\":[\"bc\",\"huobi\",\"okex\"],\"slippage\":0.01,\"orderPrice\":0,\"orderType\":\"SLIPPAGE\",\"orderVolume\":0.01,\"side\":\"BUY\",\"symbol\":\"BTCUSDT\",\"timeInForce\":\"IOC\"}";
//        System.out.println("placeOrder: " + service.placeOrder(token, param));
//
//        //orderHistory
//        System.out.println("orderHistory: " + service.orderHistory(token, null, null, "", 1572451200000L, 1572537599000L, 1));
//
//        // orderDetail
//        System.out.println("orderDetail: " + service.orderDetail(token, 1014509338802274837L));
//
//        // cpOrderHistory
//        System.out.println("cpOrderHistory: " + service.cpOrderHistory(token, "", "", "", 1572451200000L, 1572537599000L, 1));
//
//        // cpExecutionHistory
//        System.out.println("cpExecutionHistory: " + service.cpExecutionHistory(token, "", "", 1572451200000L, 1572537599000L, 1));
//
//        // cpExecutionDetail
//        System.out.println("cpExecutionDetail: " + service.cpExecutionDetail(token, 1014509338802275349L));
    }

}
