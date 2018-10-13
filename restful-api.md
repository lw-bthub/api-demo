# RestfulApi 接口信息(2018-10-12)

REST，即Representational State Transfer的缩写，是目前最流行的一种互联网软件架构。它结构清晰、符合标准、易于理解、扩展方便，正得到越来越多网站的采用。


- 在线API 接口测试工具

    http://trade.bthub.com/:444/swagger-ui.html

## 接口列表

| 请求方法                                    | 类型 | 描述                   |
| :------------------------------------------ | :--- | :--------------------- |
| [/api/v1/operator/login](#Mark1)            | POST | 登陆                   |
| [/api/v1/market/cps](#Mark2)                | GET  | 获取CP列表信息         |
| [/api/v1/market/symbols](#Mark3)            | GET  | 获取SYMBOL列表信息     |
| [/api/v1/trades/place](#Mark4)              | POST | 投递交易               |
| [/api/v1/trades/cpExecutionDetail](#Mark5)  | GET  | 获取CP成交详细         |
| [/api/v1/trades/orderDetail](#Mark6)        | GET  | 获取订单详细           |
| [/api/v1/trades/orderHistory](#Mark7)       | GET  | 获取订单历史列表信息   |
| [/api/v1/trades/cpOrderHistory](#Mark8)     | GET  | 获取CP订单历史列表信息 |
| [/api/v1/trades/cpExecutionHistory](#Mark9) | GET  | 获取CP成交历史列表信息 |

<a href="#jump" target="_self">说明文字</a>

## Restful API

<div id="Mark1">### 登陆接口</div>
POST /api/v1/operator/login

***请求参数***

| NAME     | REQUIRED | TYPE   | DESCRIBE | DEFAULT | VALUES RANGE |
| :------- | :------- | :----- | :------- | :------ | :----------- |
| loginId  | Y        | String |          | 用户名  |              |
| password | Y        | String |          | 密码    |              |

***返回参数***

| NAME  | TYPE   | DESCRIBE |
| :---- | :----- | :------- |
| token | String | token    |

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

<span id="Mark2">### 获取CP列表</span>
GET /api/v1/market/cps

Headers:
X-API-TOKEN:（token，通过登录接口获得.）

***返回参数***

| NAME           | TYPE    | DESCRIBE |
| :------------- | :------ | :------- |
| id             | short   | ID       |
| name           | String  | 名称缩写 |
| tradingEnabled | boolean | 交易限制 |

***返回参数示例***

```
{
  "data": [
    {
      "id": 257,
      "name": "NT_XX1",
      "tradingEnabled": true
    },
    {
      "id": 258,
      "name": "NT_XX2",
      "tradingEnabled": true
    }
  ],
  "result": "SUCCESS",
  "type": "API"
}
```

<span id="Mark3">### 获取symbol列表</span>
GET  /api/v1/market/symbols

Headers:
X-API-TOKEN:（token，通过登录接口获得.）

***返回参数***

| NAME               | TYPE       | DESCRIBE     |
| :----------------- | :--------- | :----------- |
| id                 | int        | ID           |
| name               | String     | 名称         |
| tradingMaxVolume   | BigDecimal | 交易最大数量 |
| tradingMinVolume   | BigDecimal | 交易最小数量 |
| tradingPriceScale  | byte       | 价格精度     |
| tradingVolumeScale | byte       | 交易量精度   |

***返回参数示例***

```
{
  "data": [
    {
      "id": 65537,
      "name": "BTCUSDT",
      "tradingMaxVolume": "100",
      "tradingMinVolume": "0.000001",
      "tradingPriceScale": 2,
      "tradingVolumeScale": 5
    },
    {
      "id": 65539,
      "name": "BCHUSDT",
      "tradingMaxVolume": "100",
      "tradingMinVolume": "0.00001",
      "tradingPriceScale": 2,
      "tradingVolumeScale": 8
    }
  ],
  "result": "SUCCESS",
  "type": "API"
}
```

<span id="Mark4">### 交易</span>
POST /api/v1/trades/place

Headers:
X-API-TOKEN:（token，通过登录接口获得.）

***请求参数***

RequestBody:（order）

| NAME        | REQUIRED | TYPE       | DESCRIBE              | DEFAULT | VALUES RANGE |
| :---------- | :------- | :--------- | :-------------------- | :------ | :----------- |
| cpId        |          | Short      | CP ID                 |         |              |
| symbolId    | Y        | Integer    | 货币对ID              |         |              |
| orderPrice  | Y        | BigDecimal | 挂单价格              |         |              |
| orderVolume | Y        | BigDecimal | 挂单数量              |         |              |
| side        | Y        | String     | 买卖方向(Side)        |         |              |
| orderType   | Y        | String     | 挂单类型(OrderType)   |         |              |
| timeInForce | Y        | String     | 过期类型(TimeInForce) |         |              |

***请求参数示例***

```
{
  "cpId": 1231,
  "symbolId": 312,
  "orderPrice": 1.2,
  "orderVolume": 0.02,
  "side": "BUY",
  "orderType": "LIMIT",
  "timeInForce": "IOC"
}
```

 ***返回参数***

| NAME          | TYPE       | DESCRIBE              |
| :------------ | :--------- | :-------------------- |
| id            | int        | ID                    |
| cpId          | short      | CP ID                 |
| symbolId      | int        | 货币对ID              |
| executeAmount | BigDecimal | 成交金额              |
| executeVolume | BigDecimal | 成交数量              |
| orderVolume   | BigDecimal | 挂单数量              |
| pendingVolume | BigDecimal | 执行数量              |
| side          | String     | 买卖方向(Side)        |
| orderType     | String     | 挂单类型(OrderType)   |
| sourceId      | long       | 父订单                |
| status        | String     | 状态(OrderStatus)     |
| timeInForce   | String     | 过期类型(TimeInForce) |
| orderTime     | long       | 挂单时间              |
| executeTime   | long       | 时间                  |

***返回参数示例***

```
{
  "data": {
    "orders": [{
      "cpId": 0,
      "executeAmount": "0",
      "executeTime": "0",
      "executeVolume": "0",
      "id": "725255741425850921",
      "orderTime": "1538031221678",
      "orderType": 5,
      "orderVolume": "0.01",
      "pendingVolume": "0.00000000",
      "side": -1,
      "sourceId": "0",
      "status": 1,
      "symbolId": 65537,
      "timeInForce": 1
    }, {
      "commission": "0.0001",
      "cpId": 259,
      "executeAmount": "0",
      "executeTime": "0",
      "executeVolume": "0",
      "id": "725255741425851433",
      "orderComment": "725255735840965653.0",
      "orderTime": "1538031221678",
      "orderType": 5,
      "orderVolume": "0.01000000",
      "pendingVolume": "0.00000000",
      "side": -1,
      "sourceId": "725255741425850921",
      "status": 1,
      "symbolId": 65537,
      "timeInForce": 1
    }],
    "result": "SUCCESS"
  },
  "result": "SUCCESS",
  "type": "API"
}
```

<span id="Mark5">### 获取CP成交详细</span>
GET  /api/v1/trades/cpExecutionDetail

Headers:
X-API-TOKEN:（token，通过登录接口获得.）

***请求参数***

| NAME    | REQUIRED | TYPE | DESCRIBE | DEFAULT | VALUES RANGE |
| :------ | :------- | :--- | :------- | :------ | :----------- |
| orderId | Y        | Long | 订单ID   | -       |              |

***返回参数***

| NAME           | TYPE       | DESCRIBE       |
| :------------- | :--------- | :------------- |
| id             | long       | ID             |
| cpId           | short      | CP ID          |
| symbolId       | int        | 货币对ID       |
| accountId      | long       | 账户ID         |
| orderId        | long       | 订单ID         |
| side           | String     | 买卖方向(Side) |
| executeAmount  | BigDecimal | 成交金额       |
| executePrice   | BigDecimal | 成交价格       |
| executeVolume  | BigDecimal | 成交数量       |
| executeTime    | long       | 成交时间       |
| commission     | double     | 手续费         |
| executeComment | String     | 成交备注       |

***返回参数示例***

```
{
  "data": {
    "executions": [
      {
        "accountId": "0",
        "commission": "0.628542600000",
        "cpId": 257,
        "executeAmount": "628.542600000000",
        "executeComment": "CommissionAsset: USDT",
        "executePrice": "6413.700000000000",
        "executeTime": "1537450673000",
        "executeVolume": "0.098000000000",
        "id": "720385747089113129",
        "orderId": "720385741233864233",
        "side": -1,
        "symbolId": 65537
      }
    ]
  },
  "result": "SUCCESS",
  "type": "API"
}
```

<span id="Mark6">### 获取订单详细</span>
GET /api/v1/trades/orderDetail

Headers:
X-API-TOKEN:（token，通过登录接口获得.）

***请求参数***

| NAME     | REQUIRED | TYPE | DESCRIBE | DEFAULT | VALUES RANGE |
| :------- | :------- | :--- | :------- | :------ | :----------- |
| sourceId | Y        | Long | 父订单ID | -       |              |

***返回参数***

| NAME           | TYPE       | DESCRIBE              |
| :------------- | :--------- | :-------------------- |
| pageCount      | int        | 总页数                |
| pageNo         | int        | 页码                  |
| pageSize       | int        | 每页数量              |
| total          | int        | 总条数                |
| id             | long       | ID                    |
| cpId           | short      | CP ID                 |
| symbolId       | int        | 货币对ID              |
| accountId      | short      | 账户ID                |
| sourceId       | long       | 父订单ID              |
| orderId        | String     | 订单ID                |
| side           | String     | 买卖方向(Side)        |
| status         | String     | 状态(OrderStatus)     |
| orderResult    | String     | 结果(OrderResult)     |
| orderType      | String     | 挂单类型(OrderType)   |
| orderPrice     | BigDecimal | 挂单价格              |
| executePrice   | String     | 成交价格              |
| executeAmount  | BigDecimal | 成交金额              |
| executeVolume  | BigDecimal | 成交数量              |
| orderVolume    | BigDecimal | 挂单数量              |
| pendingVolume  | BigDecimal | 执行数量              |
| accountId      | String     | 账户ID                |
| executeComment | String     | 成交备注              |
| executeTime    | long       | 成交时间              |
| orderTime      | long       | 挂单时间              |
| timeInForce    | String     | 过期类型(TimeInForce) |
| commission     | BigDecimal | 手续费                |
| orderComment   | String     | 备注                  |

***返回参数示例***

```
{
  "data": {
    "orders": [
      {
        "accountId": 0,
        "commission": "0.999900000000",
        "cpId": 257,
        "executions": [
          {
            "accountId": "0",
            "symbolId": 65537,
            "commission": "0.127800000000",
            "cpId": 257,
            "executeAmount": "127.800000000000",
            "executeComment": "CommissionAsset: USDT",
            "executePrice": "6390.000000000000",
            "executeTime": "1537409484740",
            "executeVolume": "0.020000000000",
            "id": "720040235022424617",
            "orderId": "720040228848408617",
            "side": -1
          }
        ],
        "executeAmount": "127.800000000000",
        "executeTime": "1537409484740",
        "executeVolume": "0.020000000000",
        "id": "720040228848408617",
        "orderComment": "720040227201319445.0",
        "orderResult": 3,
        "orderTime": "1537409484129",
        "orderType": 5,
        "orderVolume": "0.020000000000",
        "pendingVolume": "0.000000000000",
        "side": -1,
        "sourceId": "720040228798076457",
        "status": 4,
        "symbolId": 1,
        "timeInForce": 1
      }
    ]
  },
  "result": "SUCCESS",
  "type": "API"
}
```

 <span id="Mark7">### 获取订单历史 列表</span>
 GET  /api/v1/trades/orderHistory

 Headers:
 X-API-TOKEN:（token，通过登录接口获得.）

 ***请求参数***

| NAME     | REQUIRED | TYPE    | DESCRIBE          | DEFAULT | VALUES RANGE |
| :------- | :------- | :------ | :---------------- | :------ | :----------- |
| cpId     |          | Short   | CP ID             | -       |              |
| symbolId |          | Integer | 货币对ID          | -       |              |
| status   |          | String  | 状态(OrderStatus) | -       |              |
| from     | Y        | Long    | 开始时间          | -       |              |
| to       | Y        | Long    | 结束时间          | -       |              |
| pageNo   |          | Integer | 页码              | -       |              |

 ***返回参数***

| NAME          | TYPE       | DESCRIBE              |
| :------------ | :--------- | :-------------------- |
| pageCount     | int        | 总页数                |
| pageNo        | int        | 页码                  |
| pageSize      | int        | 每页数量              |
| total         | int        | 总条数                |
| id            | long       | ID                    |
| cpId          | short      | CP  ID                |
| symbolId      | int        | 货币对ID              |
| accountId     | short      | 账户ID                |
| sourceId      | long       | 父订单ID              |
| side          | String     | 买卖方向(Side)        |
| status        | String     | 状态(OrderStatus)     |
| orderResult   | String     | 结果(OrderResult)     |
| orderType     | String     | 挂单类型(OrderType)   |
| orderPrice    | BigDecimal | 挂单价格              |
| executeAmount | double     | 成交金额              |
| orderVolume   | BigDecimal | 挂单数量              |
| pendingVolume | BigDecimal | 执行数量              |
| executeVolume | double     | 成交数量              |
| executeTime   | long       | 成交时间              |
| orderTime     | long       | 挂单时间              |
| timeInForce   | String     | 过期类型(TimeInForce) |
| commission    | BigDecimal | 手续费                |
| rejectReason  | String     | 拒绝原因              |
| orderComment  | String     | 备注                  |

 ***返回参数示例***

```
 {
   "data": {
     "pageCount": 1,
     "pageNo": 1,
     "pageSize": 100,
     "records": [
       {
         "accountId": 0,
         "commission": "1.000100000000",
         "cpId": 257,
         "executeAmount": "0",
         "executeTime": "0",
         "executeVolume": "0",
         "id": "723982654013188137",
         "orderComment": "723982649334445077.0",
         "orderPrice": "6432.63",
         "orderTime": "1537879457832",
         "orderType": 3,
         "orderVolume": "0.01",
         "pendingVolume": "0",
         "side": 1,
         "sourceId": "0",
         "status": 1,
         "symbolId": 65537,
         "timeInForce": 1
       }
     ],
     "total": 6
   },
   "result": "SUCCESS",
   "type": "API"
 }
```

<span id="Mark8">### 获取CP订单历史 列表</span>
GET  /api/v1/trades/cpOrderHistory

Headers:
X-API-TOKEN:（token，通过登录接口获得.）

***请求参数***

| NAME     | REQUIRED | TYPE    | DESCRIBE          | DEFAULT | VALUES RANGE |
| :------- | :------- | :------ | :---------------- | :------ | :----------- |
| cpId     |          | Short   | CP ID             | -       |              |
| symbolId |          | Integer | 货币对ID          | -       |              |
| status   |          | String  | 状态(OrderStatus) | -       |              |
| from     | Y        | Long    | 开始时间          | -       |              |
| to       | Y        | Long    | 结束时间          | -       |              |
| pageNo   |          | Integer | 页码              | -       |              |

***返回参数***

| NAME          | TYPE       | DESCRIBE              |
| :------------ | :--------- | :-------------------- |
| pageCount     | int        | 总页数                |
| pageNo        | int        | 页码                  |
| pageSize      | int        | 每页数量              |
| total         | int        | 总条数                |
| id            | long       | ID                    |
| cpId          | short      | CP  ID                |
| symbolId      | int        | 货币对ID              |
| accountId     | short      | 账户ID                |
| sourceId      | long       | 父订单ID              |
| side          | String     | 买卖方向(Side)        |
| status        | String     | 状态(OrderStatus)     |
| orderType     | String     | 挂单类型(OrderType)   |
| orderResult   | String     | 结果(OrderResult)     |
| executeAmount | double     | 成交金额              |
| orderPrice    | BigDecimal | 挂单价格              |
| executeVolume | double     | 成交数量              |
| orderVolume   | BigDecimal | 挂单数量              |
| pendingVolume | BigDecimal | 执行数量              |
| sourceId      | long       | 父订单                |
| orderTime     | long       | 挂单时间              |
| executeTime   | long       | 成交时间              |
| timeInForce   | String     | 过期类型(TimeInForce) |
| commission    | BigDecimal | 手续费                |
| rejectReason  | String     | 拒绝原因              |
| orderComment  | String     | 备注                  |

***返回参数示例***

```
{
	"data": {
		"pageCount": 3,
		"pageNo": 1,
		"pageSize": 100,
		"records": [{
		        "id": "724051456730076713",
				"accountId": 0,
				"commission": "0.999900000000",
				"cpId": 257,
				"executeAmount": "64.2598",
				"executeTime": "1537887660365",
				"executeVolume": "0.01",
				"orderComment": "724051448010349077.0",
				"orderResult": 3,
				"orderTime": "1537887659755",
				"orderType": 5,
				"orderVolume": "0.01",
				"pendingVolume": "0",
				"side": -1,
				"sourceId": "0",
				"status": 4,
				"symbolId": 65537,
				"timeInForce": 1
			}
		],
		"total": 273
	},
	"result": "SUCCESS",
	"type": "API"
}
```

<span id="Mark9">### 获取CP成交历史 列表</span>
GET  /api/v1/trades/cpExecutionHistory

Headers:
X-API-TOKEN:（token，通过登录接口获得.）

***请求参数***

| NAME     | REQUIRED | TYPE    | DESCRIBE | DEFAULT | VALUES RANGE |
| :------- | :------- | :------ | :------- | :------ | :----------- |
| cpId     |          | Short   | CP ID    | -       |              |
| symbolId |          | Integer | 货币对ID | -       |              |
| from     | Y        | Long    | 开始时间 | -       |              |
| to       | Y        | Long    | 结束时间 | -       |              |
| pageNo   |          | Integer | 页码     | -       |              |

***返回参数***

| NAME           | TYPE       | DESCRIBE       |
| :------------- | :--------- | :------------- |
| pageCount      | int        | 总页数         |
| pageNo         | int        | 页码           |
| pageSize       | int        | 每页数量       |
| total          | int        | 总条数         |
| id             | long       | ID             |
| cpId           | short      | CP ID          |
| symbolId       | int        | 货币对ID       |
| accountId      | long       | 账户ID         |
| orderId        | long       | 订单ID         |
| side           | String     | 买卖方向(Side) |
| executePrice   | BigDecimal | 价格           |
| executeVolume  | BigDecimal | 成交数量       |
| executeAmount  | BigDecimal | 成交金额       |
| executeTime    | long       | 时间           |
| commission     | double     | 手续费         |
| executeComment | String     | 备注           |

***返回参数示例***

```
{
	"data": {
		"pageCount": 2,
		"pageNo": 1,
		"pageSize": 100,
		"records": [{
				"accountId": "0",
				"commission": "0.0642598",
				"cpId": 257,
				"executeAmount": "64.2598",
				"executePrice": "6425.98",
				"executeTime": "1537887660365",
				"executeVolume": "0.01",
				"id": "724051462744709161",
				"orderId": "724051456730076713",
				"side": -1,
				"symbolId": 65537
				"executeComment": "CommissionAsset: USDT",
			}
		],
		"total": 1
	},
	"result": "SUCCESS",
	"type": "API"
}
```
