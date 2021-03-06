# Restful API informations(2019-01-29)


- API url    
    live environment：https://trade.bthub.com:444/  
    test environment：https://demo.bthub.com:444/     
- API test tools   
    live environment：https://trade.bthub.com:444/swagger-ui.html    
    test environment：https://demo.bthub.com:444/swagger-ui.html 

## API LIST

| request                                    | type | description                   |
| :------------------------------------------ | :--- | :--------------------- |
| [/api/v1/operator/login](#login)                   | POST | login                   |
| [/api/v1/market/cps](#get-counter-party-list)                       | GET  | get counter party list          |
| [/api/v1/market/symbols](#get-crypto-pairs-list)                   | GET  | get crypto pairs list       |
| [/api/v1/trades/place](#place-order)                     | POST | place orders (SOR)               |
| [/api/v1/trades/orderDetail](#get-detail-of-orders)               | GET  | get  detail  of orders         |
| [/api/v1/trades/clientOrderDetail](#get-detail-of-client-Orders)               | GET  | get  detail  of client orders         |
| [/api/v1/trades/orderHistory](#get-history-list-of-orders)              | GET  | get history  list of orders   |
| [/api/v1/trades/cpOrderHistory](#get-CP-history-list-of-placed-orders)            | GET  | get CP history list of placed orders |
| [/api/v1/trades/cpExecutionHistory](#get-CP-history-list-of-executed-orders)        | GET  | get CP history list of executed orders |
| [/api/v1/trades/cpExecutionDetail](#get-CP-detail-of-executed-order)         | GET  | get CP detail of executed orders         |
| [/api/v1/market/cpAccountInfo](#get-account-info)             | GET  | get account info         |
| [/api/v1/risk/books](#get-book-info)  | GET  | get book info         |
| [/api/v1/risk/positions](#get-risk-info)  | GET  | get risk info         |
| [/api/v1/risk/statements](#get-statement-info)  | GET  | get statement info         |
| [/api/v1/making/makingConfigs](#get-making-config)  | GET  | get making config         |
| [/api/v1/making/makingConfigs/create](#add-making-config)  | PUT  | add making config         |
| [/api/v1/making/makingConfigs/update](#update-making-config)  | POST  | update making config         |
| [/api/v1/making/makingConfigs/delete](#delete-making-config)  | DELETE  | delete making config         |
| [/api/v1/making/sourceLiquidityConfigs](#get-source-liquidity-config)  | GET  | get sourceLiquidity config         |
| [/api/v1/making/sourceLiquidityConfigs/create](#add-source-liquidity-config)  | POST  | add sourceLiquidity config         |
| [/api/v1/making/sourceLiquidityConfigs/update](#update-source-liquidity-config)  | PUT  | update sourceLiquidity config         |
| [/api/v1/making/sourceLiquidityConfigs/delete](#delete-source-liquidity-config)  | DELETE  | delete sourceLiquidity config         |

## Restful API
### login
POST /api/v1/operator/login

***request params***

| NAME     | REQUIRED | TYPE   | DESCRIPTION | DEFAULT | VALUES RANGE |
| :------- | :------- | :----- | :------- | :------ | :----------- |
| loginId  | Y        | string | id    |         |              |
| password | Y        | string | password      |         |              |

***params of return***

| NAME  | TYPE   | DESCRIPTION |
| :---- | :----- | :------- |
| token | string | token    |

***example of return***

```
{
  "data": {
    "token": "ZElHYkFsRktuZDduUG1udzI2V1lldyIsImFsZyI6IkEyNTZHQ01LVyIsIml2IjoicjZzLU83TGlYTUFYVEVxeSJ9.92p5FlhYwx6YCLeUlh-rlE3o_8.-wL8D1uL3GEEE3kj.qmBbSsSy92nYBt4WOLbU5MCH1NPbXO6k6_b5uGEG63xcQJ-Ny9K1VCMRtChQRol6l6fb5rNobNnOFAgeYzy2cqkje4HgUlL3BSRNlDj7G6W-60MwM2af7U2xshESv8LqLux2GZxPzCBmJz__HgluDxJwX2qNsMvOjM5k7Ckce8E1vHRJA18pkMzAL41HMFyzaf67Mp2SgXIaFHXVKVxdsOI.Gi2YOwudddsfdsafdsafa"
  },
  "result": "SUCCESS",
  "type": "API"
}
```

### get counter party list
GET /api/v1/market/cps

request with Headers:    

X-API-TOKEN:token（acquired from login）

***params of return***

| NAME           | TYPE    | DESCRIPTION |
| :------------- | :------ | :------- |
| name           | string  | name |
| tradingEnabled | boolean | trading constraints |

***example of return***

```
{
  "data": [
    {
      "name": "binance",
      "tradingEnabled": true
    },
    {
      "name": "huobi",
      "tradingEnabled": true
    },
    {
      "name": "okex",
      "tradingEnabled": true
    },
    {
      "name": "chainup",
      "tradingEnabled": true
    }
  ],
  "result": "SUCCESS",
  "type": "API"
}
```

### get crypto pairs list
GET  /api/v1/market/symbols

request with Headers:    

X-API-TOKEN:token（acquired from login）

***params of return***

| NAME               | TYPE       | DESCRIPTION     |
| :----------------- | :--------- | :----------- |
| name               | string     | crypto pair name         |
| tradingMaxVolume   | number     | trading Max Volume |
| tradingMinVolume   | number     | trading Min Volume |
| tradingPriceScale  | integer    | trading Price Scale     |
| tradingVolumeScale | integer    | trading Volume Scale   |

***example of return***

```
{
  "data": [
    {
      "name": "BTCUSDT",
      "tradingMaxVolume": "100",
      "tradingMinVolume": "0.01",
      "tradingPriceScale": 5,
      "tradingVolumeScale": 5
    },
    {
      "name": "BCHUSDT",
      "tradingMaxVolume": "100",
      "tradingMinVolume": "0.00001",
      "tradingPriceScale": 2,
      "tradingVolumeScale": 8
    },
    {
      "name": "ETHUSDT",
      "tradingMaxVolume": "100",
      "tradingMinVolume": "0.00001",
      "tradingPriceScale": 2,
      "tradingVolumeScale": 8
    },
    {
      "name": "LTCUSDT",
      "tradingMaxVolume": "100",
      "tradingMinVolume": "0.00001",
      "tradingPriceScale": 2,
      "tradingVolumeScale": 8
    },
    {
      "name": "XRPUSDT",
      "tradingMaxVolume": "100",
      "tradingMinVolume": "0.1",
      "tradingPriceScale": 5,
      "tradingVolumeScale": 8
    },
    {
      "name": "EOSUSDT",
      "tradingMaxVolume": "100",
      "tradingMinVolume": "0.01",
      "tradingPriceScale": 4,
      "tradingVolumeScale": 8
    },
    {
      "name": "ETCUSDT",
      "tradingMaxVolume": "100",
      "tradingMinVolume": "0.01",
      "tradingPriceScale": 4,
      "tradingVolumeScale": 8
    },
    {
      "name": "BCHBTC",
      "tradingMaxVolume": "100",
      "tradingMinVolume": "0.001",
      "tradingPriceScale": 6,
      "tradingVolumeScale": 8
    },
    {
      "name": "ETHBTC",
      "tradingMaxVolume": "100",
      "tradingMinVolume": "0.001",
      "tradingPriceScale": 6,
      "tradingVolumeScale": 8
    },
    {
      "name": "LTCBTC",
      "tradingMaxVolume": "100",
      "tradingMinVolume": "0.01",
      "tradingPriceScale": 6,
      "tradingVolumeScale": 8
    },
    {
      "name": "XRPBTC",
      "tradingMaxVolume": "100",
      "tradingMinVolume": "1",
      "tradingPriceScale": 8,
      "tradingVolumeScale": 8
    },
    {
      "name": "EOSBTC",
      "tradingMaxVolume": "100",
      "tradingMinVolume": "0.001",
      "tradingPriceScale": 7,
      "tradingVolumeScale": 8
    },
    {
      "name": "ETCBTC",
      "tradingMaxVolume": "100",
      "tradingMinVolume": "0.001",
      "tradingPriceScale": 6,
      "tradingVolumeScale": 8
    },
    {
      "name": "ETCETH",
      "tradingMaxVolume": "100",
      "tradingMinVolume": "0.001",
      "tradingPriceScale": 6,
      "tradingVolumeScale": 8
    },
    {
      "name": "XRPETH",
      "tradingMaxVolume": "100",
      "tradingMinVolume": "0.001",
      "tradingPriceScale": 8,
      "tradingVolumeScale": 8
    },
    {
      "name": "EOSETH",
      "tradingMaxVolume": "100",
      "tradingMinVolume": "0.001",
      "tradingPriceScale": 6,
      "tradingVolumeScale": 8
    }
  ],
  "result": "SUCCESS",
  "type": "API"
}
```

### place order
POST /api/v1/trades/place

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request***

RequestBody:（order）

| NAME          | REQUIRED | TYPE       | DESCRIPTION              | DEFAULT | VALUES RANGE |
| :------------ | :------- | :--------- | :-------------------- | :------ | :----------- |
| cps           |          | array      | counter party name            |         |              |
| book          |          | string     | book                    |         |              |
| symbol        | Y        | string     | crypto pair name            |         |              |
| orderPrice    | Y        | number     | order Price               |         |              |
| slippage      |          | number     | slippage                 |         |              |
| orderVolume   | Y        | number     | order Volume               |         |              |
| side          | Y        | string     | [BUY or SELL(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#side)      |         |              |
| orderType     | Y        | string     | [Order Type(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#ordertype)  |         |              |
| timeInForce   | Y        | string     | [Time InForce(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#timeinforce) |         |              |
| clientOrderId |          | string     | clinet order id |         |              |

***example of request***

```
{
	"book": "",
	"clientOrderId": "0001",
	"cps": ["bc", "huobi", "okex"],
	"slippage": 0.01,
	"orderPrice": 0,
	"orderType": "SLIPPAGE",
	"orderVolume": 0.01,
	"side": "SELL",
	"symbol": "BTCUSDT",
	"timeInForce": "IOC"
}
```

 ***params of return***

| NAME          | TYPE       | DESCRIPTION              |
| :------------ | :--------- | :-------------------- |
| orderID       | integer    | order ID                |
| cpOrderId     | integer    | CP order ID                    |
| cp            | string     | counter party name                |
| symbol        | string     | crypto pair name              |
| executeAmount | number     | executed Amount              |
| executeVolume | number     | executed Volume              |
| orderVolume   | number     | order Volume              |
| pendingVolume | number     | pending Volume              |
| side          | string     | [BUY or SELL(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#side)]       |
| orderType     | string     | [Order Type(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#ordertype)  |
| status        | string     | [Order Status(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#orderstatus)     |
| timeInForce   | string     | [Time InForce(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#timeinforce) |
| orderResult   | string     | [Dealing Result(DealingResult)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#dealingresult) |
| orderTime     | integer    | place order Time              |
| executeTime   | integer    | executed Time                  |
| clientOrderId | string     | clinet order id                  |
| commission    | number     | commission         |
***example of return***

```
{
	"data": {
		"order": {
			"clientOrderId": "0001",
			"cpOrders": [{
				"commission": "0",
				"cp": "binance",
				"cpOrderId": "1022333915667835925",
				"executeAmount": "0",
				"executeTime": "0",
				"executeVolume": "0",
				"orderTime": "1573445699770",
				"orderType": "SLIPPAGE",
				"orderVolume": "0.01",
				"pendingVolume": "0",
				"side": "SELL",
				"status": "PENDING",
				"symbol": "BTCUSDT",
				"timeInForce": "IOC"
			}],
			"executeAmount": "0",
			"executeTime": "0",
			"executeVolume": "0",
			"orderId": "1022333915667835413",
			"orderTime": "1573445699770",
			"orderVolume": "0.01",
			"pendingVolume": "0",
			"symbol": "BTCUSDT"
		},
		"orderResult": "SUCCESS"
	},
	"result": "SUCCESS",
	"type": "API"
}
```

### get detail of orders
GET /api/v1/trades/orderDetail

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME     | REQUIRED | TYPE | DESCRIPTION | DEFAULT | VALUES RANGE |
| :------- | :------- | :--- | :------- | :------ | :----------- |
| orderId | Y        | integer | order ID | -       |              |

***params of return***

| NAME          | TYPE       | DESCRIPTION              |
| :------------ | :--------- | :-------------------- |
| orderID       | integer    | order ID                |
| cpOrderId     | integer    | CP order ID                    |
| cp            | string     | counter party name                |
| symbol        | string     | crypto pair name              |
| executeAmount | number     | executed Amount              |
| executeVolume | number     | executed Volume              |
| orderVolume   | number     | order Volume              |
| pendingVolume | number     | pending Volume              |
| side          | string     | [BUY or SELL(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#side)        |
| orderType     | string     | [Order Type(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#ordertype)   |
| status        | string     | [Order Status(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#orderstatus)     |
| timeInForce   | string     | [Time InForce(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#timeinforce) |
| orderTime     | integer    | place order Time              |
| executeTime   | integer    | executed Time              |
| clientOrderId | string     | client order ID              |

***example of return***

```
{
  "data": {
    "order": {
      "cpOrders": [
        {
          "commission": "0",
          "cp": "okex",
          "cpOrderId": "1004925661049089045",
          "executeAmount": "3.50977992",
          "executeTime": "1571370474395",
          "executeVolume": "0.019951",
          "orderComment": "bands,1004925660201601581.0",
          "orderResult": "FILLED",
          "orderTime": "1571370474105",
          "orderType": "SLIPPAGE",
          "orderVolume": "0.019951",
          "pendingVolume": "0",
          "side": "BUY",
          "status": "EXECUTED",
          "symbol": "ETHUSDT",
          "timeInForce": "IOC"
        }
      ],
      "executeAmount": "3.50977992",
      "executeTime": "1571370474395",
      "executeVolume": "0.019951",
      "orderId": "1004925661040699925",
      "orderTime": "1571370474105",
      "orderVolume": "2",
      "pendingVolume": "1.980049",
      "symbol": "ETHUSDT"
    }
  },
  "result": "SUCCESS",
  "type": "API"
}
```

### get detail of client orders
GET /api/v1/trades/clientOrderDetail

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME          | REQUIRED | TYPE | DESCRIPTION | DEFAULT | VALUES RANGE |
| :------------ | :------- | :--- | :------- | :------ | :----------- |
| clientOrderId | Y        | string | client order ID | -       |              |

***params of return***

| NAME          | TYPE       | DESCRIPTION              |
| :------------ | :--------- | :-------------------- |
| orderID       | integer    | order ID                |
| cpOrderId     | integer    | CP order ID                    |
| cp            | string     | counter party name                |
| symbol        | string     | crypto pair name              |
| executeAmount | number     | executed Amount              |
| executeVolume | number     | executed Volume              |
| orderVolume   | number     | order Volume              |
| pendingVolume | number     | pending Volume              |
| side          | string     | [BUY or SELL(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#side)        |
| orderType     | string     | [Order Type(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#ordertype)   |
| status        | string     | [Order Status(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#orderstatus)     |
| timeInForce   | string     | [Time InForce(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#timeinforce) |
| orderTime     | integer    | place order Time              |
| executeTime   | integer    | executed Time              |
| clientOrderId | string     | client order ID              |

***example of return***

```
{
  "data": {
    "order": {
      "clientOrderId": "0001",
      "cpOrders": [
        {
          "commission": "0",
          "cp": "binance",
          "cpOrderId": "1022333915667835925",
          "executeAmount": "0",
          "executeTime": "0",
          "executeVolume": "0",
          "orderComment": "bands,1022333914200245293.0",
          "orderResult": "NONE",
          "orderTime": "1573445699770",
          "orderType": "SLIPPAGE",
          "orderVolume": "0.01",
          "pendingVolume": "0.01",
          "rejectReason": "",
          "side": "SELL",
          "status": "REJECTED",
          "symbol": "BTCUSDT",
          "timeInForce": "IOC"
        }
      ],
      "executeAmount": "0",
      "executeTime": "0",
      "executeVolume": "0",
      "orderId": "1022333915667835413",
      "orderTime": "1573445699770",
      "orderVolume": "0.01",
      "pendingVolume": "0.01",
      "symbol": "BTCUSDT"
    }
  },
  "result": "SUCCESS",
  "type": "API"
}
```

### get CP detail of executed order 
GET  /api/v1/trades/cpExecutionDetail

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME    | REQUIRED | TYPE | DESCRIPTION | DEFAULT | VALUES RANGE |
| :------ | :------- | :--- | :------- | :------ | :----------- |
| cpOrderId | Y        | integer | CP ORDER ID   | -       |              |

***params of return***

| NAME           | TYPE       | DESCRIPTION       |
| :------------- | :--------- | :------------- |
| cp             | string     | counter party name          |
| symbol         | string     | crypto pair name       |
| side           | string     | [BUY or SELL(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#side) |
| executeAmount  | number     | executed Amount       |
| executePrice   | number     | executed Price       |
| cpExecutionid  | number     | CP execution ID       |
| executeVolume  | number     | executed Volume       |
| executeTime    | integer    | executed Time       |
| commission     | number     | commission         |
| executeComment | string     | comment       |

***example of return***

```
{
  "data": {
    "executions": [
      {
        "commission": "8.59965288",
        "commissionCurrency": "USDT",
        "cp": "chainup",
        "cpOrderId": "1023996147503518741",
        "executeAmount": "859.965288",
        "executeComment": "CommissionAsset: USDT",
        "executeId": "1023996281897517589",
        "executePrice": "8775.156",
        "executeTime": "1573643868403",
        "executeVolume": "0.098",
        "orderType": "LIMIT",
        "side": "SELL",
        "symbol": "BTCUSDT"
      }
    ]
  },
  "result": "SUCCESS",
  "type": "API"
}
```


 ### get history list of orders
 GET  /api/v1/trades/orderHistory

request with Headers:    

X-API-TOKEN:token（acquired from login）

 ***request params***

| NAME     | REQUIRED | TYPE    | DESCRIPTION          | DEFAULT | VALUES RANGE |
| :------- | :------- | :------ | :---------------- | :------ | :----------- |
| cp       |          | string   | counter party name             | -       |              |
| symbol   |          | string | crypto pair name          | -       |              |
| status   |          | string  | [Order Status(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#orderstatus) | -       |              |
| from     | Y        | integer    | time started         | -       |              |
| to       | Y        | integer    | time ended         | -       |              |
| pageNo   |          | integer | page NO              | -       |              |

 ***params of return***

| NAME          | TYPE       | DESCRIPTION              |
| :------------ | :--------- | :-------------------- |
| pageCount     | integer    | Counts of pages                |
| pageNo        | integer    | page NO                  |
| pageSize      | integer    | page Size              |
| total         | integer    | total NO                |
| cpOrderId     | integer    | CP order ID                    |
| cp            | string     | counter party name              |
| symbol        | string     | crypto pair name             |
| orderId       | integer    | parent ID              |
| side          | string     | [BUY or SELL(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#side)       |
| status        | string     | [Order Status(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#orderstatus)    |
| orderResult   | string     | [Dealing Result(DealingResult)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#dealingresult)    |
| orderType     | string     | [Order Type(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#ordertype)   |
| orderPrice    | number     | order Price              |
| executeAmount | number     | executed Amount              |
| orderVolume   | number     | order Volume              |
| pendingVolume | number     | pending Volume              |
| executeVolume | number     | executed Volume              |
| executeTime   | integer    | executed Time              |
| orderTime     | integer    | place order Time              |
| timeInForce   | string     | [Time InForce(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#timeinforce) |
| commission    | number     | commission                |
| rejectReason  | string     | reject Reason              |
| orderComment  | string     | comment                  |

 ***example of return***

```
  {
     "data": {
       "pageCount": 128,
       "pageNo": 1,
       "pageSize": 100,
       "records": [
         {
           "commission": "0",
           "cp": "chainup",
           "cpOrderid": "0",
           "executeAmount": "859.965288",
           "executeTime": "1573643868403",
           "executeVolume": "0.098",
           "orderId": "1023996147503518741",
           "orderPrice": "8775.156",
           "orderResult": "FILLED",
           "orderTime": "1573643853246",
           "orderType": "LIMIT",
           "orderVolume": "0.098",
           "pendingVolume": "0",
           "rejectReason": "Success",
           "side": "SELL",
           "status": "EXECUTED",
           "symbol": "BTCUSDT",
           "timeInForce": "GTC"
         },
         {
           "commission": "0",
           "cp": "chaoex",
           "cpOrderid": "0",
           "executeAmount": "9121.83894",
           "executeTime": "1573616654000",
           "executeVolume": "48.078",
           "orderId": "1023767969724215829",
           "orderPrice": "189.73",
           "orderResult": "FILLED",
           "orderTime": "1573616652335",
           "orderType": "LIMIT",
           "orderVolume": "48.078",
           "pendingVolume": "0",
           "side": "SELL",
           "status": "EXECUTED",
           "symbol": "ETHUSDT",
           "timeInForce": "GTC"
         }
       ],
       "total": 12784
     },
     "result": "SUCCESS",
     "type": "API"
   }
```

### get CP history list of placed orders
GET  /api/v1/trades/cpOrderHistory

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME     | REQUIRED | TYPE    | DESCRIPTION          | DEFAULT | VALUES RANGE |
| :------- | :------- | :------ | :---------------- | :------ | :----------- |
| cp       |          | string  | counter party name             | -       |              |
| symbol   |          | string  | crypto pair name          | -       |              |
| status   |          | string  | [Order Status(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#orderstatus) | -       |              |
| from     | Y        | integer | time started          | -       |              |
| to       | Y        | integer | time ended          | -       |              |
| pageNo   |          | integer | page NO              | -       |              |

***params of return***

| NAME          | TYPE       | DESCRIPTION              |
| :------------ | :--------- | :-------------------- |
| pageCount     | integer    | counts of pages                |
| pageNo        | integer    | page NO                  |
| pageSize      | integer    | page Size              |
| total         | integer    | total amount                |
| cpOrderid     | integer    | CP Order ID                    |
| cp            | string     | counter party name                |
| symbol        | string     | crypto pair name              |
| orderId       | integer    | parent order ID              |
| side          | string     | [BUY or SELL(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#side)      |
| status        | string     | [Order Status(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#orderstatus)     |
| orderType     | string     | [Order Type(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#ordertype)   |
| orderResult   | string     | [Dealing Result(DealingResult)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#dealingresult)    |
| executeAmount | number     | executed Amount              |
| orderPrice    | number     | order Price              |
| executeVolume | number     | executed Volume              |
| orderVolume   | number     | order Volume              |
| pendingVolume | number     | pending Volume              |
| orderTime     | integer    | place order Time              |
| executeTime   | integer    | executed Time              |
| timeInForce   | string     | [Time InForce(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#timeinforce) |
| commission    | number     | commission                |
| rejectReason  | string     | reject Reason              |
| orderComment  | string     | comment                  |

***example of return***

```
{
  "data": {
    "pageCount": 57,
    "pageNo": 1,
    "pageSize": 100,
    "records": [
      {
        "commission": "0",
        "cp": "chaoex",
        "cpOrderid": "1022439221994129429",
        "executeAmount": "24598.46717",
        "executeTime": "1573458255000",
        "executeVolume": "126.836",
        "orderId": "0",
        "orderPrice": "194.43",
        "orderResult": "FILLED",
        "orderTime": "1573458253262",
        "orderType": "LIMIT",
        "orderVolume": "126.836",
        "pendingVolume": "0",
        "side": "BUY",
        "status": "EXECUTED",
        "symbol": "ETHUSDT",
        "timeInForce": "GTC"
      },
      {
        "commission": "0",
        "cp": "chaoex",
        "cpOrderid": "1022439182139724309",
        "executeAmount": "23426.4013",
        "executeTime": "1573458249000",
        "executeVolume": "118.48",
        "orderId": "0",
        "orderPrice": "198.51",
        "orderResult": "FILLED",
        "orderTime": "1573458248511",
        "orderType": "LIMIT",
        "orderVolume": "118.48",
        "pendingVolume": "0",
        "side": "BUY",
        "status": "EXECUTED",
        "symbol": "ETHUSDT",
        "timeInForce": "GTC"
      }
    ],
    "total": 5632
  },
  "result": "SUCCESS",
  "type": "API"
}
```

### get CP history list of executed orders
GET  /api/v1/trades/cpExecutionHistory

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME     | REQUIRED | TYPE    | DESCRIPTION | DEFAULT | VALUES RANGE |
| :------- | :------- | :------ | :------- | :------ | :----------- |
| cp       |          | string   | counter party name    | -       |              |
| symbol   |          | string   | crypto pair name | -       |              |
| from     | Y        | integer  | time started | -       |              |
| to       | Y        | integer  | time ended | -       |              |
| pageNo   |          | integer  | page NO     | -       |              |

***返回参数***

| NAME           | TYPE       | DESCRIPTION       |
| :------------- | :--------- | :------------- |
| pageCount      | integer    | counts of pages         |
| pageNo         | integer    | page NO           |
| pageSize       | integer    | page size       |
| total          | integer    | total amount         |
| executeId      | integer    | executed ID       |
| cp             | string     | couter party name          |
| symbol         | string     | crypto pair name    |
| cpOrderId      | integer    | CP order ID         |
| side           | string     | [BUY or SELL(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#side) |
| executePrice   | number     | executed Price           |
| executeVolume  | number     | executed Volume       |
| executeAmount  | number     | executed Amount       |
| executeTime    | integer       | executed Time       |
| commission     | number     | commission         |
| executeComment | string     | comment           |

***example of return***

```
{
  "data": {
    "pageCount": 620,
    "pageNo": 1,
    "pageSize": 100,
    "records": [
      {
        "commission": "0",
        "commissionCurrency": "ETH",
        "cp": "chaoex",
        "cpOrderId": "1022439221994129429",
        "executeAmount": "1086.53999",
        "executeComment": "CommissionAsset: 3",
        "executeId": "1022439268458825749",
        "executePrice": "192.07",
        "executeTime": "1573458255000",
        "executeVolume": "5.657",
        "orderType": "LIMIT",
        "side": "BUY",
        "symbol": "ETHUSDT"
      },
      {
        "commission": "0",
        "commissionCurrency": "ETH",
        "cp": "chaoex",
        "cpOrderId": "1022439221994129429",
        "executeAmount": "170.71136",
        "executeComment": "CommissionAsset: 3",
        "executeId": "1022439268458825237",
        "executePrice": "188.84",
        "executeTime": "1573458255000",
        "executeVolume": "0.904",
        "orderType": "LIMIT",
        "side": "BUY",
        "symbol": "ETHUSDT"
      }
    ],
    "total": 61984
  },
  "result": "SUCCESS",
  "type": "API"
}
```
### get book info
GET /api/v1/risk/books

request with Headers:    

X-API-TOKEN:token（acquired from login）

***params of return***

| NAME  | TYPE   | DESCRIBE |
| :---- | :----- | :------- |
| name | string | abbreviation  |

***example of return***

```
{
  "data": [
    {
      "name": "B"
    },
    {
      "name": "C"
    },
    {
      "name": "D"
    }
  ],
  "result": "SUCCESS",
  "type": "API"
}
```

### get account info
GET /api/v1/market/cpAccountInfo

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME     | REQUIRED | TYPE   | DESCRIPTION | DEFAULT | VALUES RANGE |
| :------- | :------- | :----- | :------- | :------ | :----------- |
| cp      | Y        | string | counter party name    |         |              |

***params of return***

| NAME  | TYPE   | DESCRIPTION |
| :---- | :----- | :------- |
| cp     | string | counter party name    |
| tradeable | boolean | tradeable    |
| currency | string | currency    |
| free | number | free to use amount    |
| frozen | number | frozen amount    |

***example of return***

```
{
  "data": {
    "balance": [
      {
        "currency": "USDT",
        "free": "123.561222104000005444",
        "frozen": "123.561222104000005444"
      },
      {
        "currency": "BTC",
        "free": "0.009982505720491022",
        "frozen": "0.009982505720491022"
      },
      {
        "currency": "ETH",
        "free": "0.0499",
        "frozen": "0.0499"
      },
      {
        "currency": "BCH",
        "free": "0",
        "frozen": "0"
      },
      {
        "currency": "XRP",
        "free": "0",
        "frozen": "0"
      },
      {
        "currency": "LTC",
        "free": "0",
        "frozen": "0"
      },
      {
        "currency": "ETC",
        "free": "0",
        "frozen": "0"
      },
      {
        "currency": "EOS",
        "free": "0",
        "frozen": "0"
      },
      {
        "currency": "XLM",
        "free": "0",
        "frozen": "0"
      },
      {
        "currency": "BCD",
        "free": "0",
        "frozen": "0"
      }
    ],
    "cp": "xxx",
    "tradeable": true
  },
  "result": "SUCCESS",
  "type": "API"
}
```

### get-risk-info
GET /api/v1/risk/positions

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME     | REQUIRED | TYPE   | DESCRIBE | DEFAULT | VALUES RANGE |
| :------- | :------- | :----- | :------- | :------ | :----------- |
| book      | Y        | string | book abbreviation    |         |              |

***params of return***

| NAME  | TYPE   | DESCRIBE |
| :---- | :----- | :------- |
| books | array | book array  |
| book | string | book abbreviation    |
| cps | array |  cp array |
| cp  | string | cp name    |
| floatingProfit | number | floating profit    |
| openAmount | number | open amount    |
| openVolume | number | open volume    |
| symbol | string | crypto pair name    |


***example of return***

```
{
  "data": [
    {
      "books": [
        {
          "book": "B",
          "cps": [
            {
              "costRate": "3750.40641464",
              "cp": "xxx",
              "floatingProfit": "11.43150209",
              "openAmount": "266.428871696500",
              "openVolume": "-0.071040000000",
              "symbol": "BTCUSDT10"
            },
            {
              "costRate": "0",
              "cp": "xxx",
              "floatingProfit": "0",
              "openAmount": "0.000000000000",
              "openVolume": "0.000000000000",
              "symbol": "BTCUSDT10"
            },
            {
              "costRate": "3732.57952708",
              "cp": "xxx",
              "floatingProfit": "4.31672038",
              "openAmount": "113.881001371500",
              "openVolume": "-0.030510000000",
              "symbol": "BTCUSDT10"
            }
          ]
        }
      ],
      "costRate": "3745.05044871",
      "floatingProfit": "16.25007656",
      "openAmount": "380.309873068000",
      "openVolume": "-0.101550000000",
      "symbol": "BTCUSDT10"
    },
    {
      "books": [
        {
          "book": "B",
          "cps": [
            {
              "costRate": "120.02809500",
              "cp": "xxx",
              "floatingProfit": "0.08664285",
              "openAmount": "3.600842850000",
              "openVolume": "-0.030000000000",
              "symbol": "ETHUSDT"
            }
          ]
        }
      ],
      "costRate": "120.02809500",
      "floatingProfit": "0.09384285",
      "openAmount": "3.600842850000",
      "openVolume": "-0.030000000000",
      "symbol": "ETHUSDT"
    }
  ],
  "result": "SUCCESS",
  "type": "API"
}
```



### get-statement-info
GET /api/v1/risk/statements

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME     | REQUIRED | TYPE   | DESCRIBE | DEFAULT | VALUES RANGE |
| :------- | :------- | :----- | :------- | :------ | :----------- |
| book      |         | string | book   abbreviation  |         |              |
| symbol      |         | string | crypto pair name    |         |              |
| from      | Y        | integer | from datetime    |         |              |
| to      | Y        | integer | to datetime    |         |              |
| pageNo      |         | integer | page no    |     1    |              |

***params of return***

| NAME           | TYPE       | DESCRIBE       |
| :------------- | :--------- | :------------- |
| pageCount      | integer       | page count         |
| pageNo         | integer       | page no           |
| pageSize       | integer       | page size       |
| total          | integer       | total         |
| books | array | book array |
| book | string | book abbreviation    |
| cp | string | cp name    |
| symbol | string | crypto pair name    |
| openAmount | number | open amount    |
| openVolume | number | open volume    |
| stateTime | integer | state time    |
| mtmPl | number |  mtm pl  |
| mtmQuote | number |  mtm quote |



***example of return***

```
{
  "data": {
    "pageCount": 1,
    "pageNo": 1,
    "pageSize": 100,
    "records": [
      {
        "book": "B",
        "cp": "xxx",
        "mtmPl": "3.696945598500",
        "mtmQuote": "4020.806600000000",
        "openAmount": "199.393995767500",
        "openVolume": "-0.050510000000",
        "stateTime": "1545667217419",
        "symbol": "BTCUSDT10"
      },
      {
        "book": "B",
        "cp": "xxx",
        "mtmPl": "8.752132224500",
        "mtmQuote": "4020.806600000000",
        "openAmount": "239.613091457500",
        "openVolume": "-0.061770000000",
        "stateTime": "1545667217418",
        "symbol": "BTCUSDT10"
      },
      {
        "book": "B",
        "cp": "xxx",
        "mtmPl": "0.000000000000",
        "mtmQuote": "4020.806600000000",
        "openAmount": "0.000000000000",
        "openVolume": "0.000000000000",
        "stateTime": "1545667217417",
        "symbol": "BTCUSDT10"
      }
    ],
    "total": 3
  },
  "result": "SUCCESS",
  "type": "API"
}
```


### get-making-config
GET /api/v1/making/makingConfigs

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME     | REQUIRED | TYPE   | DESCRIBE          | DEFAULT | VALUES RANGE |
| :------- | :------- | :----- | :---------------- | :------ | :----------- |
| cp       |          | string | CP (Abbreviation) |         |              |
| symbol   |          | string | Symbol            |         |              |

***params of return***

| NAME                          | TYPE        | DESCRIBE                  |
| :---------------------------- | :---------- | :------------------------ |
| cp                            |string       |  CP                     |
| symbol                        |string       |  Symbol                 | 
| frequency                     |integer      |  Frequency/m            |
| l1OrderActive                 |boolean      |  L1 Order Active        |
| tradeActive                   |boolean      |  Trades Active          |
| l2OrderActive                 |boolean      |  L2 Order Active        |
| l1ConfigType                  |string       |  L1 [Config Type](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#makingordertype) |
| l1Config                      |string       |  L1 Config                 |
| l1TickSize                    |number       |  L1 Tick Size              | 
| l1LadderDepth                 |byte         |  L1 Depth                  |
| l1StepHeight                  |number       |  L1 Step Height            |  
| l1MinSpread                   |number       |  L1 Min Spread             |  
| l1MaxDeviation                |number       |  L1 Max Deviation          |  
| tradeType                     |string       |  [Trades Type](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#makingticktype)  |
| tradePriceType                |string       |  [Trades Price Type](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#lptype)  |
| tradePriceAdjustRatio         |number       |  Trade Price Adjust Ratio |  
| tradeRefSpread                |number       |  Trade Ref Spread         |  
| tradeVolumeUpperLimit         |number       |  Max Trade Volume         |  
| tradeVolumeLowerLimit         |number       |  Min Trade Volume         |  
| tradeSendRatio                |number       |  Trade Send Ratio         |  
| tradeVolumeDeduct             |boolean      |  Trade Volume Deduct |
| maxTradeVolumeRatio           |number       |  Max Trades Ratio        | 
| minTradeVolumeRatio           |number       |  Min Trades Ratio        |   
| l2MinSpread                   |number       |  L2 Min Spread              |  
| l2LadderDepth                 |byte         |  L2 Depth                   |
| l2TickSize                    |number       |  L2 Tick Size              |  
| l2MaxDeviation                |number       |  L2 Max Deviation          |  
| l2MinThreshold                |number       |  L2 Min Threshold          |  
| l2MinVolume                   |number       |  L2 Min Volume             |  
| l2MaxVolume                   |number       |  L2 Max Volume             |  


***example of return***

```
{
  "data": [
    {
      "cp": "xxx",
      "frequency": 0,
      "l1Config": "",
      "l1ConfigType": "TARGET_PRICE",
      "l1LadderDepth": 4,
      "l1MaxDeviation": "1",
      "l1MinSpread": "1",
      "l1OrderActive": false,
      "l1StepHeight": "0.1",
      "l1TickSize": "0.01",
      "l2LadderDepth": 1,
      "l2MaxDeviation": "90",
      "l2MaxVolume": "0.01",
      "l2MinSpread": "20",
      "l2MinThreshold": "5",
      "l2MinVolume": "0.001",
      "l2OrderActive": false,
      "l2TickSize": "0.1",
      "maxTradeVolumeRatio": "50",
      "minTradeVolumeRatio": "1",
      "symbol": "BTCUSDT",
      "tradeActive": false,
      "tradePriceAdjustRatio": "20",
      "tradePriceType": "LIQUIDITY_DEMANDER",
      "tradeRefSpread": "1",
      "tradeSendRatio": "100",
      "tradeType": "TOB",
      "tradeVolumeDeduct": false,
      "tradeVolumeLowerLimit": "10",
      "tradeVolumeUpperLimit": "100"
    },
    {
      "cp": "xxx",
      "frequency": 1,
      "l1Config": "",
      "l1ConfigType": "TARGET_PRICE",
      "l1LadderDepth": 4,
      "l1MaxDeviation": "2.66",
      "l1MinSpread": "5",
      "l1OrderActive": false,
      "l1StepHeight": "3",
      "l1TickSize": "1",
      "l2LadderDepth": 2,
      "l2MaxDeviation": "4",
      "l2MaxVolume": "6",
      "l2MinSpread": "1",
      "l2MinThreshold": "0.1",
      "l2MinVolume": "5",
      "l2OrderActive": false,
      "l2TickSize": "3",
      "maxTradeVolumeRatio": "3",
      "minTradeVolumeRatio": "2",
      "symbol": "ETHUSDT",
      "tradeActive": false,
      "tradePriceAdjustRatio": "4",
      "tradePriceType": "LIQUIDITY_PROVIDER",
      "tradeRefSpread": "5",
      "tradeSendRatio": "1",
      "tradeType": "TOB",
      "tradeVolumeDeduct": true,
      "tradeVolumeLowerLimit": "6",
      "tradeVolumeUpperLimit": "7"
    },
    {
      "cp": "xxx",
      "frequency": 20,
      "l1Config": "",
      "l1ConfigType": "SOURCE_LIQUIDITY",
      "l1LadderDepth": 5,
      "l1MaxDeviation": "3",
      "l1MinSpread": "20",
      "l1OrderActive": false,
      "l1StepHeight": "1.51",
      "l1TickSize": "0.01",
      "l2LadderDepth": 10,
      "l2MaxDeviation": "90",
      "l2MaxVolume": "2",
      "l2MinSpread": "20",
      "l2MinThreshold": "4",
      "l2MinVolume": "0.001",
      "l2OrderActive": false,
      "l2TickSize": "0.1",
      "maxTradeVolumeRatio": "100",
      "minTradeVolumeRatio": "1",
      "symbol": "BTCUSDT",
      "tradeActive": false,
      "tradePriceAdjustRatio": "20",
      "tradePriceType": "LIQUIDITY_DEMANDER",
      "tradeRefSpread": "20",
      "tradeSendRatio": "60",
      "tradeType": "MID",
      "tradeVolumeDeduct": true,
      "tradeVolumeLowerLimit": "0.01",
      "tradeVolumeUpperLimit": "10"
    },
    {
      "cp": "xxx",
      "frequency": 15,
      "l1Config": "",
      "l1ConfigType": "TARGET_PRICE",
      "l1LadderDepth": 8,
      "l1MaxDeviation": "3",
      "l1MinSpread": "0.2",
      "l1OrderActive": false,
      "l1StepHeight": "0.001",
      "l1TickSize": "0.0001",
      "l2LadderDepth": 30,
      "l2MaxDeviation": "50",
      "l2MaxVolume": "100",
      "l2MinSpread": "3",
      "l2MinThreshold": "0.5",
      "l2MinVolume": "0.1",
      "l2OrderActive": false,
      "l2TickSize": "0.1",
      "maxTradeVolumeRatio": "90",
      "minTradeVolumeRatio": "10",
      "symbol": "ETHBTC",
      "tradeActive": false,
      "tradePriceAdjustRatio": "50",
      "tradePriceType": "LIQUIDITY_PROVIDER",
      "tradeRefSpread": "0.8",
      "tradeSendRatio": "100",
      "tradeType": "MID",
      "tradeVolumeDeduct": false,
      "tradeVolumeLowerLimit": "1",
      "tradeVolumeUpperLimit": "3"
    },
    {
      "cp": "xxx",
      "frequency": 60,
      "l1Config": "",
      "l1ConfigType": "TARGET_PRICE",
      "l1LadderDepth": 5,
      "l1MaxDeviation": "3",
      "l1MinSpread": "0.02",
      "l1OrderActive": false,
      "l1StepHeight": "0.01",
      "l1TickSize": "0.01",
      "l2LadderDepth": 5,
      "l2MaxDeviation": "90",
      "l2MaxVolume": "10",
      "l2MinSpread": "0.8",
      "l2MinThreshold": "0.3",
      "l2MinVolume": "8",
      "l2OrderActive": false,
      "l2TickSize": "0.1",
      "maxTradeVolumeRatio": "90",
      "minTradeVolumeRatio": "10",
      "symbol": "XLMUSDT",
      "tradeActive": false,
      "tradePriceAdjustRatio": "80",
      "tradePriceType": "LIQUIDITY_DEMANDER",
      "tradeRefSpread": "0.9",
      "tradeSendRatio": "100",
      "tradeType": "MID",
      "tradeVolumeDeduct": false,
      "tradeVolumeLowerLimit": "1",
      "tradeVolumeUpperLimit": "10"
    }
  ],
  "type": "DATA"
}
```


### add-making-config
POST /api/v1/making/makingConfigs/create

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME                          | REQUIRED | TYPE        | DESCRIBE                  | DEFAULT | VALUES RANGE                                           |
| :---------------------------- | :-------| :---------- | :------------------------  | :------ | :----------------------------------------------------- |
| cp                            | Y        |string       |  CP(UPDATE=FALSE)       |         |  Must be included in cp                                |
| symbol                        | Y        |string       |  Symbol(UPDATE=FALSE)   |         |                                                        | 
| frequency                     | Y        |integer      |  Frequency/m            |         | Range: > 0                                             |
| l1OrderActive                 | Y        |boolean      |  L1 Order Active        |         |                                                        |
| tradeActive                   | Y        |boolean      |  Trades Active          |         |                                                        |
| l2OrderActive                 | Y        |boolean      |  L2 Order Active        |         |                                                        |
| l1ConfigType                  | Y        |string       |  L1 [Config Type](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#makingordertype) |         |               |
| l1Config                      | Y        |string       |  L1 Config                 |         |  Must be included in source liquidity config                                            |
| l1TickSize                    | Y        |number       |  L1 Tick Size              |         |  Range: > 0, Precision:24, Scale:12                                                      | 
| l1LadderDepth                 | Y        |byte         |  L1 Depth                  |         |  Range: > 0                                                      |
| l1StepHeight                  | Y        |number       |  L1 Step Height            |         |  Range: > 0, Precision:24, Scale:12                                                      |  
| l1MinSpread                   | Y        |number       |  L1 Min Spread             |         |  Range: > 0, Precision:24, Scale:12                                                      |  
| l1MaxDeviation                | Y        |number       |  L1 Max Deviation          |         |  Range: > 0 & < 100, Precision:4, Scale:2                                                 |  
| tradeType                     | Y        |string       |  [Trades Type](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#makingticktype)  |         |                  |
| tradePriceType                | Y        |string       |  [Trades Price Type](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#lptype)  |         |                             |
| tradePriceAdjustRatio         | Y        |number       |  Trade Price Adjust Ratio |         | Range: > 0 & < 100, Precision:4, Scale:2                                                       |  
| tradeRefSpread                | Y        |number       |  Trade Ref Spread         |         | Range: > 0, Precision:24, Scale:12                                                       |  
| tradeVolumeUpperLimit         | Y        |number       |  Max Trade Volume         |         | Range: > 0, Precision:24, Scale:12                                                       |  
| tradeVolumeLowerLimit         | Y        |number       |  Min Trade Volume         |         | Range: > 0, Precision:24, Scale:12                                                       |  
| tradeSendRatio                | Y        |number       |  Trade Send Ratio         |         | Range: > 0 & <= 100  Precision:3, Scale:0                                                      |  
| tradeVolumeDeduct             | Y        |boolean      |  Trade Volume Deduct      |         |                                 |
| maxTradeVolumeRatio           | Y        |number       |  Max Trades Ratio         |         | Range: > 0 & <= 100   Precision:3, Scale:0                                                    |  
| minTradeVolumeRatio           | Y        |number       |  Min Trades Ratio         |         | Range: > 0 & <= 100   Precision:3, Scale:0                                                    |  
| l2MinSpread                   | Y        |number       |  L2 Min Spread               |         | Range: > 0, Precision:24, Scale:12                                                       | 
| l2LadderDepth                 | Y        |byte         |  L2 Depth                    |         | Range: > 0, Precision:4, Scale:0                                                       |
| l2TickSize                    | Y        |number       |  L2 Tick Size                |         | Range: > 0, Precision:24, Scale:12                                                      |  
| l2MaxDeviation                | Y        |number       |  L2 Max Deviation            |         | Range: > 0 & < 100, Precision:4, Scale:2                                                      |  
| l2MinThreshold                | Y        |number       |  L2 Min Threshold            |         | Range: > 0, Precision:24, Scale:12                                                      |  
| l2MinVolume                   | Y        |number       |  L2 Min Volume               |         | Range: >= 0, Precision:24, Scale:12                                                      |  
| l2MaxVolume                   | Y        |number       |  L2 Max Volume               |         | Range: >= 0, Precision:24, Scale:12                                                      |                                                         |


***example of request***

```
{
      "cp": "xxx",
      "frequency": 20,
      "l1Config": "EOSUSDT",
      "l1ConfigType": "SOURCE_LIQUIDITY",
      "l1LadderDepth": 15,
      "l1MaxDeviation": "0.03",
      "l1MinSpread": "0.001",
      "l1OrderActive": false,
      "l1StepHeight": "0.0001",
      "l1TickSize": "0.0001",
      "l2LadderDepth": 30,
      "l2MaxDeviation": "0.1",
      "l2MaxVolume": "1000",
      "l2MinSpread": "0.0213",
      "l2MinThreshold": "0.0073",
      "l2MinVolume": "100",
      "l2OrderActive": false,
      "l2TickSize": "0.0001",
      "maxTradeVolumeRatio": "1",
      "minTradeVolumeRatio": "1",
      "symbol": "EOSUSDT",
      "tradeActive": false,
      "tradePriceAdjustRatio": "0.2",
      "tradePriceType": "LIQUIDITY_DEMANDER",
      "tradeRefSpread": "0.008",
      "tradeSendRatio": "1",
      "tradeType": "MID",
      "tradeVolumeDeduct": false,
      "tradeVolumeLowerLimit": "0.1",
      "tradeVolumeUpperLimit": "20"
    }
```

***params of return***

| NAME                 | TYPE       | DESCRIBE                                                      |
| :------------------- | :--------- | :------------------------------------------------------------ |   
| result               | string     | 'SUCCESS' or 'INVALID_DATA' or 'REJECTED' or 'INTERNAL_ERROR' |
| type                 | string     | 'API'                                                         |

***example of return***

###### Execute success：
```
{
  "result": "SUCCESS",
  "type": "API"
}
```

###### Parameter validate fail：
```
{
  "result": "INVALID_DATA",
  "type": "API",
  "validations": {
    "basic.cp": "INVALID"
  }
}
```

###### Target config already exist, reject duplicate create：
```
{
  "result": "REJECTED",
  "type": "API"
}
```

###### Executing error：
```
{
  "result": "INTERNAL_ERROR",
  "type": "API"
}
```



### update-making-config
PUT /api/v1/making/makingConfigs/update

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME                          | REQUIRED | TYPE        | DESCRIBE                  | DEFAULT | VALUES RANGE                                           |
| :---------------------------- | :-------| :---------- | :------------------------  | :------ | :----------------------------------------------------- |
| cp                            | Y        |string       |  CP(UPDATE=FALSE)       |         |  Must be included in cp                                |
| symbol                        | Y        |string       |  Symbol(UPDATE=FALSE)   |         |                                                        | 
| frequency                     | Y        |integer      |  Frequency/m            |         | Range: > 0                                             |
| l1OrderActive                 | Y        |boolean      |  L1 Order Active        |         |                                                        |
| tradeActive                   | Y        |boolean      |  Trades Active          |         |                                                        |
| l2OrderActive                 | Y        |boolean      |  L2 Order Active        |         |                                                        |
| l1ConfigType                  | Y        |string       |  L1 [Config Type](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#makingordertype) |         |               |
| l1Config                      | Y        |string       |  L1 Config                 |         |  Must be included in source liquidity config                                            |
| l1TickSize                    | Y        |number       |  L1 Tick Size              |         |  Range: > 0, Precision:24, Scale:12                                                      | 
| l1LadderDepth                 | Y        |byte         |  L1 Depth                  |         |  Range: > 0                                                      |
| l1StepHeight                  | Y        |number       |  L1 Step Height            |         |  Range: > 0, Precision:24, Scale:12                                                      |  
| l1MinSpread                   | Y        |number       |  L1 Min Spread             |         |  Range: > 0, Precision:24, Scale:12                                                      |  
| l1MaxDeviation                | Y        |number       |  L1 Max Deviation          |         |  Range: > 0 & < 100, Precision:4, Scale:2                                                 |  
| tradeType                     | Y        |string       |  [Trades Type](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#makingticktype)  |         |                  |
| tradePriceType                | Y        |string       |  [Trades Price Type](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#lptype)  |         |                             |
| tradePriceAdjustRatio         | Y        |number       |  Trade Price Adjust Ratio |         | Range: > 0 & < 100, Precision:4, Scale:2                                                       |  
| tradeRefSpread                | Y        |number       |  Trade Ref Spread         |         | Range: > 0, Precision:24, Scale:12                                                       |  
| tradeVolumeUpperLimit         | Y        |number       |  Max Trade Volume         |         | Range: > 0, Precision:24, Scale:12                                                       |  
| tradeVolumeLowerLimit         | Y        |number       |  Min Trade Volume         |         | Range: > 0, Precision:24, Scale:12                                                       |  
| tradeSendRatio                | Y        |number       |  Trade Send Ratio         |         | Range: > 0 & <= 100  Precision:3, Scale:0                                                      |  
| tradeVolumeDeduct             | Y        |boolean      |  Trade Volume Deduct      |         |                                 |
| maxTradeVolumeRatio           | Y        |number       |  Max Trades Ratio         |         | Range: > 0 & <= 100   Precision:3, Scale:0                                                    |  
| minTradeVolumeRatio           | Y        |number       |  Min Trades Ratio         |         | Range: > 0 & <= 100   Precision:3, Scale:0                                                    |  
| l2MinSpread                   | Y        |number       |  L2 Min Spread               |         | Range: > 0, Precision:24, Scale:12                                                       | 
| l2LadderDepth                 | Y        |byte         |  L2 Depth                    |         | Range: > 0, Precision:4, Scale:0                                                       |
| l2TickSize                    | Y        |number       |  L2 Tick Size                |         | Range: > 0, Precision:24, Scale:12                                                      |  
| l2MaxDeviation                | Y        |number       |  L2 Max Deviation            |         | Range: > 0 & < 100, Precision:4, Scale:2                                                      |  
| l2MinThreshold                | Y        |number       |  L2 Min Threshold            |         | Range: > 0, Precision:24, Scale:12                                                      |  
| l2MinVolume                   | Y        |number       |  L2 Min Volume               |         | Range: > 0, Precision:24, Scale:12                                                      |  
| l2MaxVolume                   | Y        |number       |  L2 Max Volume               |         | Range: > 0, Precision:24, Scale:12                                                      |                                                         |


***example of request***
```
{
  "frequency": 20,
  "l1Config": "EOSUSDT",
  "l1ConfigType": "SOURCE_LIQUIDITY",
  "l1LadderDepth": 15,
  "l1MaxDeviation": "0.03",
  "l1MinSpread": "0.001",
  "l1OrderActive": false,
  "l1StepHeight": "0.0001",
  "l1TickSize": "0.0001",
  "l2LadderDepth": 30,
  "l2MaxDeviation": "0.1",
  "l2MaxVolume": "1000",
  "l2MinSpread": "0.0213",
  "l2MinThreshold": "0.0073",
  "l2MinVolume": "100",
  "l2OrderActive": false,
  "l2TickSize": "0.0001",
  "maxTradeVolumeRatio": "1",
  "minTradeVolumeRatio": "1",
  "tradeActive": false,
  "tradePriceAdjustRatio": "0.2",
  "tradePriceType": "LIQUIDITY_DEMANDER",
  "tradeRefSpread": "0.008",
  "tradeSendRatio": "1",
  "tradeType": "MID",
  "tradeVolumeDeduct": false,
  "tradeVolumeLowerLimit": "0.1",
  "tradeVolumeUpperLimit": "20"
}
```

***params of return***

| NAME                 | TYPE       | DESCRIBE                                                                         |
| :------------------- | :--------- | :------------------------------------------------------------------------------- |   
| result               | string     | 'SUCCESS' or 'INVALID_DATA' or 'REJECTED' or 'STALE_VERSION' or 'INTERNAL_ERROR' |
| type                 | string     | 'API'                                                                            |


***example of return***

###### Execute success：
```
{
  "result": "SUCCESS",
  "type": "API"
}
```

###### Parameter validate fail：
```
{
  "result": "INVALID_DATA",
  "type": "API",
  "validations": {
    "basic.cp": "INVALID"
  }
}
```

###### Target config not exist, reject update：
```
{
  "result": "REJECTED",
  "type": "API"
}
```

###### Version does not match：
```
{
  "result": "STALE_VERSION",
  "type": "API"
}
```

###### Executing error：
```
{
  "result": "INTERNAL_ERROR",
  "type": "API"
}
```



### delete-making-config
DELETE /api/v1/making/makingConfigs/delete

request with Headers:

X-API-TOKEN:token（acquired from login）

***request params***

| NAME                 | REQUIRED | TYPE       | DESCRIBE          | DEFAULT | VALUES RANGE |
| :------------------- | :------- | :--------- | :---------------- | :------ | :----------- |
| cp                   | Y        |string      |  CP               |         |  Must be included in cp                                |
| symbol               | Y        |string      |  Symbol           |         |                                                        | 


***params of return***

| NAME                 | TYPE       | DESCRIBE                                                                          |
| :------------------- | :--------- | :-------------------------------------------------------------------------------- |   
| result               | string     |  'SUCCESS' or 'REJECTED' or 'UNAUTHORIZED' or 'STALE_VERSION' or 'INTERNAL_ERROR' |
| type                 | string     | 'API'                                                                             |


***example of return***

###### Execute success：
```
{
  "result": "SUCCESS",
  "type": "API"
}
```

###### Target config not exist, reject delete：
```
{
  "result": "REJECTED",
  "type": "API"
}
```

###### No permission to delete：
```
{
  "result": "UNAUTHORIZED",
  "type": "API"
}
```

###### Version does not match：
```
{
  "result": "STALE_VERSION",
  "type": "API"
}
```

###### Executing error：
```
{
  "result": "INTERNAL_ERROR",
  "type": "API"
}
```


### get-source-liquidity-config
GET /v1/making/sourceLiquidityConfigs

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME     | REQUIRED | TYPE   | DESCRIBE          | DEFAULT | VALUES RANGE |
| :------- | :------- | :----- | :---------------- | :------ | :----------- |
| symbol              | Y      |string             | : Symbol|            |

***params of return***

| NAME                          | TYPE        | DESCRIBE                  |
| :---------------------------- | :---------- | :------------------------ |
| cp                            |string       |  CP                     |
| name                          |string       |  name                   | 
| symbol                        |string       |  symbol                 |
| refCps                        |array        |  ref cp                 |
| baseCp                        |number       |  base cp                |
| bidVolumeAdjustRatio          |number       |  bid volume adjust ratio |
| askVolumeAdjustRatio          |number       |  ask volume adjust ratio |
| maxVolume                     |number       |  max volume              |
| maxVolumeRatio                |number       |  max volume ratio        |
| bidPriceAdjustRatio           |number       |  bid price adjust ratio  |
| askPriceAdjustRatio           |number       |  ask price adjust ratio  |
| bidPriceAdjustValue           |number       |  bid price adjust value  |
| askPriceAdjustValue           |number       |  ask price adjust value  |
| priceAdjustType               |string       |  price adjust type       |

***example of return***

```
{
  "data": [
    {
      "askPriceAdjustRatio": "6",
      "askPriceAdjustValue": "8",
      "askVolumeAdjustRatio": "4",
      "baseCp": "bc",
      "bidPriceAdjustRatio": "5",
      "bidPriceAdjustValue": "7",
      "bidVolumeAdjustRatio": "3",
      "maxVolume": "1",
      "maxVolumeRatio": "2",
      "name": "EOSBTC",
      "priceAdjustType": "VALUE",
      "refCps": [
        "bc"
      ],
      "symbol": "EOSBTC"
    },
    {
      "askPriceAdjustRatio": "100",
      "askPriceAdjustValue": "1",
      "askVolumeAdjustRatio": "100",
      "baseCp": "bc",
      "bidPriceAdjustRatio": "100",
      "bidPriceAdjustValue": "1",
      "bidVolumeAdjustRatio": "100",
      "maxVolume": "1",
      "maxVolumeRatio": "1",
      "name": "EOSBTC2",
      "priceAdjustType": "VALUE",
      "refCps": [
        "bc",
        "huobi"
      ],
      "symbol": "EOSBTC"
    }
  ],
  "type": "DATA"
}
```



### add-source-liquidity-config
POST /v1/making/sourceLiquidityConfigs/create

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME                          | REQUIRED | TYPE        | DESCRIBE                  | DEFAULT | VALUES RANGE                                           |
| :---------------------------- | :------- | :---------- | :------------------------ | :------ | :----------------------------------------------------- |
| name                          | Y        |string       |  name                   |         |                                                        |
| symbol                        | Y        |string       |  symbol                 |         |                                                        |
| baseCp                        |          |string       |  base cp                |         |                                                        |
| refCps                        | Y        |array        |  ref cps                |         |                                                        |
| bidVolumeAdjustRatio          | Y        |number       |  bid volume adjust ratio|         | Range: > 0 & <= 100   Precision:4, Scale:2             |
| askVolumeAdjustRatio          | Y        |number       |  ask volume adjust ratio|         | Range: > 0 & <= 100   Precision:4, Scale:2             |
| maxVolume                     | Y        |number       |  max volume             |         | Range: > 0   Precision:24, Scale:12                    |
| maxVolumeRatio                | Y        |number       |  max volume ratio       |        | Range: > 0 & < 100   Precision:2, Scale:0               |
| bidPriceAdjustRatio           | N        |number       |  bid price adjust ratio |        | Range: > 0 & <= 100   Precision:4, Scale:2              |
| askPriceAdjustRatio           | N        |number       |  ask price adjust ratio |        | Range: > 0 & <= 100   Precision:4, Scale:2             |
| bidPriceAdjustValue           | N        |number       |  bid price adjust value |        |  Range: >= 0   Precision:24, Scale:12                                                      |
| askPriceAdjustValue           | N        |number       |  ask price adjust value |        |  Range: >= 0   Precision:24, Scale:12                                                      |
| priceAdjustType               | Y        |string       |  [price adjust type](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#priceadjusttype)     |         |                                                        |


***请求参数示例***

```
{
  "cp": "xxx",
  "frequency": 20,
  "l1Config": "EOSUSDT",
  "l1ConfigType": "SOURCE_LIQUIDITY",
  "l1LadderDepth": 15,
  "l1MaxDeviation": "0.03",
  "l1MinSpread": "0.001",
  "l1OrderActive": false,
  "l1StepHeight": "0.0001",
  "l1TickSize": "0.0001",
  "l2LadderDepth": 30,
  "l2MaxDeviation": "0.1",
  "l2MaxVolume": "1000",
  "l2MinSpread": "0.0213",
  "l2MinThreshold": "0.0073",
  "l2MinVolume": "100",
  "l2OrderActive": false,
  "l2TickSize": "0.0001",
  "maxTradeVolumeRatio": "1",
  "minTradeVolumeRatio": "1",
  "symbol": "EOSUSDT",
  "tradeActive": false,
  "tradePriceAdjustRatio": "0.2",
  "tradePriceType": "LIQUIDITY_DEMANDER",
  "tradeRefSpread": "0.008",
  "tradeSendRatio": "1",
  "tradeType": "MID",
  "tradeVolumeDeduct": false,
  "tradeVolumeLowerLimit": "0.1",
  "tradeVolumeUpperLimit": "20"
}
```

***返回参数***

| NAME                 | TYPE       | DESCRIBE                                                      |
| :------------------- | :--------- | :------------------------------------------------------------ |   
| result               | string     | 'SUCCESS' 或 'INVALID_DATA' 或 'REJECTED' 或 'INTERNAL_ERROR' |
| type                 | string     | 'API'                                                         |

***返回参数示例***

###### 执行成功：
```
{
  "result": "SUCCESS",
  "type": "API"
}
```

###### 参数验证失败：
```
{
  "result": "INVALID_DATA",
  "type": "API",
  "validations": {
    "basic.cp": "INVALID"
  }
}
```

###### 目标配置已经存在，拒绝重复创建：
```
{
  "result": "REJECTED",
  "type": "API"
}
```

###### 新建执行异常：
```
{
  "result": "INTERNAL_ERROR",
  "type": "API"
}
```


### update-source-liquidity-config
PUT /v1/making/sourceLiquidityConfigs/update

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME                          | REQUIRED | TYPE        | DESCRIBE                  | DEFAULT | VALUES RANGE                                           |
| :---------------------------- | :------- | :---------- | :------------------------ | :------ | :----------------------------------------------------- |
| name                          | Y        |string       |  Name                   |         |                                                        |
| symbol                        | Y        |string       |  Symbol                 |         |                                                        |
| baseCp                        |          |string       |  base Cp                |         |                                                        |
| refCps                        | Y        |array        |  ref Cps                |         |                                                        |
| bidVolumeAdjustRatio          | Y        |number       |  bid volume adjust ratio|         | Range: > 0 & <= 100   Precision:4, Scale:2             |
| askVolumeAdjustRatio          | Y        |number       |  ask volume adjust ratio|         | Range: > 0 & <= 100   Precision:4, Scale:2             |
| maxVolume                     | Y        |number       |  max volume             |         | Range: > 0   Precision:24, Scale:12                    |
| maxVolumeRatio                | Y        |number       |  max volume ratio       |         | Range: > 0 & < 100   Precision:2, Scale:0              |
| bidPriceAdjustRatio           | N        |number       |  bid price adjust ratio |         | Range: > 0 & <= 100   Precision:4, Scale:2             |
| askPriceAdjustRatio           | N        |number       |  ask price adjust ratio |         | Range: > 0 & <= 100   Precision:4, Scale:2             |
| bidPriceAdjustValue           | N        |number       |  bid price adjust value |         |  Range: >= 0   Precision:24, Scale:12                                                      |
| askPriceAdjustValue           | N        |number       |  ask price adjust value |         |  Range: >= 0   Precision:24, Scale:12                                                      |
| priceAdjustType               | Y        |string       |  [Price Adjust Type](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#priceadjusttype)     |         |                                                        |


***example of request***
```
{
  "cp": "xxx",
  "frequency": 20,
  "l1Config": "EOSUSDT",
  "l1ConfigType": "SOURCE_LIQUIDITY",
  "l1LadderDepth": 15,
  "l1MaxDeviation": "0.03",
  "l1MinSpread": "0.001",
  "l1OrderActive": false,
  "l1StepHeight": "0.0001",
  "l1TickSize": "0.0001",
  "l2LadderDepth": 30,
  "l2MaxDeviation": "0.1",
  "l2MaxVolume": "1000",
  "l2MinSpread": "0.0213",
  "l2MinThreshold": "0.0073",
  "l2MinVolume": "100",
  "l2OrderActive": false,
  "l2TickSize": "0.0001",
  "maxTradeVolumeRatio": "1",
  "minTradeVolumeRatio": "1",
  "symbol": "EOSUSDT",
  "tradeActive": false,
  "tradePriceAdjustRatio": "0.2",
  "tradePriceType": "LIQUIDITY_DEMANDER",
  "tradeRefSpread": "0.008",
  "tradeSendRatio": "1",
  "tradeType": "MID",
  "tradeVolumeDeduct": false,
  "tradeVolumeLowerLimit": "0.1",
  "tradeVolumeUpperLimit": "20"
}
```

***params of return***

| NAME                 | TYPE       | DESCRIBE                                                                         |
| :------------------- | :--------- | :------------------------------------------------------------------------------- |   
| result               | string     | 'SUCCESS' or 'INVALID_DATA' or 'REJECTED' or 'STALE_VERSION' or 'INTERNAL_ERROR' |
| type                 | string     | 'API'                                                                            |


***example of return***

###### Execute success：
```
{
  "result": "SUCCESS",
  "type": "API"
}
```

###### Parameter validate fail：
```
{
  "result": "INVALID_DATA",
  "type": "API",
  "validations": {
    "basic.cp": "INVALID"
  }
}
```

###### Target config not exist, reject update：
```
{
  "result": "REJECTED",
  "type": "API"
}
```

###### Version does not match：
```
{
  "result": "STALE_VERSION",
  "type": "API"
}
```

###### Executing error：
```
{
  "result": "INTERNAL_ERROR",
  "type": "API"
}
```


### delete-source-liquidity-config
DELETE /v1/making/sourceLiquidityConfigs/delete

request with Headers:

X-API-TOKEN:token（acquired from login）

***request params***

| NAME                 | REQUIRED | TYPE       | DESCRIBE          | DEFAULT | VALUES RANGE |
| :------------------- | :------- | :--------- | :---------------- | :------ | :----------- |
| name                 | Y        |string      |  Name             |         |                                  |
| symbol               | Y        |string      |  Symbol           |         |                                  | 


***params of return***

| NAME                 | TYPE       | DESCRIBE                                                                          |
| :------------------- | :--------- | :-------------------------------------------------------------------------------- |   
| result               | string     |  'SUCCESS' or 'REJECTED' or 'UNAUTHORIZED' or 'STALE_VERSION' or 'INTERNAL_ERROR' |
| type                 | string     | 'API'                                                                             |


***example of return***

###### Execute success：
```
{
  "result": "SUCCESS",
  "type": "API"
}
```

###### Target config not exist, reject delete：
```
{
  "result": "REJECTED",
  "type": "API"
}
```

###### No permission to delete：
```
{
  "result": "UNAUTHORIZED",
  "type": "API"
}
```

###### Version does not match：
```
{
  "result": "STALE_VERSION",
  "type": "API"
}
```

###### Executing error：
```
{
  "result": "INTERNAL_ERROR",
  "type": "API"
}
```