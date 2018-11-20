# RestfulApi informations(2018-11-20)


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
| [/api/v1/market/cps](#get_counter_party_list)                       | GET  | get counter party list          |
| [/api/v1/market/symbols](#get_crypto_pairs_list)                   | GET  | get crypto pairs list       |
| [/api/v1/trades/place](#place_order)                     | POST | place orders (SOR)               |
| [/api/v1/trades/orderDetail](#get_detail_of_orders)               | GET  | get  detail  of orders         |
| [/api/v1/trades/orderHistory](#get_history_list_of_orders)              | GET  | get history  list of orders   |
| [/api/v1/trades/cpOrderHistory](#get_CP_history_list_of_placed_orders)            | GET  | get CP history list of placed orders |
| [/api/v1/trades/cpExecutionHistory](get_CP_history_list_of_executed_orders)        | GET  | get CP history list of executed orders |
| [/api/v1/trades/cpExecutionDetail](#get_CP_detail_of_executed_order)         | GET  | get CP detail of executed orders         |
| [/api/v1/market/cpAccountInfo](#get_account_info)             | GET  | get account info         |

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

| NAME        | REQUIRED | TYPE       | DESCRIPTION              | DEFAULT | VALUES RANGE |
| :---------- | :------- | :--------- | :-------------------- | :------ | :----------- |
| cp          |          | string     | counter party name            |         |              |
| symbol      | Y        | string     | crypto pair name            |         |              |
| orderPrice  | Y        | number     | order Price               |         |              |
| orderVolume | Y        | number     | order Volume               |         |              |
| side        | Y        | string     | BUY or SELL(Side)       |         |              |
| orderType   | Y        | string     | Order Type)   |         |              |
| timeInForce | Y        | string     | Time In Force) |         |              |

***example of request***

```
{
  "cp": "",
  "orderPrice": 0,
  "orderType": "MARKET",
  "orderVolume": 0.1,
  "side": "BUY",
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
| side          | string     | BUY or SELL(Side)]       |
| orderType     | string     | Order Type  |
| status        | string     | Order Status     |
| timeInForce   | string     | Time In Force |
| orderResult   | string     | Dealing Result |
| orderTime     | integer    | place order Time              |
| executeTime   | integer    | executed Time                  |

***example of return***

```
{
  "data": {
    "order": {
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

***example of return***

```
{
  "data": {
    "order": {
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
| cpOrderid      | integer    | CP ORDER ID        |
| cp             | string     | counter party name          |
| symbol         | string     | crypto pair name       |
| orderId        | integer    | parent order ID         |
| side           | string     | BUY OR SELL(Side) |
| executeAmount  | number     | executed Amount       |
| executePrice   | number     | executed Price       |
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
     "pageCount": 5,
     "pageNo": 1,
     "pageSize": 100,
     "records": [
       {
         "cp": "",
         "cpOrderid": "764267539923479583",
         "executeAmount": "0",
         "executeTime": "0",
         "executeVolume": "0",
         "orderId": "0",
         "orderResult": 1,
         "orderTime": "1542681790461",
         "orderType": 5,
         "orderVolume": "0.01",
         "pendingVolume": "0.01",
         "side": 1,
         "status": 9,
         "symbol": "BTCUSDT",
         "timeInForce": 1
       },
       {
         "cp": "",
         "cpOrderid": "764266115630114847",
         "executeAmount": "0",
         "executeTime": "0",
         "executeVolume": "0",
         "orderId": "0",
         "orderResult": 1,
         "orderTime": "1542681620672",
         "orderType": 5,
         "orderVolume": "0.01",
         "pendingVolume": "0.01",
         "side": 1,
         "status": 9,
         "symbol": "BTCUSDT",
         "timeInForce": 1
       },
       {
         "cp": "",
         "cpOrderid": "764265498077570079",
         "executeAmount": "0",
         "executeTime": "0",
         "executeVolume": "0",
         "orderId": "0",
         "orderResult": 1,
         "orderTime": "1542681547055",
         "orderType": 5,
         "orderVolume": "0.01",
         "pendingVolume": "0.01",
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
        "cpOrderid": "763674965944851487",
        "executeAmount": "0",
        "executeTime": "0",
        "executeVolume": "0",
        "orderComment": "763674959004616725.0",
        "orderId": "0",
        "orderResult": 1,
        "orderTime": "1542611150139",
        "orderType": 5,
        "orderVolume": "0.01",
        "pendingVolume": "0.01",
        "side": 1,
        "status": 9,
        "symbol": "BTCUSDT",
        "timeInForce": 1
      },
      {
        "commission": "0.0100",
        "cp": "huobi",
        "cpOrderid": "763672199088331295",
        "executeAmount": "0",
        "executeTime": "0",
        "executeVolume": "0",
        "orderComment": "763672193516004885.2",
        "orderId": "0",
        "orderResult": 1,
        "orderTime": "1542610820303",
        "orderType": 5,
        "orderVolume": "0.01",
        "pendingVolume": "0.01",
        "side": 1,
        "status": 9,
        "symbol": "BTCUSDT",
        "timeInForce": 1
      },
      {
        "commission": "0.0100",
        "cp": "huobi",
        "cpOrderid": "763670455230945311",
        "executeAmount": "0",
        "executeTime": "0",
        "executeVolume": "0",
        "orderComment": "763670445403294741.0",
        "orderId": "0",
        "orderResult": 1,
        "orderTime": "1542610612419",
        "orderType": 5,
        "orderVolume": "0.01",
        "pendingVolume": "0.01",
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
