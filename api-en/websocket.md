# Websocket (2018-12-28)


- Websocket url:     
    production environment：wss://trade.bthub.com:444    
    test environment：wss://demo.bthub.com:444    
- Websocket request ,login required。
- when connection is created,  login required, then can subscribe and unsubscribe
- when connection is created,  required to send regular-'ping' to keep it alive. period:30 minutes.


## API LIST

| request                       | description                 |
| :---------------------------- | -------------------- |
| [subscribe:apiOrder](#subscribe-order-trading-result)             | subscribe order trading result     |
| [unsubscribe:apiOrder](#subscribe-order-trading-result)           | unsubscribe order trading result |
| [subscribe:apiQuote:symbol](#subscribe-market-quotation)    | subscribe market quotation     (symbol:crypto pairs name)    |
| [unsubscribe:apiQuote:symbol](#subscribe-market-quotation)  | unsubscribe market quotation     (symbol:crypto pairs name)  |
| [subscribe:apiAggregatedQuote:symbol](#subscribe-aggregation-quotation)    | subscribe aggregation quotation    (symbol:crypto pairs name)    |
| [unsubscribe:apiAggregatedQuote:symbol](#subscribe-aggregation-quotation)  | unsubscribe aggregation quotation   (symbol:crypto pairs name)  |
| [subscribe:apiRiskPosition:all:book](#subscribe risk)    | subscribe risk    (book: book abbreviation)    |
| [unsubscribe:apiRiskPosition:all:book](#subscribe risk)  | unsubscribe risk   (book: book abbreviation)  |
| [ping]| heart beat |


## WEBSOCKET API for creating connection

wss://demo.bthub.com:444/api/realtime?X-API-TOKEN=WHZWUFAxWlV0bzdMMzl5N1dmYy1z    

X-API-TOKEN:token(acquired from login）

### subscribe market quotation
***request instruction***

| request                      | description        |
| :---------------------------- | :--------------- |
| subscribe:apiQuote:symbol   | subscribe new market quotation     |
| unsubscribe:apiQuote:symbol | unsubscribe new market quotation |

 ***params of return***

| NAME       | TYPE   | DESCRIBE        |
| :--------- | :----- | :-------------- |
| event      | string | event(API_QUOTE) |
| commission | number | commission fee   |
| cp         | string | counter party name      |
| symbol     | string | crypto pairs name       |
| price      | number | price          |
| volume     | number  | volume           |

 ***example of return***

```
 {
 	"event": "API_QUOTE",
 	"data": {
 		"asks": [{
 			"price": "5379.3864",
 			"volume": "0.1"
 		}, {
 			"price": "5379.3865",
 			"volume": "0.166"
 		}, {
 			"price": "5379.6339",
 			"volume": "0.001"
 		}, {
 			"price": "5385.3535",
 			"volume": "1.89179998"
 		}, {
 			"price": "5385.3536",
 			"volume": "0.001"
 		}],
 		"bids": [{
 			"price": "5376.0837",
 			"volume": "0.40748547"
 		}, {
 			"price": "5376.0836",
 			"volume": "0.33848547"
 		}, {
 			"price": "5375.4579",
 			"volume": "1"
 		}, {
 			"price": "5375.4207",
 			"volume": "0.00885"
 		}, {
 			"price": "5375.3574",
 			"volume": "0.00978"
 		}],
 		"commission": "0.0001",
 		"cp": "okex",
 		"symbol": "BTCUSDT"
 	}
 }
```

### subscribe order trading result
***order request***

| request             | description                 |
| :------------------- | :------------------- |
| subscribe:apiOrder   | subscribe order trading result     |
| unsubscribe:apiOrder | unsubscribe order trading result |

 ***params of order trading result***

| NAME          | TYPE       | DESCRIBE              |
| :------------ | :--------- | :-------------------- |
| event         | string     | event(API_ORDER)       |
| cpOrderId     | integer    | CP order ID          |
| symbol        | string     | crypto pairs name              |
| orderId       | integer    | parent order ID                |
| side          | string     | BUY or SELL(Side)]        |
| status        | string     | Order Status     |
| orderType     | string     | Order Type  |
| executeAmount | number     | executed Amount              |
| executeVolume | number     | executed Volume              |
| orderVolume   | number     | order Volume              |
| pendingVolume | number     | pending Volume             |
| executeTime   | integer    | executed Time               |
| orderTime     | integer    | place order Time              |
| commission    | number     | commission                |
| timeInForce   | string     | Time In Force |
| orderResult   | string     | Order Result    |
| orderComment  | string     | comments                 |

  ***example of order trading result***

```
  {
  	"event": "API_ORDER",
  	"data": {
  		"cpOrders": [{
  			"commission": "0.0100",
  			"cp": "binance",
  			"cpOrderId": "764451239273443359",
  			"executeAmount": "177.1343336000000000",
  			"executeTime": "1542703689751",
  			"executeVolume": "0.04018000",
  			"executions": [{
  				"commission": "0.17713433",
  				"cp": "binance",
  				"cpExecutionid": "764451245254521375",
  				"executeAmount": "177.1343336000000000",
  				"executeComment": "CommissionAsset: USDT",
  				"executePrice": "4408.52000000",
  				"executeTime": "1542703689751",
  				"executeVolume": "0.04018000",
  				"side": -1,
  				"symbol": "BTCUSDT"
  			}],
  			"orderComment": "764451230726985237.0",
  			"orderResult": 3,
  			"orderTime": "1542703689130",
  			"orderType": 5,
  			"orderVolume": "0.04018",
  			"pendingVolume": "0.00000000",
  			"side": -1,
  			"status": 4,
  			"symbol": "BTCUSDT",
  			"timeInForce": 1
  		}],
  		"executeAmount": "177.1343336000000000",
  		"executeTime": "1542703689751",
  		"executeVolume": "0.04018000",
  		"orderId": "764451239265054239",
  		"orderResult": 5,
  		"orderTime": "1542703689130",
  		"orderType": 5,
  		"orderVolume": "0.1",
  		"pendingVolume": "0.05982000",
  		"side": -1,
  		"status": 4,
  		"symbol": "BTCUSDT",
  		"timeInForce": 1
  	}
  }
```


### subscribe aggregation quotation
***request instruction***

| request                      | description             |
| :---------------------------- | :--------------- |
| subscribe:apiAggregatedQuote:symbol   | subscribe aggregation quotation     |
| unsubscribe:apiAggregatedQuote:symbol | unsubscribe aggregation quotation |

 ***params of return***

| NAME       | TYPE   | DESCRIBE        |
| :--------- | :----- | :-------------- |
| event      | string | event(API_AGGREGATED_QUOTE) |
| cp         | string | counter party name                |
| symbol     | string | crypto pair name              |
| price      | number | price          |
| volume     | number | volume           |

 ***example of return***

```
 {
 	"event": "API_AGGREGATED_QUOTE",
 	"data": {
 		"asks": [{
 			"cp": "okex",
 			"price": "5378.18262",
 			"volume": "0.00100"
 		}, {
 			"cp": "okex",
 			"price": "5378.31774",
 			"volume": "1.00000"
 		}, {
 			"cp": "okex",
 			"price": "5378.50576",
 			"volume": "0.20000"
 		}, {
 			"cp": "okex",
 			"price": "5378.67577",
 			"volume": "1.00000"
 		}, {
 			"cp": "okex",
 			"price": "5379.02941",
 			"volume": "1.00000"
 		}, {
 			"cp": "binance",
 			"price": "5421.76768",
 			"volume": "0.01488"
 		}, {
 			"cp": "binance",
 			"price": "5422.36364",
 			"volume": "0.00547"
 		}, {
 			"cp": "binance",
 			"price": "5425.82829",
 			"volume": "1.88220"
 		}, {
 			"cp": "binance",
 			"price": "5425.87879",
 			"volume": "0.50000"
 		}, {
 			"cp": "binance",
 			"price": "5427.13132",
 			"volume": "1.17530"
 		}, {
 			"cp": "huobi",
 			"price": "5429.43435",
 			"volume": "0.06310"
 		}, {
 			"cp": "huobi",
 			"price": "5429.44445",
 			"volume": "0.07530"
 		}],
 		"bids": [{
 			"cp": "okex",
 			"price": "5376.75877",
 			"volume": "1.37200"
 		}, {
 			"cp": "okex",
 			"price": "5373.53419",
 			"volume": "0.20828"
 		}, {
 			"cp": "okex",
 			"price": "5373.25302",
 			"volume": "0.00100"
 		}, {
 			"cp": "okex",
 			"price": "5372.76346",
 			"volume": "0.86400"
 		}, {
 			"cp": "okex",
 			"price": "5372.56748",
 			"volume": "0.22866"
 		}, {
 			"cp": "huobi",
 			"price": "5318.87400",
 			"volume": "0.19130"
 		}, {
 			"cp": "huobi",
 			"price": "5317.31970",
 			"volume": "2.30760"
 		}, {
 			"cp": "binance",
 			"price": "5311.43910",
 			"volume": "1.19375"
 		}, {
 			"cp": "binance",
 			"price": "5311.42920",
 			"volume": "0.05459"
 		}, {
 			"cp": "binance",
 			"price": "5311.41930",
 			"volume": "2.28811"
 		}, {
 			"cp": "binance",
 			"price": "5311.40940",
 			"volume": "0.20774"
 		}, {
 			"cp": "binance",
 			"price": "5311.37970",
 			"volume": "0.50000"
 		}],
 		"symbol": "BTCUSDT"
 	}
 }
```



### subscribe risk
***request instruction***

| request                      | description             |
| :---------------------------- | :--------------- |
| subscribe:apiRiskPosition:all:book    | subscribe risk     (book:book abbreviation)    |
| unsubscribe:apiRiskPosition:all:book  | unsubscribe risk   (book:book abbreviation)  |

 ***params of return***

| NAME       | TYPE   | DESCRIBE        |
| :--------- | :----- | :-------------- |
| event      | string | event (API_RISK_POSITION) |
| book         | string | book abbreviation                |
| cp     | string | counter party name            |
| openAmount     | string | open amount              |
| openVolume     | string | open volume              |
| symbol     | string | crypto pair name              |



 ***example of return***
 ```
{
  "event": "API_RISK_POSITION",
  "data": [
    {
      "book": "B",
      "cp": "binance",
      "openAmount": "266.428871696500",
      "openVolume": "-0.071040000000",
      "symbol": "BTCUSDT10"
    }
  ]
}
 ```
