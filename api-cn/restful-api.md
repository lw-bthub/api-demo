# RestfulApi 接口信息(2018-11-20)

REST，即Representational State Transfer的缩写，是目前最流行的一种互联网软件架构。它结构清晰、符合标准、易于理解、扩展方便，正得到越来越多网站的采用。


- API访问地址    
    生产环境：https://trade.bthub.com:444/  
    测试环境：https://demo.bthub.com:444/     
- API测试工具    
    生产环境：https://trade.bthub.com:444/swagger-ui.html    
    测试环境：https://demo.bthub.com:444/swagger-ui.html 

## 接口列表

| 请求方法                                    | 类型 | 描述                   |
| :------------------------------------------ | :--- | :--------------------- |
| [/api/v1/operator/login](#登陆接口)         | POST | 登陆                   |
| [/api/v1/market/cps](#获取交易对手列表信息)       | GET  | 获取交易列表信息         |
| [/api/v1/market/symbols](#获取交易币对列表信息) | GET  | 获取交易币对列表信息     |
| [/api/v1/trades/place](#下单)                | POST | 投递交易               |
| [/api/v1/trades/orderDetail](#获取订单详情)        | GET  | 获取订单详情           |
| [/api/v1/trades/orderHistory](#获取订单历史列表信息)       | GET  | 获取订单历史列表信息   |
| [/api/v1/trades/cpOrderHistory](#获取cp订单历史列表信息)     | GET  | 获取CP订单历史列表信息 |
| [/api/v1/trades/cpExecutionHistory](#获取cp成交历史列表信息) | GET  | 获取CP成交历史列表信息 |
| [/api/v1/trades/cpExecutionDetail](#获取CP订单成交详情)  | GET  | 获取CP成交详细         |
| [/api/v1/market/cpAccountInfo](#获取交易账户信息)  | GET  | 获取交易账户信息         |

## Restful API
### 登陆接口
POST /api/v1/operator/login

***请求参数***

| NAME     | REQUIRED | TYPE   | DESCRIBE | DEFAULT | VALUES RANGE |
| :------- | :------- | :----- | :------- | :------ | :----------- |
| loginId  | Y        | string | 用户名    |         |              |
| password | Y        | string | 密码      |         |              |

***返回参数***

| NAME  | TYPE   | DESCRIBE |
| :---- | :----- | :------- |
| token | string | token    |

***返回参数示例***

```
{
  "data": {
    "token": "ZElHYkFsRktuZDduUG1udzI2V1lldyIsImFsZyI6IkEyNTZHQ01LVyIsIml2IjoicjZzLU83TGlYTUFYVEVxeSJ9.92p5f4TRYGPa16VZQgE1_FlhYwx6YCLeUlh-rlE3o_8.-wL8D1uL3GEEE3kj.qmBbSsSy92nYBt4WOLbU5MCH1NPbXO6k6_b5uGEG63xcQJ-Ny9K1VCMRtChQRol6l6fb5rNobNnOFAgeYzy2cqkje4HgUlL3BSRNlDj7G6W-60MwM2af7U2xshESv8LqLux2GZxPzCBmJz__HgluDxJwX2qNsMvOjM5k7Ckce8E1vHRJA18pkMzAL41HMFyzaf67Mp2SgXIaFHXVKVxdsOI.Gi2YOwudddsfdsafdsafa"
  },
  "result": "SUCCESS",
  "type": "API"
}
```

### 获取交易对手列表信息
GET /api/v1/market/cps

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

***返回参数***

| NAME           | TYPE    | DESCRIBE |
| :------------- | :------ | :------- |
| name           | string  | 名称 |
| tradingEnabled | boolean | 交易限制 |

***返回参数示例***

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

### 获取交易币对列表信息
GET  /api/v1/market/symbols

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

***返回参数***

| NAME               | TYPE       | DESCRIBE     |
| :----------------- | :--------- | :----------- |
| name               | string     | 交易币对名称         |
| tradingMaxVolume   | number     | 交易最大数量 |
| tradingMinVolume   | number     | 交易最小数量 |
| tradingPriceScale  | integer    | 价格精度     |
| tradingVolumeScale | integer    | 交易量精度   |

***返回参数示例***

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

### 下单
POST /api/v1/trades/place

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

***请求参数***

RequestBody:（order）

| NAME        | REQUIRED | TYPE       | DESCRIBE              | DEFAULT | VALUES RANGE |
| :---------- | :------- | :--------- | :-------------------- | :------ | :----------- |
| cp          |          | string     | 交易对手名称            |         |              |
| symbol      | Y        | string     | 交易币对名称            |         |              |
| orderPrice  | Y        | number     | 订单价格               |         |              |
| orderVolume | Y        | number     | 订单数量               |         |              |
| side        | Y        | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)        |         |              |
| orderType   | Y        | string     | [订单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)   |         |              |
| timeInForce | Y        | string     | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/enum.md) |         |              |

***请求参数示例***

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

 ***返回参数***

| NAME          | TYPE       | DESCRIBE              |
| :------------ | :--------- | :-------------------- |
| orderID       | integer    | 订单ID                |
| cpOrderId     | integer    | CP 订单ID                    |
| cp            | string     | 交易对手名称                |
| symbol        | string     | 交易币对名称              |
| executeAmount | number     | 成交金额              |
| executeVolume | number     | 成交数量              |
| orderVolume   | number     | 订单数量              |
| pendingVolume | number     | 未成交数量              |
| side          | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)        |
| orderType     | string     | [订单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)   |
| status        | string     | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)     |
| timeInForce   | string     | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/enum.md) |
| orderResult   | string     | [投递结果类型(DealingResult)](https://github.com/lw-bthub/api-demo/blob/master/enum.md) |
| orderTime     | integer    | 订单时间              |
| executeTime   | integer    | 成交时间                  |

***返回参数示例***

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

### 获取订单详情
GET /api/v1/trades/orderDetail

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

***请求参数***

| NAME     | REQUIRED | TYPE | DESCRIBE | DEFAULT | VALUES RANGE |
| :------- | :------- | :--- | :------- | :------ | :----------- |
| orderId | Y        | integer | 订单ID | -       |              |

***返回参数***

| NAME          | TYPE       | DESCRIBE              |
| :------------ | :--------- | :-------------------- |
| orderID       | integer    | 订单ID                |
| cpOrderId     | integer    | CP 订单ID                    |
| cp            | string     | 交易对手名称                |
| symbol        | string     | 交易币对名称              |
| executeAmount | number     | 成交金额              |
| executeVolume | number     | 成交数量              |
| orderVolume   | number     | 订单数量              |
| pendingVolume | number     | 未成交数量              |
| side          | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)        |
| orderType     | string     | [订单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)   |
| status        | string     | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)     |
| timeInForce   | string     | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/enum.md) |
| orderTime     | integer    | 订单时间              |
| executeTime   | integer    | 成交时间              |

***返回参数示例***

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

### 获取CP订单成交详情
GET  /api/v1/trades/cpExecutionDetail

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

***请求参数***

| NAME    | REQUIRED | TYPE | DESCRIBE | DEFAULT | VALUES RANGE |
| :------ | :------- | :--- | :------- | :------ | :----------- |
| cpOrderId | Y        | integer | CP订单ID   | -       |              |

***返回参数***

| NAME           | TYPE       | DESCRIBE       |
| :------------- | :--------- | :------------- |
| cpOrderid      | integer    | CP订单ID        |
| cp             | string     | 交易对手名称          |
| symbol         | string     | 交易币对名称       |
| orderId        | integer    | 父订单ID         |
| side           | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/enum.md) |
| executeAmount  | number     | 成交金额       |
| executePrice   | number     | 成交价格       |
| executeVolume  | number     | 成交数量       |
| executeTime    | integer    | 成交时间       |
| commission     | number     | 手续费         |
| executeComment | string     | 成交备注       |

***返回参数示例***

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


 ### 获取订单历史列表信息
 GET  /api/v1/trades/orderHistory

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

 ***请求参数***

| NAME     | REQUIRED | TYPE    | DESCRIBE          | DEFAULT | VALUES RANGE |
| :------- | :------- | :------ | :---------------- | :------ | :----------- |
| cp       |          | string   | 交易对手名称             | -       |              |
| symbol   |          | string | 货币对名称          | -       |              |
| status   |          | string  | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/enum.md) | -       |              |
| from     | Y        | integer    | 开始时间          | -       |              |
| to       | Y        | integer    | 结束时间          | -       |              |
| pageNo   |          | integer | 页码              | -       |              |

 ***返回参数***

| NAME          | TYPE       | DESCRIBE              |
| :------------ | :--------- | :-------------------- |
| pageCount     | integer    | 总页数                |
| pageNo        | integer    | 页码                  |
| pageSize      | integer    | 每页数量              |
| total         | integer    | 总条数                |
| cpOrderId     | integer    | CP订单ID                    |
| cp            | string     | 交易对手名称              |
| symbol        | string     | 币对名称             |
| orderId       | integer    | 父订单ID              |
| side          | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)        |
| status        | string     | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)     |
| orderResult   | string     | [结果(OrderResult)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)     |
| orderType     | string     | [订单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)   |
| orderPrice    | number     | 订单价格              |
| executeAmount | number     | 成交金额              |
| orderVolume   | number     | 订单数量              |
| pendingVolume | number     | 未成交数量              |
| executeVolume | number     | 成交数量              |
| executeTime   | integer    | 成交时间              |
| orderTime     | integer    | 订单时间              |
| timeInForce   | string     | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/enum.md) |
| commission    | number     | 手续费                |
| rejectReason  | string     | 拒绝原因              |
| orderComment  | string     | 备注                  |

 ***返回参数示例***

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

### 获取CP订单历史列表信息
GET  /api/v1/trades/cpOrderHistory

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

***请求参数***

| NAME     | REQUIRED | TYPE    | DESCRIBE          | DEFAULT | VALUES RANGE |
| :------- | :------- | :------ | :---------------- | :------ | :----------- |
| cp       |          | string  | 交易对手名称             | -       |              |
| symbol   |          | string  | 交易币对名称          | -       |              |
| status   |          | string  | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/enum.md) | -       |              |
| from     | Y        | integer    | 开始时间          | -       |              |
| to       | Y        | integer    | 结束时间          | -       |              |
| pageNo   |          | integer | 页码              | -       |              |

***返回参数***

| NAME          | TYPE       | DESCRIBE              |
| :------------ | :--------- | :-------------------- |
| pageCount     | integer    | 总页数                |
| pageNo        | integer    | 页码                  |
| pageSize      | integer    | 每页数量              |
| total         | integer    | 总条数                |
| cpOrderid     | integer    | CP OrderID                    |
| cp            | string     | 交易对手名称                |
| symbol        | string     | 交易币对名称              |
| orderId       | integer    | 父订单ID              |
| side          | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)        |
| status        | string     | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)     |
| orderType     | string     | [订单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)   |
| orderResult   | string     | [结果(OrderResult)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)     |
| executeAmount | number     | 成交金额              |
| orderPrice    | number     | 订单价格              |
| executeVolume | number     | 成交数量              |
| orderVolume   | number     | 订单数量              |
| pendingVolume | number     | 未成交数量              |
| orderTime     | integer    | 订单时间              |
| executeTime   | integer    | 成交时间              |
| timeInForce   | string     | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/enum.md) |
| commission    | number     | 手续费                |
| rejectReason  | string     | 拒绝原因              |
| orderComment  | string     | 备注                  |

***返回参数示例***

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

### 获取CP成交历史列表信息
GET  /api/v1/trades/cpExecutionHistory

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

***请求参数***

| NAME     | REQUIRED | TYPE    | DESCRIBE | DEFAULT | VALUES RANGE |
| :------- | :------- | :------ | :------- | :------ | :----------- |
| cp       |          | string   | 交易对手名称    | -       |              |
| symbol   |          | string   | 交易币对名称 | -       |              |
| from     | Y        | integer  | 开始时间 | -       |              |
| to       | Y        | integer  | 结束时间 | -       |              |
| pageNo   |          | integer  | 页码     | -       |              |

***返回参数***

| NAME           | TYPE       | DESCRIBE       |
| :------------- | :--------- | :------------- |
| pageCount      | integer       | 总页数         |
| pageNo         | integer       | 页码           |
| pageSize       | integer       | 每页数量       |
| total          | integer       | 总条数         |
| executeId      | integer       | 成交ID       |
| cp             | string     | 交易对手名称          |
| symbol         | string     | 交易币对名称    |
| cpOrderId      | integer       | CP订单ID         |
| side           | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/enum.md) |
| executePrice   | number     | 价格           |
| executeVolume  | number     | 成交数量       |
| executeAmount  | number     | 成交金额       |
| executeTime    | integer       | 成交时间       |
| commission     | number     | 手续费         |
| executeComment | string     | 备注           |

***返回参数示例***

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

### 获取交易账户信息
GET /api/v1/market/cpAccountInfo

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

***请求参数***

| NAME     | REQUIRED | TYPE   | DESCRIBE | DEFAULT | VALUES RANGE |
| :------- | :------- | :----- | :------- | :------ | :----------- |
| cp      | Y        | string | 交易对手名称    |         |              |

***返回参数***

| NAME  | TYPE   | DESCRIBE |
| :---- | :----- | :------- |
| cp     | string | 交易对手名称    |
| tradeable | boolean | 是否可交易    |
| currency | string | 币种    |
| free | number | 可用金额    |
| frozen | number | 冻结金额    |

***返回参数示例***

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
