# Restful API informations(2019-01-21)


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
| [/api/v1/making/makingConfig](#get-making-config)  | GET  | get making config         |
| [/api/v1/making/makingConfig](#add-making-config)  | PUT  | add making config         |
| [/api/v1/making/makingConfig](#update-making-config)  | POST  | update making config         |
| [/api/v1/making/makingConfig](#delete-making-config)  | DELETE  | delete making config         |

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
    "token": "ZElHYkFsRktuZDduUG1udzI2V1lldyIsImFsZyI6IkEyNTZHQ01LVyIsIml2IjoicjZzLU83TGlYTUFYVEVxeSJ9.92p5f4TRYGPa16VZQgE1_FlhYwx6YCLeUlh-rlE3o_8.-wL8D1uL3GEEE3kj.qmBbSsSy92nYBt4WOLbU5MCH1NPbXO6k6_b5uGEG63xcQJ-Ny9K1VCMRtChQRol6l6fb5rNobNnOFAgeYzy2cqkje4HgUlL3BSRNlDj7G6W-60MwM2af7U2xshESv8LqLux2GZxPzCBmJz__HgluDxJwX2qNsMvOjM5k7Ckce8E1vHRJA18pkMzAL41HMFyzaf67Mp2SgXIaFHXVKVxdsOI.Gi2YOwudddsfdsafdsafa"
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
          "cp": "okex",
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
          "cp": "huobi",
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
          "cp": "okex",
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
          "cp": "huobi",
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
          "cp": "binance",
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
          "cp": "okex",
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
          "cp": "huobi",
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
          "cp": "binance",
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
        "cp": "binance",
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
        "cp": "binance",
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
        "cp": "",
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
        "cp": "",
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
        "cp": "huobi",
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
        "cp": "huobi",
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
        "cp": "huobi",
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
        "cp": "binance",
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
        "cp": "binance",
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
        "cp": "binance",
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
    "cp": "huobi",
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
              "cp": "binance",
              "floatingProfit": "11.43150209",
              "openAmount": "266.428871696500",
              "openVolume": "-0.071040000000",
              "symbol": "BTCUSDT10"
            },
            {
              "costRate": "0",
              "cp": "huobi",
              "floatingProfit": "0",
              "openAmount": "0.000000000000",
              "openVolume": "0.000000000000",
              "symbol": "BTCUSDT10"
            },
            {
              "costRate": "3732.57952708",
              "cp": "okex",
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
              "cp": "huobi",
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
        "cp": "okex",
        "mtmPl": "3.696945598500",
        "mtmQuote": "4020.806600000000",
        "openAmount": "199.393995767500",
        "openVolume": "-0.050510000000",
        "stateTime": "1545667217419",
        "symbol": "BTCUSDT10"
      },
      {
        "book": "B",
        "cp": "binance",
        "mtmPl": "8.752132224500",
        "mtmQuote": "4020.806600000000",
        "openAmount": "239.613091457500",
        "openVolume": "-0.061770000000",
        "stateTime": "1545667217418",
        "symbol": "BTCUSDT10"
      },
      {
        "book": "B",
        "cp": "huobi",
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
GET /api/v1/making/makingConfig

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME     | REQUIRED | TYPE   | DESCRIBE          | DEFAULT | VALUES RANGE |
| :------- | :------- | :----- | :---------------- | :------ | :----------- |
| cp       |          | string | CP (Abbreviation) |         |              |
| symbol   |          | string | Symbol            |         |              |

***params of return***

| NAME                        | TYPE       | DESCRIBE                |
| :-------------------------- | :--------- | :---------------------- |   
| id                          | integer    | ID                      |
| basic.cp                    | string     | CP (Abbreviation)       |
| basic.symbol                | string     | Symbol                  |
| basic.refCps                | array      | Ref Cps (Abbreviation)  |
| basic.baseCp                | string     | Base Cp (Abbreviation)  |
| level1.ladderDepth          | byte       | Ladder Depth            |
| level1.tickSize             | BigDecimal | Tick Size               |
| level1.stepHeight           | BigDecimal | Step Height             |
| level1.minSpread            | BigDecimal | Min Spread              |
| level1.maxVolume            | BigDecimal | Max Volume              |
| level1.priceAdjustType      | String     | [Price Adjust Type](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#user-content-priceadjusttype) |
| level1.bidVolumeAdjustRatio | BigDecimal | Bid Volume Adjust Ratio |
| level1.askVolumeAdjustRatio | BigDecimal | Ask Volume Adjust Ratio |
| level1.bidPriceAdjustRatio  | BigDecimal | Bid Price Adjust Ratio  |
| level1.askPriceAdjustRatio  | BigDecimal | Ask Price Adjust Ratio  |
| level1.bidPriceAdjustValue  | BigDecimal | Bid Price Adjust Value  |
| level1.askPriceAdjustValue  | BigDecimal | Ask Price Adjust Value  |
| level1.minTradesRatio       | BigDecimal | Min Trades Ratio        |
| level1.maxTradesRatio       | BigDecimal | Max Trades Ratio        |
| level1.orderFrequency       | integer    | Order Frequency/m       |
| level1.quoteExpiration      | long       | Quote Expiration/ms     |
| level1.tradeSendRatio       | BigDecimal | Trade Send Ratio        |
| level1.tradeVolumeDeduct    | boolean    | Trade Volume Deduct     |
| level1.orderActive          | boolean    | Order Active            |
| level1.tradesActive         | boolean    | Trades Active           |
| level2.minSpread            | BigDecimal | Min Spread              |
| level2.ladderDepth          | byte       | Ladder Depth            |
| level2.tickSize             | BigDecimal | Tick Size               |
| level2.maxDeviation         | BigDecimal | Max Deviation           |
| level2.minThreshold         | BigDecimal | Min Threshold           |
| level2.minVolume            | BigDecimal | Min Volume              |
| level2.maxVolume            | BigDecimal | Max Volume              |
| level2.orderActive          | boolean    | Order Active            |
| version                     | integer    | Version                 |


***example of return***

```
{
	"data": [{
		"basic": {
			"baseCp": "bc",
			"cp": "chainup",
			"refCps": [
				"bc",
				"huobi",
				"okex"
			],
			"symbol": "ETHUSDT"
		},
		"id": 17104898,
		"level1": {
			"askPriceAdjustRatio": "0.8",
			"askPriceAdjustValue": "1",
			"askVolumeAdjustRatio": "1",
			"bidPriceAdjustRatio": "0.2",
			"bidPriceAdjustValue": "0.5",
			"bidVolumeAdjustRatio": "1",
			"ladderDepth": 5,
			"maxTradesRatio": "1",
			"maxVolume": "2",
			"minSpread": "2",
			"minTradesRatio": "0.1",
			"orderActive": false,
			"orderFrequency": 60,
			"priceAdjustType": "VALUE",
			"quoteExpiration": "60000",
			"stepHeight": "0.02",
			"tickSize": "0.01",
			"tradeSendRatio": "1",
			"tradeVolumeDeduct": false,
			"tradesActive": false
		},
		"level2": {
			"ladderDepth": 5,
			"maxDeviation": "0.5",
			"maxVolume": "0.5",
			"minSpread": "100",
			"minThreshold": "40",
			"minVolume": "0.1",
			"orderActive": false,
			"tickSize": "0.01"
		},
		"version": 2
	}],
	"type": "DATA"
}
```



### add-making-config
POST /api/v1/making/makingConfig

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME                        | REQUIRED | TYPE       | DESCRIBE                | DEFAULT | VALUES RANGE                                |
| :-------------------------- | :------- | :--------- | :---------------------- | :------ | :------------------------------------------ |
| basic.cp                    | Y        | string     | CP (Abbreviation)       |         |                                             |
| basic.symbol                | Y        | string     | Symbol                  |         |                                             |
| basic.refCps                | Y        | array      | Ref Cps (Abbreviation)  |         |                                             |
| basic.baseCp                |          | string     | Base Cp (Abbreviation)  | NULL    | Must be included in basic.refCps            |
| level1.ladderDepth          | Y        | integer    | Ladder Depth            |         | Range: > 0 and <= 50                        |
| level1.tickSize             | Y        | BigDecimal | Tick Size               |         | Range: > 0, Precision:24, Scale:12          |
| level1.stepHeight           | Y        | BigDecimal | Step Height             |         | Range: > 0, Precision:24, Scale:12          |
| level1.minSpread            | Y        | BigDecimal | Min Spread              |         | Range: > 0, Precision:24, Scale:12          |
| level1.maxVolume            | Y        | BigDecimal | Max Volume              |         | Range: > 0, Precision:24, Scale:12          |
| level1.priceAdjustType      | Y        | string     | [Price Adjust Type](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#user-content-priceadjusttype) |         |                           |
| level1.bidVolumeAdjustRatio | Y        | BigDecimal | Bid Volume Adjust Ratio |         | Range: > 0 and <= 1, Precision:5, Scale:4   |
| level1.askVolumeAdjustRatio | Y        | BigDecimal | Ask Volume Adjust Ratio |         | Range: > 0 and <= 1, Precision:5, Scale:4   |
| level1.bidPriceAdjustRatio  |          | BigDecimal | Bid Price Adjust Ratio  | NULL    | Range: > 0 and <= 1, Precision:5, Scale:4   |
| level1.askPriceAdjustRatio  |          | BigDecimal | Ask Price Adjust Ratio  | NULL    | Range: > 0 and <= 1, Precision:5, Scale:4   |
| level1.bidPriceAdjustValue  |          | BigDecimal | Bid Price Adjust Value  | NULL    | Range: >= 0, Precision:24, Scale:12         |
| level1.askPriceAdjustValue  |          | BigDecimal | Ask Price Adjust Value  | NULL    | Range: >= 0, Precision:24, Scale:12         |
| level1.minTradesRatio       | Y        | BigDecimal | Min Trades Ratio        |         | Range: > 0 and <= 1, Precision:3, Scale:2   |
| level1.maxTradesRatio       | Y        | BigDecimal | Max Trades Ratio        |         | Range: > 0 and <= 1, Precision:3, Scale:2   |
| level1.orderFrequency       | Y        | integer    | Order Frequency/m       |         | Range: >= 0                                 |
| level1.quoteExpiration      | Y        | long       | Quote Expiration/ms     |         | Range: >= 0 and <= 60000                    |
| level1.tradeSendRatio       | Y        | BigDecimal | Trade Send Ratio        |         | Range: > 0 and <= 1, Precision:3, Scale:2   |
| level1.tradeVolumeDeduct    | Y        | boolean    | Trade Volume Deduct     |         |                                             |             
| level1.orderActive          | Y        | boolean    | Order Active            |         |                                             |
| level1.tradesActive         | Y        | boolean    | Trades Active           |         |                                             |
| level2.minSpread            | Y        | BigDecimal | Min Spread              |         | Range: > 0, Precision:24, Scale:12          |
| level2.ladderDepth          | Y        | byte       | Ladder Depth            |         | Range: > 0 and <= 50                        |
| level2.tickSize             | Y        | BigDecimal | Tick Size               |         | Range: > 0, Precision:24, Scale:12          |
| level2.maxDeviation         | Y        | BigDecimal | Max Deviation           |         | Range: > 0 and < 1, Precision:5, Scale:4    |
| level2.minThreshold         | Y        | BigDecimal | Min Threshold           |         | Range: > 0, Precision:24, Scale:12          |
| level2.minVolume            | Y        | BigDecimal | Min Volume              |         | Range: > 0, Precision:24, Scale:12          |
| level2.maxVolume            | Y        | BigDecimal | Max Volume              |         | Range: > 0, Precision:24, Scale:12          |
| level2.orderActive          | Y        | boolean    | Order Active            |         |                                             |
| version                     |          | integer    | Version                 | NULL    |                                             |


***example of request***

```
{
	"basic": {
		"cp": "chainup",
		"symbol": "ETHUSDT",
		"refCps": [
			"bc",
			"huobi",
			"okex"
		],
		"baseCp": null
	},
	"level1": {
		"ladderDepth": 5,
		"tickSize": 0.01,
		"stepHeight": 0.02,
		"minSpread": 2,
		"maxVolume": 2,
		"priceAdjustType": "VALUE",
		"bidVolumeAdjustRatio": 1,
		"askVolumeAdjustRatio": 1,
		"bidPriceAdjustRatio": 0.2,
		"askPriceAdjustRatio": 0.8,
		"bidPriceAdjustValue": 0.5,
		"askPriceAdjustValue": 1,
		"minTradesRatio": 0.1,
		"maxTradesRatio": 1,
		"orderFrequency": 60,
		"quoteExpiration": 60000,
		"tradeSendRatio": 1,
		"tradeVolumeDeduct": false,
		"orderActive": false,
		"tradesActive": false
	},
	"level2": {
		"minSpread": 100,
		"ladderDepth": 5,
		"tickSize": 0.01,
		"maxDeviation": 0.5,
		"minVolume": 0.1,
		"maxVolume": 0.5,
		"minThreshold": 40,
		"orderActive": false
	},
	"version": null
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
PUT /api/v1/making/makingConfig

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME                        | REQUIRED | TYPE       | DESCRIBE                | DEFAULT | VALUES RANGE                                |
| :-------------------------- | :------- | :--------- | :---------------------- | :------ | :------------------------------------------ |
| basic.cp                    | Y        | string     | CP (Abbreviation)       |         |                                             |
| basic.symbol                | Y        | string     | Symbol                  |         |                                             |
| basic.refCps                | Y        | array      | Ref Cps (Abbreviation)  |         |                                             |
| basic.baseCp                |          | string     | Base Cp (Abbreviation)  | NULL    | Must be included in basic.refCps            |
| level1.ladderDepth          | Y        | integer    | Ladder Depth            |         | Range: > 0 and <= 50                        |
| level1.tickSize             | Y        | BigDecimal | Tick Size               |         | Range: > 0, Precision:24, Scale:12          |
| level1.stepHeight           | Y        | BigDecimal | Step Height             |         | Range: > 0, Precision:24, Scale:12          |
| level1.minSpread            | Y        | BigDecimal | Min Spread              |         | Range: > 0, Precision:24, Scale:12          |
| level1.maxVolume            | Y        | BigDecimal | Max Volume              |         | Range: > 0, Precision:24, Scale:12          |
| level1.priceAdjustType      | Y        | string     | [Price Adjust Type](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#user-content-priceadjusttype) |         |                           |
| level1.bidVolumeAdjustRatio | Y        | BigDecimal | Bid Volume Adjust Ratio |         | Range: > 0 and <= 1, Precision:5, Scale:4   |
| level1.askVolumeAdjustRatio | Y        | BigDecimal | Ask Volume Adjust Ratio |         | Range: > 0 and <= 1, Precision:5, Scale:4   |
| level1.bidPriceAdjustRatio  |          | BigDecimal | Bid Price Adjust Ratio  | NULL    | Range: > 0 and <= 1, Precision:5, Scale:4   |
| level1.askPriceAdjustRatio  |          | BigDecimal | Ask Price Adjust Ratio  | NULL    | Range: > 0 and <= 1, Precision:5, Scale:4   |
| level1.bidPriceAdjustValue  |          | BigDecimal | Bid Price Adjust Value  | NULL    | Range: >= 0, Precision:24, Scale:12         |
| level1.askPriceAdjustValue  |          | BigDecimal | Ask Price Adjust Value  | NULL    | Range: >= 0, Precision:24, Scale:12         |
| level1.minTradesRatio       | Y        | BigDecimal | Min Trades Ratio        |         | Range: > 0 and <= 1, Precision:3, Scale:2   |
| level1.maxTradesRatio       | Y        | BigDecimal | Max Trades Ratio        |         | Range: > 0 and <= 1, Precision:3, Scale:2   |
| level1.orderFrequency       | Y        | integer    | Order Frequency/m       |         | Range: >= 0                                 |
| level1.quoteExpiration      | Y        | long       | Quote Expiration/ms     |         | Range: >= 0 and <= 60000                    |
| level1.tradeSendRatio       | Y        | BigDecimal | Trade Send Ratio        |         | Range: > 0 and <= 1, Precision:3, Scale:2   |
| level1.tradeVolumeDeduct    | Y        | boolean    | Trade Volume Deduct     |         |                                             |             
| level1.orderActive          | Y        | boolean    | Order Active            |         |                                             |
| level1.tradesActive         | Y        | boolean    | Trades Active           |         |                                             |
| level2.minSpread            | Y        | BigDecimal | Min Spread              |         | Range: > 0, Precision:24, Scale:12          |
| level2.ladderDepth          | Y        | byte       | Ladder Depth            |         | Range: > 0 and <= 50                        |
| level2.tickSize             | Y        | BigDecimal | Tick Size               |         | Range: > 0, Precision:24, Scale:12          |
| level2.maxDeviation         | Y        | BigDecimal | Max Deviation           |         | Range: > 0 and < 1, Precision:5, Scale:4    |
| level2.minThreshold         | Y        | BigDecimal | Min Threshold           |         | Range: > 0, Precision:24, Scale:12          |
| level2.minVolume            | Y        | BigDecimal | Min Volume              |         | Range: > 0, Precision:24, Scale:12          |
| level2.maxVolume            | Y        | BigDecimal | Max Volume              |         | Range: > 0, Precision:24, Scale:12          |
| level2.orderActive          | Y        | boolean    | Order Active            |         |                                             |
| version                     | Y        | integer    | Version                 |         |                                             |


***example of request***

```
{
	"basic": {
		"cp": "chainup",
		"symbol": "ETHUSDT",
		"refCps": [
			"bc",
			"huobi",
			"okex"
		],
		"baseCp": "bc"
	},
	"level1": {
		"ladderDepth": 5,
		"tickSize": 0.01,
		"stepHeight": 0.02,
		"minSpread": 2,
		"maxVolume": 2,
		"priceAdjustType": "VALUE",
		"bidVolumeAdjustRatio": 1,
		"askVolumeAdjustRatio": 1,
		"bidPriceAdjustRatio": 0.2,
		"askPriceAdjustRatio": 0.8,
		"bidPriceAdjustValue": 0.5,
		"askPriceAdjustValue": 1,
		"minTradesRatio": 0.1,
		"maxTradesRatio": 1,
		"orderFrequency": 60,
		"quoteExpiration": 60000,
		"tradeSendRatio": 1,
		"tradeVolumeDeduct": false,
		"orderActive": false,
		"tradesActive": false
	},
	"level2": {
		"minSpread": 100,
		"ladderDepth": 5,
		"tickSize": 0.01,
		"maxDeviation": 0.5,
		"minVolume": 0.1,
		"maxVolume": 0.5,
		"minThreshold": 40,
		"orderActive": false
	},
	"version": 1
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
DELETE /api/v1/making/makingConfig

request with Headers:

X-API-TOKEN:token（acquired from login）

***request params***

| NAME                 | REQUIRED | TYPE       | DESCRIBE          | DEFAULT | VALUES RANGE |
| :------------------- | :------- | :--------- | :---------------- | :------ | :----------- |
| id                   | Y        | integer    | config ID         |         |              |
| version              | Y        | integer    | version           |         |              |


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
