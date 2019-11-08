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
| cp            |          | string     | counter party name            |         |              |
| book          |          | string     | book                    |         |              |
| symbol        | Y        | string     | crypto pair name            |         |              |
| orderPrice    | Y        | number     | order Price               |         |              |
| orderVolume   | Y        | number     | order Volume               |         |              |
| side          | Y        | string     | BUY or SELL(Side)       |         |              |
| orderType     | Y        | string     | Order Type)   |         |              |
| timeInForce   | Y        | string     | Time In Force) |         |              |
| clientOrderId |          | string     | clinet order id |         |              |

***example of request***

```
{
  "cp": "",
  "orderPrice": 0,
  "orderType": "MARKET",
  "orderVolume": 0.1,
  "side": "BUY",
  "symbol": "BTCUSDT",
  "timeInForce": "IOC",
  "clientOrderId": "1"
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
| side          | string     | BUY or SELL(Side)]       |
| orderType     | string     | Order Type  |
| status        | string     | Order Status     |
| timeInForce   | string     | Time In Force |
| orderResult   | string     | Dealing Result |
| orderTime     | integer    | place order Time              |
| executeTime   | integer    | executed Time                  |
| clientOrderId | string     | clinet order id                  |

***example of return***

```
{
  "data": {
    "order": {
      "clientOrderId": "1"
      "cpOrders": [
        {
          "commission": "0.0010",
          "cp": "xxx",
          "cpOrderId": "764537366881774633",
          "executeAmount": "0",
          "executeTime": "0",
          "executeVolume": "0",
          "orderComment": "764537362455412757.0",
          "orderTime": "1542713956341",
          "orderType": 5,
          "orderVolume": "0.03538015",
          "pendingVolume": "0.00000000",
          "side": 1,
          "status": 1,
          "symbol": "BTCUSDT",
          "timeInForce": 1
        },
        {
          "commission": "0.0010",
          "cp": "xxx",
          "cpOrderId": "764537366881774121",
          "executeAmount": "0",
          "executeTime": "0",
          "executeVolume": "0",
          "orderComment": "764537365559204373.0",
          "orderTime": "1542713956341",
          "orderType": 5,
          "orderVolume": "0.0262",
          "pendingVolume": "0.0000",
          "side": 1,
          "status": 1,
          "symbol": "BTCUSDT",
          "timeInForce": 1
        }
      ],
      "executeAmount": "0",
      "executeTime": "0",
      "executeVolume": "0",
      "orderId": "764537366881773609",
      "orderTime": "1542713956341",
      "orderType": 5,
      "orderVolume": "0.1",
      "pendingVolume": "0.03841985",
      "side": 1,
      "status": 1,
      "symbol": "BTCUSDT",
      "timeInForce": 1
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
| side          | string     | BUY OR SELL(Side)        |
| orderType     | string     | Order Type   |
| status        | string     | Order Status     |
| timeInForce   | string     | Time In Force) |
| orderTime     | integer    | place order Time              |
| executeTime   | integer    | executed Time              |
| clientOrderId | string     | client order ID              |

***example of return***

```
{
  "data": {
    "order": {
      "clientOrderId": "1"
      "cpOrders": [
        {
          "commission": "0.001000000000",
          "cp": "xxx",
          "cpOrderId": "764422647617432617",
          "executeAmount": "162.148181169788",
          "executeTime": "1542700281148",
          "executeVolume": "0.034123870000",
          "orderComment": "764422645882369557.0",
          "orderResult": 3,
          "orderTime": "1542700280739",
          "orderType": 5,
          "orderVolume": "0.034123870000",
          "pendingVolume": "0.000000000000",
          "side": -1,
          "status": 4,
          "symbol": "BTCUSDT",
          "timeInForce": 1
        },
        {
          "commission": "0.001000000000",
          "cp": "xxx",
          "cpOrderId": "764422647617432105",
          "executeAmount": "101.838560000000",
          "executeTime": "1542700281059",
          "executeVolume": "0.021500000000",
          "orderComment": "764422643114119701.0",
          "orderResult": 3,
          "orderTime": "1542700280739",
          "orderType": 5,
          "orderVolume": "0.021500000000",
          "pendingVolume": "0.000000000000",
          "side": -1,
          "status": 4,
          "symbol": "BTCUSDT",
          "timeInForce": 1
        },
        {
          "commission": "0.001000000000",
          "cp": "xxx",
          "cpOrderId": "764422647617431593",
          "executeAmount": "107.967621000000",
          "executeTime": "1542700280829",
          "executeVolume": "0.022850000000",
          "orderComment": "764422647266494997.0",
          "orderResult": 3,
          "orderTime": "1542700280739",
          "orderType": 5,
          "orderVolume": "0.022850000000",
          "pendingVolume": "0.000000000000",
          "side": -1,
          "status": 4,
          "symbol": "BTCUSDT",
          "timeInForce": 1
        }
      ],
      "executeAmount": "371.954362169788",
      "executeTime": "1542700281059",
      "executeVolume": "0.078473870000",
      "orderId": "764422647617431081",
      "orderResult": 5,
      "orderTime": "1542700280739",
      "orderType": 5,
      "orderVolume": "0.100000000000",
      "pendingVolume": "0.021526130000",
      "side": -1,
      "status": 4,
      "symbol": "BTCUSDT",
      "timeInForce": 1
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
| side          | string     | BUY OR SELL(Side)        |
| orderType     | string     | Order Type   |
| status        | string     | Order Status     |
| timeInForce   | string     | Time In Force) |
| orderTime     | integer    | place order Time              |
| executeTime   | integer    | executed Time              |
| clientOrderId | string     | client order ID              |

***example of return***

```
{
  "data": {
    "order": {
      "clientOrderId": "1"
      "cpOrders": [
        {
          "commission": "0.001000000000",
          "cp": "xxx",
          "cpOrderId": "764422647617432617",
          "executeAmount": "162.148181169788",
          "executeTime": "1542700281148",
          "executeVolume": "0.034123870000",
          "orderComment": "764422645882369557.0",
          "orderResult": 3,
          "orderTime": "1542700280739",
          "orderType": 5,
          "orderVolume": "0.034123870000",
          "pendingVolume": "0.000000000000",
          "side": -1,
          "status": 4,
          "symbol": "BTCUSDT",
          "timeInForce": 1
        },
        {
          "commission": "0.001000000000",
          "cp": "xxx",
          "cpOrderId": "764422647617432105",
          "executeAmount": "101.838560000000",
          "executeTime": "1542700281059",
          "executeVolume": "0.021500000000",
          "orderComment": "764422643114119701.0",
          "orderResult": 3,
          "orderTime": "1542700280739",
          "orderType": 5,
          "orderVolume": "0.021500000000",
          "pendingVolume": "0.000000000000",
          "side": -1,
          "status": 4,
          "symbol": "BTCUSDT",
          "timeInForce": 1
        },
        {
          "commission": "0.001000000000",
          "cp": "xxx",
          "cpOrderId": "764422647617431593",
          "executeAmount": "107.967621000000",
          "executeTime": "1542700280829",
          "executeVolume": "0.022850000000",
          "orderComment": "764422647266494997.0",
          "orderResult": 3,
          "orderTime": "1542700280739",
          "orderType": 5,
          "orderVolume": "0.022850000000",
          "pendingVolume": "0.000000000000",
          "side": -1,
          "status": 4,
          "symbol": "BTCUSDT",
          "timeInForce": 1
        }
      ],
      "executeAmount": "371.954362169788",
      "executeTime": "1542700281059",
      "executeVolume": "0.078473870000",
      "orderId": "764422647617431081",
      "orderResult": 5,
      "orderTime": "1542700280739",
      "orderType": 5,
      "orderVolume": "0.100000000000",
      "pendingVolume": "0.021526130000",
      "side": -1,
      "status": 4,
      "symbol": "BTCUSDT",
      "timeInForce": 1
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
| side           | string     | BUY OR SELL(Side) |
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
        "commission": "0.177134330000",
        "cp": "xxx",
        "cpExecutionid": "764451245254521375",
        "executeAmount": "177.134333600000",
        "executeComment": "CommissionAsset: USDT",
        "executePrice": "4408.520000000000",
        "executeTime": "1542703689751",
        "executeVolume": "0.040180000000",
        "side": -1,
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
| status   |          | string  | Order Status | -       |              |
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
| side          | string     | BUY OR SELL(Side)       |
| status        | string     | Order Status    |
| orderResult   | string     | Order Result    |
| orderType     | string     | Order Type   |
| orderPrice    | number     | order Price              |
| executeAmount | number     | executed Amount              |
| orderVolume   | number     | order Volume              |
| pendingVolume | number     | pending Volume              |
| executeVolume | number     | executed Volume              |
| executeTime   | integer    | executed Time              |
| orderTime     | integer    | place order Time              |
| timeInForce   | string     | Time In Force |
| commission    | number     | commission                |
| rejectReason  | string     | reject Reason              |
| orderComment  | string     | comment                  |

 ***example of return***

```
 {
  "data": {
    "pageCount": 1,
    "pageNo": 1,
    "pageSize": 100,
    "records": [
      {
        "commission": "0.0100",
        "cp": "xxx",
        "cpOrderid": "0",
        "executeAmount": "45.7905",
        "executeTime": "1542783740595",
        "executeVolume": "0.01",
        "orderComment": "765122751453824021.0",
        "orderId": "765122754566440991",
        "orderResult": 3,
        "orderTime": "1542783739991",
        "orderType": 5,
        "orderVolume": "0.01",
        "pendingVolume": "0",
        "side": -1,
        "status": 4,
        "symbol": "BTCUSDT",
        "timeInForce": 1
      },
      {
        "cp": "xxx",
        "cpOrderid": "0",
        "executeAmount": "0",
        "executeTime": "0",
        "executeVolume": "0",
        "orderId": "765093754133560351",
        "orderResult": 1,
        "orderTime": "1542780282870",
        "orderType": 5,
        "orderVolume": "0.1",
        "pendingVolume": "0.1",
        "side": 1,
        "status": 9,
        "symbol": "BTCUSDT",
        "timeInForce": 1
      },
      {
        "cp": "xxx",
        "cpOrderid": "0",
        "executeAmount": "0",
        "executeTime": "0",
        "executeVolume": "0",
        "orderId": "765093385278076959",
        "orderResult": 1,
        "orderTime": "1542780238899",
        "orderType": 5,
        "orderVolume": "0.1",
        "pendingVolume": "0.1",
        "side": 1,
        "status": 9,
        "symbol": "BTCUSDT",
        "timeInForce": 1
      }
    ],
    "total": 3
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
| status   |          | string  | Order Status | -       |              |
| from     | Y        | integer    | time started          | -       |              |
| to       | Y        | integer    | time ended          | -       |              |
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
| side          | string     | BUY OR SELL(Side)      |
| status        | string     | Order Status     |
| orderType     | string     | Order Type   |
| orderResult   | string     | Order Result     |
| executeAmount | number     | executed Amount              |
| orderPrice    | number     | order Price              |
| executeVolume | number     | executed Volume              |
| orderVolume   | number     | order Volume              |
| pendingVolume | number     | pending Volume              |
| orderTime     | integer    | place order Time              |
| executeTime   | integer    | executed Time              |
| timeInForce   | string     | Time In Force) |
| commission    | number     | commission                |
| rejectReason  | string     | reject Reason              |
| orderComment  | string     | comment                  |

***example of return***

```
{
  "data": {
    "pageCount": 1,
    "pageNo": 1,
    "pageSize": 100,
    "records": [
      {
        "commission": "0.0100",
        "cp": "xxx",
        "cpOrderid": "765093754133560863",
        "executeAmount": "0",
        "executeTime": "0",
        "executeVolume": "0",
        "orderComment": "765093748992762389.0",
        "orderId": "765093754133560351",
        "orderResult": 1,
        "orderTime": "1542780282870",
        "orderType": 5,
        "orderVolume": "0.0157",
        "pendingVolume": "0.0157",
        "side": 1,
        "status": 9,
        "symbol": "BTCUSDT",
        "timeInForce": 1
      },
      {
        "commission": "0.0100",
        "cp": "xxx",
        "cpOrderid": "765093385278077471",
        "executeAmount": "0",
        "executeTime": "0",
        "executeVolume": "0",
        "orderComment": "765093382953764373.0",
        "orderId": "765093385278076959",
        "orderResult": 1,
        "orderTime": "1542780238899",
        "orderType": 5,
        "orderVolume": "0.0157",
        "pendingVolume": "0.0157",
        "side": 1,
        "status": 9,
        "symbol": "BTCUSDT",
        "timeInForce": 1
      },
      {
        "commission": "0.0100",
        "cp": "xxx",
        "cpOrderid": "765089110191781407",
        "executeAmount": "0",
        "executeTime": "0",
        "executeVolume": "0",
        "orderComment": "765089109550140949.0",
        "orderId": "765089110191780895",
        "orderResult": 1,
        "orderTime": "1542779729270",
        "orderType": 5,
        "orderVolume": "0.0156",
        "pendingVolume": "0.0156",
        "side": 1,
        "status": 9,
        "symbol": "BTCUSDT",
        "timeInForce": 1
      }
    ],
    "total": 3
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
| pageCount      | integer       | counts of pages         |
| pageNo         | integer       | page NO           |
| pageSize       | integer       | page size       |
| total          | integer       | total amount         |
| executeId      | integer       | executed ID       |
| cp             | string     | couter party name          |
| symbol         | string     | crypto pair name    |
| cpOrderId      | integer       | CP order ID         |
| side           | string     | BUY OR SELL(Side |
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
    "pageCount": 3,
    "pageNo": 1,
    "pageSize": 100,
    "records": [
      {
        "commission": "0.18669821",
        "cp": "xxx",
        "cpOrderId": "763796819208573471",
        "executeAmount": "186.6982104",
        "executeComment": "CommissionAsset: USDT",
        "executeId": "763796828092109855",
        "executePrice": "5369.52",
        "executeTime": "1542625677137",
        "executeVolume": "0.03477",
        "side": -1,
        "symbol": "BTCUSDT"
      },
      {
        "commission": "0.00002807",
        "cp": "xxx",
        "cpOrderId": "763795745399653919",
        "executeAmount": "150.785454",
        "executeComment": "CommissionAsset: BTC",
        "executeId": "763795753830207007",
        "executePrice": "5371",
        "executeTime": "1542625549089",
        "executeVolume": "0.028074",
        "side": 1,
        "symbol": "BTCUSDT"
      },
      {
        "commission": "0.00000192",
        "cp": "xxx",
        "cpOrderId": "763795745399653919",
        "executeAmount": "10.30146292",
        "executeComment": "CommissionAsset: BTC",
        "executeId": "763795753830206495",
        "executePrice": "5370.94",
        "executeTime": "1542625549089",
        "executeVolume": "0.001918",
        "side": 1,
        "symbol": "BTCUSDT"
      }
    ],
    "total": 3
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
| cp | string | cp name    |
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