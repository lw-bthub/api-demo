# RestfulApi 接口信息(2019-01-29)

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
| [/api/v1/making/makingConfigs](#获取做市配置)  | GET  | 获取做市配置         |
| [/api/v1/making/makingConfigs/create](#新增做市配置)  | POST  | 新增做市配置         |
| [/api/v1/making/makingConfigs/update](#修改做市配置)  | PUT  | 修改做市配置         |
| [/api/v1/making/makingConfigs/delete](#删除做市配置)  | DELETE  | 删除做市配置         |
| [/api/v1/making/sourceLiquidityConfigs](#获取流动性来源配置)  | GET  | 获取流动性来源配置         |
| [/api/v1/making/sourceLiquidityConfigs/create](#增加流动性来源配置)  | POST  | 增加流动性来源配置         |
| [/api/v1/making/sourceLiquidityConfigs/update](#修改流动性来源配置)  | PUT  | 更新流动性来源配置         |
| [/api/v1/making/sourceLiquidityConfigs/delete](#删除流动性来源配置)  | DELETE  | 删除流动性来源配置         |


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
    "token": "ZElHYkFsRktuZDduUG1udzI2V1lldyIsImFsZyI6IkEyNTZHQ01LVyIsIml2IjoicjZzLU83TGlYTUFYVEVxeSJ9.92p5FlhYwx6YCLeUlh-rlE3o_8.-wL8D1uL3GEEE3kj.qmBbSsSy92nYBt4WOLbU5MCH1NPbXO6k6_b5uGEG63xcQJ-Ny9K1VCMRtChQRol6l6fb5rNobNnOFAgeYzy2cqkje4HgUlL3BSRNlDj7G6W-60MwM2af7U2xshESv8LqLux2GZxPzCBmJz__HgluDxJwX2qNsMvOjM5k7Ckce8E1vHRJA18pkMzAL41HMFyzaf67Mp2SgXIaFHXVKVxdsOI.Gi2YOwudddsfdsafdsafa"
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
| cps            |         | array      | 交易对手名称            |         |              |
| book          |          | string     | 账簿                    |         |              |
| symbol        | Y        | string     | 交易币对名称            |         |              |
| orderPrice    | Y        | number     | 订单价格               |         |              |
| slippage      |          | number     | 滑点                 |         |              |
| orderVolume   | Y        | number     | 订单数量               |         |              |
| side          | Y        | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#side)        |         |              |
| orderType     | Y        | string     | [订单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#ordertype)   |         |              |
| timeInForce   | Y        | string     | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#timeinforce) |         |              |
| clientOrderId |          | string     | 客户端订单ID                    |         |              |

***请求参数示例***

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
| side          | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#side)        |
| orderType     | string     | [订单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#ordertype)   |
| status        | string     | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#orderstatus)     |
| timeInForce   | string     | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#timeinforce) |
| orderResult   | string     | [投递结果类型(DealingResult)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#orderresult) |
| orderTime     | integer    | 订单时间              |
| executeTime   | integer    | 成交时间                  |
| clientOrderId | string     | 客户端订单ID                  |
| commission    | number     | 手续费         |

***返回参数示例***

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
| side          | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#side)        |
| orderType     | string     | [订单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#ordertype)   |
| status        | string     | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#orderstatus)     |
| timeInForce   | string     | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#timeinforce) |
| orderTime     | integer    | 订单时间              |
| executeTime   | integer    | 成交时间              |
| clientOrderId | string     | 客户端订单ID              |

***返回参数示例***

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
| side          | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#side)        |
| orderType     | string     | [订单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#ordertype)   |
| status        | string     | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#orderstatus)     |
| timeInForce   | string     | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#timeinforce) |
| orderTime     | integer    | 订单时间              |
| executeTime   | integer    | 成交时间              |
| clientOrderId | string     | 客户端订单ID              |

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
| side           | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#side) |
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


 ### 获取订单历史列表信息
 GET  /api/v1/trades/orderHistory

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

 ***请求参数***

| NAME     | REQUIRED | TYPE    | DESCRIBE          | DEFAULT | VALUES RANGE |
| :------- | :------- | :------ | :---------------- | :------ | :----------- |
| cp       |          | string   | 交易对手名称             | -       |              |
| symbol   |          | string | 货币对名称          | -       |              |
| status   |          | string  | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#orderstatus) | -       |              |
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
| side          | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#side)        |
| status        | string     | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#orderstatus)     |
| orderResult   | string     | [投递结果类型(DealingResult)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#orderresult)     |
| orderType     | string     | [订单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#ordertype)   |
| orderPrice    | number     | 订单价格              |
| executeAmount | number     | 成交金额              |
| orderVolume   | number     | 订单数量              |
| pendingVolume | number     | 未成交数量              |
| executeVolume | number     | 成交数量              |
| executeTime   | integer    | 成交时间              |
| orderTime     | integer    | 订单时间              |
| timeInForce   | string     | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#timeinforce) |
| commission    | number     | 手续费                |
| rejectReason  | string     | 拒绝原因              |
| orderComment  | string     | 备注                  |

 ***返回参数示例***

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

### 获取CP订单历史列表信息
GET  /api/v1/trades/cpOrderHistory

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

***请求参数***

| NAME     | REQUIRED | TYPE    | DESCRIBE          | DEFAULT | VALUES RANGE |
| :------- | :------- | :------ | :---------------- | :------ | :----------- |
| cp       |          | string  | 交易对手名称             | -       |              |
| symbol   |          | string  | 交易币对名称          | -       |              |
| status   |          | string  | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#orderstatus) | -       |              |
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
| side          | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#side)       |
| status        | string     | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#orderstatus)     |
| orderType     | string     | [订单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#ordertype)   |
| orderResult   | string     | [投递结果类型(DealingResult)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#orderresult)     |
| executeAmount | number     | 成交金额              |
| orderPrice    | number     | 订单价格              |
| executeVolume | number     | 成交数量              |
| orderVolume   | number     | 订单数量              |
| pendingVolume | number     | 未成交数量              |
| orderTime     | integer    | 订单时间              |
| executeTime   | integer    | 成交时间              |
| timeInForce   | string     | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#timeinforce) |
| commission    | number     | 手续费                |
| rejectReason  | string     | 拒绝原因              |
| orderComment  | string     | 备注                  |

***返回参数示例***

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
| cpOrderId      | integer    | CP订单ID         |
| side           | string     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/api-cn/enum.md#side) |
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
    "cp": "xxx",
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



### 获取做市配置
GET /api/v1/making/makingConfigs

请求时必须带Headers:

X-API-TOKEN:token（通过login获得）

***请求参数***

| NAME     | REQUIRED | TYPE   | DESCRIBE        | DEFAULT | VALUES RANGE |
| :------- | :------- | :----- | :-------------- | :------ | :----------- |
| cp       |          | string | 交易对手(缩写）      |                     |              |
| symbol   |          | string | 币对名称                   |                      |              |

***返回参数***

| NAME                          | TYPE        | DESCRIBE                  |
| :---------------------------- | :---------- | :------------------------ |
| cp                            |string       |  交易对手                     |
| symbol                        |string       |  商品名称                | 
| frequency                     |integer      |  发送订单频率/分          |
| l1OrderActive                 |boolean      |  L1 发送订单             |
| tradeActive                   |boolean      |  成交                    |
| l2OrderActive                 |boolean      |  L2 发送订单             |
| l1ConfigType                  |string       |  L1 [配置类型(MakingOrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#makingordertype) |
| l1Config                      |string       |  L1 配置                    |
| l1TickSize                    |number       |  L1 最小价格单位             | 
| l1LadderDepth                 |byte         |  L1 深度                    |
| l1StepHeight                  |number       |  L1 步长                    |  
| l1MinSpread                   |number       |  L1 最小点差                 |  
| l1MaxDeviation                |number       |  最大偏离量               |  
| tradeType                     |string       |  [成交类型(MakingTickType)](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#makingticktype)  |
| tradePriceType                |string       |  [成交价格类型(LpType)](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#lptype)  |
| tradePriceAdjustRatio         |number       |  成交价格调整比例            |  
| tradeRefSpread                |BigDnumber   |   成交参照点差                |  
| tradeVolumeUpperLimit         |number       |  最大交易量                  |  
| tradeVolumeLowerLimit         |number       |  最小交易量                  |  
| tradeSendRatio                |number       |  成交概率                    |  
| tradeVolumeDeduct             |boolean      |  成交数量扣除                |
| maxTradeVolumeRatio           |number       |  最大成交比例               |  
| minTradeVolumeRatio           |number       |  最小成交比例               |  
| l2MinSpread                   |number       |  L2 最小点差                   |  
| l2LadderDepth                 |byte         |  L2 深度                       |
| l2TickSize                    |number       |  L2 最小价格单位              |  
| l2MaxDeviation                |number       |  L2 最大偏离量                |  
| l2MinThreshold                |number       |  L2 最小阈值                  |  
| l2MinVolume                   |number       |  L2 最小交易数量              |  
| l2MaxVolume                   |number       |  L2 最大交易数量              |  


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



### 新增做市配置
POST /api/v1/making/makingConfigs/create

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME                          | REQUIRED | TYPE        | DESCRIBE                  | DEFAULT | VALUES RANGE                                           |
| :---------------------------- | :------- | :---------- | :------------------------ | :------ | :----------------------------------------------------- |
| cp                            | Y        |string       |  交易对手(缩写）         |         |  Must be included in cp                                |
| symbol                        | Y        |string       |  币对名称   |            |                                                        | 
| frequency                     | Y        |integer      |  发送频率/分             |         | Range: > 0                                             |
| l1OrderActive                 | Y        |boolean      |  L1 发送订单             |         |                                                        |
| tradeActive                   | Y        |boolean      |  成交                    |         |                                                        |
| l2OrderActive                 | Y        |boolean      |  L2 发送订单             |         |                                                        |
| l1ConfigType                  | Y        |string       |  L1 [配置类型MakingOrderType](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#makingordertype) |         |               |
| l1Config                      | Y        |string       |  L1 配置                    |         |  Must be included in source liquidity config                                            |
| l1TickSize                    | Y        |number       |  L1 最小价格单位             |         |  Range: > 0, Precision:24, Scale:12                                                      | 
| l1LadderDepth                 | Y        |byte         |  L1 深度                    |         |  Range: > 0                                                      |
| l1StepHeight                  | Y        |number       |  L1 步长                    |         |  Range: > 0, Precision:24, Scale:12                                                      |  
| l1MinSpread                   | Y        |number       |  L1 最小点差                |         |  Range: > 0, Precision:24, Scale:12                                                      |  
| l1MaxDeviation                | Y        |number       |  L1 最大偏离量              |         |  Range: > 0 & < 100, Precision:4, Scale:2                                                 |  
| tradeType                     | Y        |string       |  [成交类型(MakingTickType)](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#makingticktype)  |         |                  |
| tradePriceType                | Y        |string       |  [成交价格类型(LpType)](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#lptype)  |         |                             |
| tradePriceAdjustRatio         | Y        |number       |  成交价格调整比例         |         | Range: > 0 & < 100, Precision:4, Scale:2                                                       |  
| tradeRefSpread                | Y        |number       |  成交参照点差             |         | Range: > 0, Precision:24, Scale:12                                                       |  
| tradeVolumeUpperLimit         | Y        |number       |  最大交易量               |         | Range: > 0, Precision:24, Scale:12                                                       |  
| tradeVolumeLowerLimit         | Y        |number       |  最小交易量               |         | Range: > 0, Precision:24, Scale:12                                                       |  
| tradeSendRatio                | Y        |number       |  成交概率                 |         | Range: > 0 & <= 100  Precision:3, Scale:0                                                      |  
| tradeVolumeDeduct             | Y        |boolean      |  成交数量扣除             |         |                                 |
| maxTradeVolumeRatio           | Y        |number       |  最大成交比例             |         | Range: > 0 & <= 100   Precision:3, Scale:0                                                    |  
| minTradeVolumeRatio           | Y        |number       |  最小成交比例             |         | Range: > 0 & <= 100   Precision:3, Scale:0                                                    |  
| l2MinSpread                   | Y        |number       |  L2 最小点差                 |         | Range: > 0, Precision:24, Scale:12                                                       | 
| l2LadderDepth                 | Y        |byte         |  L2 深度                     |         | Range: > 0, Precision:4, Scale:0                                                       |
| l2TickSize                    | Y        |number       |  L2 最小价格单位         |         | Range: > 0, Precision:24, Scale:12                                                      |  
| l2MaxDeviation                | Y        |number       |  L2 最大偏离量            |         | Range: > 0 & < 100, Precision:4, Scale:2                                                      |  
| l2MinThreshold                | Y        |number       |  L2 最小阈值                 |         | Range: > 0, Precision:24, Scale:12                                                      |  
| l2MinVolume                   | Y        |number       |  L2 最小数量                 |         | Range: > 0, Precision:24, Scale:12                                                      |  
| l2MaxVolume                   | Y        |number       |  L2 最大数量                 |         | Range: > 0, Precision:24, Scale:12   


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



### 修改做市配置
PUT /api/v1/making/makingConfigs/update

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

***请求参数***

| NAME                          | REQUIRED | TYPE        | DESCRIBE                  | DEFAULT | VALUES RANGE                                           |
| :---------------------------- | :------- | :---------- | :------------------------ | :------ | :----------------------------------------------------- |
| cp                            | Y        |string       |  交易对手(缩写）         |         |  Must be included in cp                                |
| symbol                        | Y        |string       |  币对名称                      |            |                                                        | 
| frequency                     | Y        |integer      |  发送频率/分                 |         | Range: > 0                                             |
| l1OrderActive                 | Y        |boolean      |  L1 发送订单                |         |                                                        |
| tradeActive                   | Y        |boolean      |  成交                             |         |                                                        |
| l2OrderActive                 | Y        |boolean      |  L2 发送订单             |         |                                                        |
| l1ConfigType                  | Y        |string       |  L1  [配置类型(MakingOrderType)](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#makingordertype) |         |               |
| l1Config                      | Y        |string       |  L1 配置                    |         |  Must be included in source liquidity config                                            |
| l1TickSize                    | Y        |number       |  L1 最小价格单位             |         |  Range: > 0, Precision:24, Scale:12                                                      | 
| l1LadderDepth                 | Y        |byte         |  L1 深度                    |         |  Range: > 0                                                      |
| l1StepHeight                  | Y        |number       |  L1 步长                    |         |  Range: > 0, Precision:24, Scale:12                                                      |  
| l1MinSpread                   | Y        |number       |  L1 最小点差                |         |  Range: > 0, Precision:24, Scale:12                                                      |  
| l1MaxDeviation                | Y        |number       |  L1 最大偏离量              |         |  Range: > 0 & < 100, Precision:4, Scale:2                                                 |  
| tradeType                     | Y        |string       |  [成交类型(MakingTickType)](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#makingticktype)  |         |                  |
| tradePriceType                | Y        |string       |  [成交价格类型(LpType)](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#lptype)  |         |                             |
| tradePriceAdjustRatio         | Y        |number       |  成交价格调整比例         |         | Range: > 0 & < 100, Precision:4, Scale:2                                                       |  
| tradeRefSpread                | Y        |number       |  成交参照点差             |         | Range: > 0, Precision:24, Scale:12                                                       |  
| tradeVolumeUpperLimit         | Y        |number       |  最大交易量               |         | Range: > 0, Precision:24, Scale:12                                                       |  
| tradeVolumeLowerLimit         | Y        |number       |  最小交易量               |         | Range: > 0, Precision:24, Scale:12                                                       |  
| tradeSendRatio                | Y        |number       |  成交概率                 |         | Range: > 0 & <= 100  Precision:3, Scale:0                                                      |  
| tradeVolumeDeduct             | Y        |boolean      |  成交数量扣除             |         |                                 |
| maxTradeVolumeRatio           | Y        |number       |  最大成交比例             |         | Range: > 0 & <= 100   Precision:3, Scale:0                                                    |  
| minTradeVolumeRatio           | Y        |number       |  最小成交比例             |         | Range: > 0 & <= 100   Precision:3, Scale:0                                                    |  
| l2MinSpread                   | Y        |number       |  L2 最小点差                 |         | Range: > 0, Precision:24, Scale:12                                                       | 
| l2LadderDepth                 | Y        |byte         |  L2 深度                     |         | Range: > 0, Precision:4, Scale:0                                                       |
| l2TickSize                    | Y        |number       |  L2 最小价格单位              |         | Range: > 0, Precision:24, Scale:12                                                      |  
| l2MaxDeviation                | Y        |number       |  L2 最大偏差                 |         | Range: > 0 & < 100, Precision:4, Scale:2                                                      |  
| l2MinThreshold                | Y        |number       |  L2 最小阈值                 |         | Range: > 0, Precision:24, Scale:12                                                      |  
| l2MinVolume                   | Y        |number       |  L2 最小数量                 |         | Range: > 0, Precision:24, Scale:12                                                      |  
| l2MaxVolume                   | Y        |number       |  L2 最大数量                 |         | Range: > 0, Precision:24, Scale:12      


***请求参数示例***
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
DELETE /api/v1/making/makingConfigs/delete

请求时必须带Headers:    

X-API-TOKEN:token（通过login获得）

***请求参数***

| NAME                 | REQUIRED | TYPE       | DESCRIBE   | DEFAULT | VALUES RANGE |
| :------------------- | :------- | :--------- | :--------- | :------ | :----------- |
| cp                   | Y        | string     | 对手名称         |                    |                                |
| symbol               | Y        | string     | 币对                |                     |                                |


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


### 获取流动性来源配置
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
| cp                            |string       |  交易对手名称            |
| name                          |string       |  名称                   | 
| symbol                        |string       |  币对                   |
| refCps                        |array        |  关联交易对手            |
| baseCp                        |number       |  基础交易对手            |
| bidVolumeAdjustRatio          |number       |  Bid数量调整比例         |
| askVolumeAdjustRatio          |number       |  Ask数量调整比例         |
| maxVolume                     |number       |  最大数量                |
| maxVolumeRatio                |number       |  最大数量比例            |
| bidPriceAdjustRatio           |number       |  Bid价格调整比例         |
| askPriceAdjustRatio           |number       |  Ask价格调整比例         |
| bidPriceAdjustValue           |number       |  Bid价格调整             |
| askPriceAdjustValue           |number       |  Ask价格调整             |
| priceAdjustType               |string       |  价格调整类型            |

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



### 增加流动性来源配置
POST /v1/making/sourceLiquidityConfigs/create

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME                          | REQUIRED | TYPE        | DESCRIBE                  | DEFAULT | VALUES RANGE                                           |
| :---------------------------- | :------- | :---------- | :------------------------ | :------ | :----------------------------------------------------- |
| name                          | Y        |string       |  名称                   |         |                                                        |
| symbol                        | Y        |string       |  交易币对名称            |         |                                                        |
| baseCp                        |          |string       |  基础LP                 |         |                                                        |
| refCps                        | Y        |array        |  流动性来源              |         |                                                        |
| bidVolumeAdjustRatio          | Y        |number       |  Bid数量调整比例|        | Range: > 0 & <= 100   Precision:4, Scale:2                       |
| askVolumeAdjustRatio          | Y        |number       |  Ask数量调整比例|        | Range: > 0 & <= 100   Precision:4, Scale:2                       |
| maxVolume                     | Y        |number       |  最大数量                |         | Range: > 0   Precision:24, Scale:12                    |
| maxVolumeRatio                | Y        |number       |  最大数量比例            |        | Range: > 0 & < 100   Precision:2, Scale:0               |
| bidPriceAdjustRatio           | N        |number       |  Bid价格调整比例 |       | Range: > 0 & <= 100   Precision:4, Scale:2                       |
| askPriceAdjustRatio           | N        |number       |  Ask价格调整比例 |       | Range: > 0 & <= 100   Precision:4, Scale:2                       |
| bidPriceAdjustValue           | N        |number       |  Bid价格调整值 |        |  Range: >= 0   Precision:24, Scale:12                             |
| askPriceAdjustValue           | N        |number       |  Ask价格调整值 |        |  Range: >= 0   Precision:24, Scale:12                             |
| priceAdjustType               | Y        |string       |  [价格调整类型(PriceadjustType)](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#priceadjusttype)|         |                                                        |


***请求参数示例***

```
{
  "cp": "ampex",
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


### 修改流动性来源配置
PUT /v1/making/sourceLiquidityConfigs/update

request with Headers:    

X-API-TOKEN:token（acquired from login）

***request params***

| NAME                          | REQUIRED | TYPE        | DESCRIBE                  | DEFAULT | VALUES RANGE                                           |
| :---------------------------- | :------- | :---------- | :------------------------ | :------ | :----------------------------------------------------- |
| name                          | Y        |string       |  交易对手名称            |                  |                                                        |
| symbol                        | Y        |string       |  交易币对名称            |                  |                                                        |
| baseCp                        |          |string       |  基础LP           |        |                                                        |
| refCps                        | Y        |array        |  流动性来源                 |                  |                                                        |
| bidVolumeAdjustRatio          | Y        |number       |  Bid数量调整比例|        | Range: > 0 & <= 100   Precision:4, Scale:2                       |
| askVolumeAdjustRatio          | Y        |number       |  Ask数量调整比例|        | Range: > 0 & <= 100   Precision:4, Scale:2                       |
| maxVolume                     | Y        |number       |  最大数量                |         | Range: > 0   Precision:24, Scale:12                    |
| maxVolumeRatio                | Y        |number       |  最大数量比例            |        | Range: > 0 & < 100   Precision:2, Scale:0               |
| bidPriceAdjustRatio           | N        |number       |  Bid价格调整比例 |       | Range: > 0 & <= 100   Precision:4, Scale:2                       |
| askPriceAdjustRatio           | N        |number       |  Ask价格调整比例 |       | Range: > 0 & <= 100   Precision:4, Scale:2                       |
| bidPriceAdjustValue           | N        |number       |  Bid价格调整值 |        |  Range: >= 0   Precision:24, Scale:12                             |
| askPriceAdjustValue           | N        |number       |  Ask价格调整值 |        |  Range: >= 0   Precision:24, Scale:12                             |
| priceAdjustType               | Y        |string       |  [价格调整类型(PriceAdjustType)](https://github.com/lw-bthub/api-demo/blob/master/api-en/enum.md#priceadjusttype)|         |                                                        |


***example of request***
```
{
  "cp": "ampex",
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



### 删除流动性来源配置
DELETE /v1/making/sourceLiquidityConfigs/delete

request with Headers:

X-API-TOKEN:token（acquired from login）

***request params***

| NAME                 | REQUIRED | TYPE       | DESCRIBE          | DEFAULT | VALUES RANGE |
| :------------------- | :------- | :--------- | :---------------- | :------ | :----------- |
| name                 | Y        |string      |  名称                             |                     |                                  |
| symbol               | Y        |string      |  币对                             |                     |                                  | 


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