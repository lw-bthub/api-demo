# RestfulApi 接口信息(2019-01-21)

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
| [/api/v1/trades/orderDetail](#根据orderId获取订单详情)        | GET  | 根据orderId获取订单详情           |
| [/api/v1/trades/clientOrderDetail](#根据clientOrderId获取订单详情)        | GET  | 根据clientOrderId获取订单详情           |
| [/api/v1/trades/orderHistory](#获取订单历史列表信息)       | GET  | 获取订单历史列表信息   |
| [/api/v1/trades/cpOrderHistory](#获取cp订单历史列表信息)     | GET  | 获取CP订单历史列表信息 |
| [/api/v1/trades/cpExecutionHistory](#获取cp成交历史列表信息) | GET  | 获取CP成交历史列表信息 |
| [/api/v1/trades/cpExecutionDetail](#获取CP订单成交详情)  | GET  | 获取CP成交详细         |
| [/api/v1/market/cpAccountInfo](#获取交易账户信息)  | GET  | 获取交易账户信息         |
| [/api/v1/risk/books](#获取账簿信息)  | GET  | 获取账簿信息         |
| [/api/v1/risk/positions](#获取风控信息)  | GET  | 获取风控信息         |
| [/api/v1/risk/statements](#获取结算信息)  | GET  | 获取结算信息         |
| [/api/v1/making/makingConfig](#获取做市配置)  | GET  | 获取做市配置         |
| [/api/v1/making/makingConfig](#新规做市配置)  | POST  | 新规做市配置         |
| [/api/v1/making/makingConfig](#修改做市配置)  | PUT  | 修改做市配置         |
| [/api/v1/making/makingConfig](#删除做市配置)  | DELETE  | 删除做市配置         |


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

| NAME          | REQUIRED | TYPE       | DESCRIBE              | DEFAULT | VALUES RANGE |
| :------------ | :------- | :--------- | :-------------------- | :------ | :----------- |
| cp            |          | string     | 交易对手名称            |         |              |
| book          |          | string     | 账簿                    |         |              |
| symbol        | Y        | string     | 交易币对名称            |         |              |
| orderPrice    | Y        | number     | 订单价格               |         |              |
| orderVolume   | Y        | number     | 订单数量               |         |              |
| side          | Y        | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)        |         |              |
| orderType     | Y        | string     | [订单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)   |         |              |
| timeInForce   | Y        | string     | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md) |         |              |
| clientOrderId |          | string     | 客户端订单ID                    |         |              |

***请求参数示例***

```
{
  "orderPrice": 0,
  "orderType": "MARKET",
  "orderVolume": 0.1,
  "side": "BUY",
  "symbol": "BTCUSDT",
  "timeInForce": "IOC"
  "clientOrderId": "1"
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
| side          | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)        |
| orderType     | string     | [订单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)   |
| status        | string     | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)     |
| timeInForce   | string     | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md) |
| orderResult   | string     | [投递结果类型(DealingResult)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md) |
| orderTime     | integer    | 订单时间              |
| executeTime   | integer    | 成交时间                  |
| clientOrderId | string     | 客户端订单ID                  |

***返回参数示例***

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

### 根据orderId获取订单详情
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
| side          | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)        |
| orderType     | string     | [订单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)   |
| status        | string     | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)     |
| timeInForce   | string     | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md) |
| orderTime     | integer    | 订单时间              |
| executeTime   | integer    | 成交时间              |
| clientOrderId | string     | 客户端订单ID              |

***返回参数示例***

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

### 根据clientOrderId获取订单详情
GET /api/v1/trades/clientOrderDetail

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME          | REQUIRED | TYPE | DESCRIPTION | DEFAULT | VALUES RANGE |
| :------------ | :------- | :--- | :------- | :------ | :----------- |
| clientOrderId | Y        | string | 客户端订单ID | -       |              |

***params of return***

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
| side          | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)        |
| orderType     | string     | [订单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)   |
| status        | string     | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)     |
| timeInForce   | string     | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md) |
| orderTime     | integer    | 订单时间              |
| executeTime   | integer    | 成交时间              |
| clientOrderId | string     | 客户端订单ID              |

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
| cp             | string     | 交易对手名称          |
| symbol         | string     | 交易币对名称       |
| side           | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md) |
| executeAmount  | number     | 成交金额       |
| executePrice   | number     | 成交价格       |
| cpExecutionid  | number     | CP约定ID       |
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
| status   |          | string  | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md) | -       |              |
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
| side          | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)        |
| status        | string     | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)     |
| orderResult   | string     | [结果(OrderResult)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)     |
| orderType     | string     | [订单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)   |
| orderPrice    | number     | 订单价格              |
| executeAmount | number     | 成交金额              |
| orderVolume   | number     | 订单数量              |
| pendingVolume | number     | 未成交数量              |
| executeVolume | number     | 成交数量              |
| executeTime   | integer    | 成交时间              |
| orderTime     | integer    | 订单时间              |
| timeInForce   | string     | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md) |
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

### 获取CP订单历史列表信息
GET  /api/v1/trades/cpOrderHistory

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

***请求参数***

| NAME     | REQUIRED | TYPE    | DESCRIBE          | DEFAULT | VALUES RANGE |
| :------- | :------- | :------ | :---------------- | :------ | :----------- |
| cp       |          | string  | 交易对手名称             | -       |              |
| symbol   |          | string  | 交易币对名称          | -       |              |
| status   |          | string  | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md) | -       |              |
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
| side          | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)        |
| status        | string     | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)     |
| orderType     | string     | [订单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)   |
| orderResult   | string     | [结果(OrderResult)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md)     |
| executeAmount | number     | 成交金额              |
| orderPrice    | number     | 订单价格              |
| executeVolume | number     | 成交数量              |
| orderVolume   | number     | 订单数量              |
| pendingVolume | number     | 未成交数量              |
| orderTime     | integer    | 订单时间              |
| executeTime   | integer    | 成交时间              |
| timeInForce   | string     | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md) |
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
| side           | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md) |
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

### 获取账簿信息
GET /api/v1/risk/books

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

***返回参数***

| NAME  | TYPE   | DESCRIBE |
| :---- | :----- | :------- |
| name | string | 账簿简称  |

***返回参数示例***

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

### 获取风控信息
GET /api/v1/risk/positions

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

***请求参数***

| NAME     | REQUIRED | TYPE   | DESCRIBE | DEFAULT | VALUES RANGE |
| :------- | :------- | :----- | :------- | :------ | :----------- |
| book      | Y        | string | 账簿缩写    |         |              |

***返回参数***

| NAME  | TYPE   | DESCRIBE |
| :---- | :----- | :------- |
| books | array | 某一币对的账簿集合(根据查询条件,比如 B账簿)  |
| book | string | 账本缩写    |
| cps | array |  某一账簿的交易对手集合 |
| cp | string | 交易对手缩写    |
| floatingProfit | number | 浮动损益    |
| openAmount | number | 金额    |
| openVolume | number | 净头寸    |
| symbol | string | 币对名称    |


***返回参数示例***

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



### 获取结算信息
GET /api/v1/risk/statements

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

***请求参数***

| NAME     | REQUIRED | TYPE   | DESCRIBE | DEFAULT | VALUES RANGE |
| :------- | :------- | :----- | :------- | :------ | :----------- |
| book      |         | string | 账簿名称    |         |              |
| symbol      |         | string | 币对名称    |         |              |
| from      | Y        | integer | 开始日期    |         |              |
| to      | Y        | integer | 结束日期    |         |              |
| pageNo      |         | integer | 页码    |     1    |              |

***返回参数***

| NAME           | TYPE       | DESCRIBE       |
| :------------- | :--------- | :------------- |
| pageCount      | integer       | 总页数         |
| pageNo         | integer       | 页码           |
| pageSize       | integer       | 每页数量       |
| total          | integer       | 总条数         |
| books | array | 某一币对的账簿集合(根据查询条件,比如 B账簿)  |
| book | string | 账本缩写    |
| cp | string | 交易对手缩写    |
| symbol | string | 币对名称    |
| openAmount | number | 金额    |
| openVolume | number | 净头寸    |
| stateTime | integer | 结算时间    |
| mtmPl | number |  盯市损益  |
| mtmQuote | number |  盯市价 |



***返回参数示例***

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



### 获取做市配置
GET /api/v1/making/makingConfig

请求时必须带Headers:

X-API-TOKEN:token（通过login获得）

***请求参数***

| NAME     | REQUIRED | TYPE   | DESCRIBE        | DEFAULT | VALUES RANGE |
| :------- | :------- | :----- | :-------------- | :------ | :----------- |
| cp       |          | string | 交易对手(缩写） |         |              |
| symbol   |          | string | 币对名称        |         |              |

***返回参数***

| NAME                        | TYPE       | DESCRIBE            |
| :-------------------------- | :--------- | :------------------ |   
| id                          | integer    | 配置ID              |
| basic.cp                    | string     | 交易对手(缩写）     |
| basic.symbol                | string     | 币对名称            |
| basic.refCps                | array      | 流动性来源(缩写）   |
| basic.baseCp                | string     | 基础LP(缩写）       |
| level1.ladderDepth          | byte       | 深度                |
| level1.tickSize             | BigDecimal | 最小价格单位        |
| level1.stepHeight           | BigDecimal | 步长                |
| level1.minSpread            | BigDecimal | 最小点差            |
| level1.maxVolume            | BigDecimal | 最大交易数量        |
| level1.priceAdjustType      | String     | [价格调整类型](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#user-content-priceadjusttype) |
| level1.bidVolumeAdjustRatio | BigDecimal | BID数量调整比例     |
| level1.askVolumeAdjustRatio | BigDecimal | ASK数量调整比例     |
| level1.bidPriceAdjustRatio  | BigDecimal | BID价格调整比例     |
| level1.askPriceAdjustRatio  | BigDecimal | ASK价格调整比例     |
| level1.bidPriceAdjustValue  | BigDecimal | BID价格调整点数     |
| level1.askPriceAdjustValue  | BigDecimal | ASK价格调整点数     |
| level1.minTradesRatio       | BigDecimal | 最小成交比例        |
| level1.maxTradesRatio       | BigDecimal | 最大成交比例        |
| level1.orderFrequency       | integer    | 发送订单频率/分     |
| level1.quoteExpiration      | long       | 汇率过期时间/毫秒   |
| level1.tradeSendRatio       | BigDecimal | 成交概率            |
| level1.tradeVolumeDeduct    | boolean    | 成交数量扣除        |
| level1.orderActive          | boolean    | 发送订单            |
| level1.tradesActive         | boolean    | 成交                |
| level2.minSpread            | BigDecimal | 最小点差            |
| level2.ladderDepth          | byte       | 深度                |
| level2.tickSize             | BigDecimal | 最小价格单位        |
| level2.maxDeviation         | BigDecimal | 最大偏离量          |
| level2.minThreshold         | BigDecimal | 最小阈值            |
| level2.minVolume            | BigDecimal | 最小交易数量        |
| level2.maxVolume            | BigDecimal | 最大交易数量        |
| level2.orderActive          | boolean    | 发送订单            |
| version                     | integer    | 版本号              |


***返回参数示例***

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



### 新规做市配置
POST /api/v1/making/makingConfig

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

***请求参数***

| NAME                        | REQUIRED | TYPE       | DESCRIBE            | DEFAULT | VALUES RANGE                                      |
| :-------------------------- | :------- | :--------- | :------------------ | :------ | :------------------------------------------------ |
| basic.cp                    | Y        | string     | 交易对手(缩写）     |         |                                                   |
| basic.symbol                | Y        | string     | 币对名称            |         |                                                   |
| basic.refCps                | Y        | array      | 流动性来源(缩写）   |         |                                                   |
| basic.baseCp                |          | string     | 基础LP(缩写）       | NULL    | 必须包含于 basic.refCps                           |
| level1.ladderDepth          | Y        | integer    | 深度                |         | 取值范围：> 0 并且 <= 50                          |
| level1.tickSize             | Y        | BigDecimal | 最小价格单位        |         | 取值范围：> 0， 精度：24，小数位数：12            |
| level1.tepHeight            | Y        | BigDecimal | 步长                |         | 取值范围：> 0， 精度：24，小数位数：12            |
| level1.minSpread            | Y        | BigDecimal | 最小点差            |         | 取值范围：> 0， 精度：24，小数位数：12            |
| level1.maxVolume            | Y        | BigDecimal | 最大交易数量        |         | 取值范围：> 0， 精度：24，小数位数：12            |
| level1.priceAdjustType      | Y        | string     | [价格调整类型](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#user-content-priceadjusttype) |         |                         |
| level1.bidVolumeAdjustRatio | Y        | BigDecimal | BID数量调整比例     |         | 取值范围：> 0 并且 <= 1， 精度：5， 小数位数：4   |
| level1.askVolumeAdjustRatio | Y        | BigDecimal | ASK数量调整比例     |         | 取值范围：> 0 并且 <= 1， 精度：5， 小数位数：4   |
| level1.bidPriceAdjustRatio  |          | BigDecimal | BID价格调整比例     |         | 取值范围：> 0 并且 <= 1， 精度：5， 小数位数：4   |
| level1.askPriceAdjustRatio  |          | BigDecimal | ASK价格调整比例     |         | 取值范围：> 0 并且 <= 1， 精度：5， 小数位数：4   |
| level1.bidPriceAdjustValue  |          | BigDecimal | BID价格调整点数     |         | 取值范围：>= 0， 精度：24， 小数位数：12          |
| level1.askPriceAdjustValue  |          | BigDecimal | ASK价格调整点数     |         | 取值范围：>= 0， 精度：24， 小数位数：12          |
| level1.minTradesRatio       | Y        | BigDecimal | 最小成交比例        |         | 取值范围：> 0 并且 <= 1， 精度：3， 小数位数：2   |
| level1.maxTradesRatio       | Y        | BigDecimal | 最大成交比例        |         | 取值范围：> 0 并且 <= 1， 精度：3， 小数位数：2   |
| level1.orderFrequency       | Y        | integer    | 发送订单频率/分     |         | 取值范围：>= 0                                    |
| level1.quoteExpiration      | Y        | long       | 汇率过期时间/毫秒   |         | 取值范围：>= 0 并且 <= 60000                      |
| level1.tradeSendRatio       | Y        | BigDecimal | 成交概率            |         | 取值范围：> 0 并且 <= 1， 精度：3， 小数位数：2   |
| level1.tradeVolumeDeduct    | Y        | boolean    | 成交数量扣除        |         |                                                   |
| level1.orderActive          | Y        | boolean    | 发送订单            |         |                                                   |
| level1.tradesActive         | Y        | boolean    | 成交                |         |                                                   |
| level2.minSpread            | Y        | BigDecimal | 最小点差            |         | 取值范围：> 0， 精度：24， 小数位数：12           |
| level2.ladderDepth          | Y        | byte       | 深度                |         | 取值范围：> 0 并且 <= 50                          |
| level2.tickSize             | Y        | BigDecimal | 最小价格单位        |         | 取值范围：> 0， 精度：24， 小数位数：12           |
| level2.maxDeviation         | Y        | BigDecimal | 最大偏离量          |         | 取值范围：> 0 并且 < 1， 精度：5， 小数位数：4    |
| level2.minThreshold         | Y        | BigDecimal | 最小阈值            |         | 取值范围：> 0， 精度：24， 小数位数：12           |
| level2.minVolume            | Y        | BigDecimal | 最小交易数量        |         | 取值范围：> 0， 精度：24， 小数位数：12           |
| level2.maxVolume            | Y        | BigDecimal | 最大交易数量        |         | 取值范围：> 0， 精度：24， 小数位数：12           |
| level2.orderActive          | Y        | boolean    | 发送订单            |         |                                                   |
| version                     |          | integer    | 版本                | NULL    |                                                   |


***请求参数示例***

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

###### 新规执行异常：
```
{
  "result": "INTERNAL_ERROR",
  "type": "API"
}
```



### 修改做市配置
PUT /api/v1/making/makingConfig

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

***请求参数***

| NAME                        | REQUIRED | TYPE       | DESCRIBE            | DEFAULT | VALUES RANGE                                      |
| :-------------------------- | :------- | :--------- | :------------------ | :------ | :------------------------------------------------ |
| basic.cp                    | Y        | string     | 交易对手(缩写）     |         |                                                   |
| basic.symbol                | Y        | string     | 币对名称            |         |                                                   |
| basic.refCps                | Y        | array      | 流动性来源(缩写）   |         |                                                   |
| basic.baseCp                |          | string     | 基础LP(缩写）       | NULL    | 必须包含于 basic.refCps                           |
| level1.ladderDepth          | Y        | integer    | 深度                |         | 取值范围：> 0 并且 <= 50                          |
| level1.tickSize             | Y        | BigDecimal | 最小价格单位        |         | 取值范围：> 0， 精度：24，小数位数：12            |
| level1.tepHeight            | Y        | BigDecimal | 步长                |         | 取值范围：> 0， 精度：24，小数位数：12            |
| level1.minSpread            | Y        | BigDecimal | 最小点差            |         | 取值范围：> 0， 精度：24，小数位数：12            |
| level1.maxVolume            | Y        | BigDecimal | 最大交易数量        |         | 取值范围：> 0， 精度：24，小数位数：12            |
| level1.priceAdjustType      | Y        | string     | [价格调整类型](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#user-content-priceadjusttype) |         |                         |
| level1.bidVolumeAdjustRatio | Y        | BigDecimal | BID数量调整比例     |         | 取值范围：> 0 并且 <= 1， 精度：5， 小数位数：4   |
| level1.askVolumeAdjustRatio | Y        | BigDecimal | ASK数量调整比例     |         | 取值范围：> 0 并且 <= 1， 精度：5， 小数位数：4   |
| level1.bidPriceAdjustRatio  |          | BigDecimal | BID价格调整比例     |         | 取值范围：> 0 并且 <= 1， 精度：5， 小数位数：4   |
| level1.askPriceAdjustRatio  |          | BigDecimal | ASK价格调整比例     |         | 取值范围：> 0 并且 <= 1， 精度：5， 小数位数：4   |
| level1.bidPriceAdjustValue  |          | BigDecimal | BID价格调整点数     |         | 取值范围：>= 0， 精度：24， 小数位数：12          |
| level1.askPriceAdjustValue  |          | BigDecimal | ASK价格调整点数     |         | 取值范围：>= 0， 精度：24， 小数位数：12          |
| level1.minTradesRatio       | Y        | BigDecimal | 最小成交比例        |         | 取值范围：> 0 并且 <= 1， 精度：3， 小数位数：2   |
| level1.maxTradesRatio       | Y        | BigDecimal | 最大成交比例        |         | 取值范围：> 0 并且 <= 1， 精度：3， 小数位数：2   |
| level1.orderFrequency       | Y        | integer    | 发送订单频率/分     |         | 取值范围：>= 0                                    |
| level1.quoteExpiration      | Y        | long       | 汇率过期时间/毫秒   |         | 取值范围：>= 0 并且 <= 60000                      |
| level1.tradeSendRatio       | Y        | BigDecimal | 成交概率            |         | 取值范围：> 0 并且 <= 1， 精度：3， 小数位数：2   |
| level1.tradeVolumeDeduct    | Y        | boolean    | 成交数量扣除        |         |                                                   |
| level1.orderActive          | Y        | boolean    | 发送订单            |         |                                                   |
| level1.tradesActive         | Y        | boolean    | 成交                |         |                                                   |
| level2.minSpread            | Y        | BigDecimal | 最小点差            |         | 取值范围：> 0， 精度：24， 小数位数：12           |
| level2.ladderDepth          | Y        | byte       | 深度                |         | 取值范围：> 0 并且 <= 50                          |
| level2.tickSize             | Y        | BigDecimal | 最小价格单位        |         | 取值范围：> 0， 精度：24， 小数位数：12           |
| level2.maxDeviation         | Y        | BigDecimal | 最大偏离量          |         | 取值范围：> 0 并且 < 1， 精度：5， 小数位数：4    |
| level2.minThreshold         | Y        | BigDecimal | 最小阈值            |         | 取值范围：> 0， 精度：24， 小数位数：12           |
| level2.minVolume            | Y        | BigDecimal | 最小交易数量        |         | 取值范围：> 0， 精度：24， 小数位数：12           |
| level2.maxVolume            | Y        | BigDecimal | 最大交易数量        |         | 取值范围：> 0， 精度：24， 小数位数：12           |
| level2.orderActive          | Y        | boolean    | 发送订单            |         |                                                   |
| version                     | Y        | integer    | 版本                |         |                                                   |


***请求参数示例***

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

***返回参数***

| NAME                 | TYPE       | DESCRIBE                                                                         |
| :------------------- | :--------- | :------------------------------------------------------------------------------- |   
| result               | string     | 'SUCCESS' 或 'INVALID_DATA' 或 'REJECTED' 或 'STALE_VERSION' 或 'INTERNAL_ERROR' |
| type                 | string     | 'API'                                                                            |


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

###### 目标配置不存在，拒绝更新：
```
{
  "result": "REJECTED",
  "type": "API"
}
```

###### 版本不匹配：
```
{
  "result": "STALE_VERSION",
  "type": "API"
}
```

###### 更新执行异常：
```
{
  "result": "INTERNAL_ERROR",
  "type": "API"
}
```



### 删除做市配置
DELETE /api/v1/making/makingConfig

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

***请求参数***

| NAME                 | REQUIRED | TYPE       | DESCRIBE   | DEFAULT | VALUES RANGE |
| :------------------- | :------- | :--------- | :--------- | :------ | :----------- |
| id                   | Y        | integer    | 配置ID     |         |              |
| version              | Y        | integer    | 版本号     |         |              |


***返回参数***

| NAME                 | TYPE       | DESCRIBE                                                                         |
| :------------------- | :--------- | :------------------------------------------------------------------------------- |   
| result               | string     | 'SUCCESS' 或 'REJECTED' 或 'UNAUTHORIZED' 或 'STALE_VERSION' 或 'INTERNAL_ERROR' |
| type                 | string     | 'API'                                                                            |


***返回参数示例***

###### 执行成功：
```
{
  "result": "SUCCESS",
  "type": "API"
}
```

###### 目标配置不存在，拒绝删除：
```
{
  "result": "REJECTED",
  "type": "API"
}
```

###### 没有权限删除：
```
{
  "result": "UNAUTHORIZED",
  "type": "API"
}
```

###### 版本不匹配：
```
{
  "result": "STALE_VERSION",
  "type": "API"
}
```

###### 删除执行异常：
```
{
  "result": "INTERNAL_ERROR",
  "type": "API"
}
```
