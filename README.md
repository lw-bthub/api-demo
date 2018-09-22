api说明共分以下几个部分

# 枚举值表
##### DealingOrderStatus:
    [PENDING:1,EXCUTING:3,EXECUTED:4,EXPIRED:5,REJECTED:7,CANCELLED:9,UKNOWN:99]

##### Side:
    [BUY:1,SELL:-1]

##### DealingOrderResult:
    [NONE:1,FILLED:3,PARTIAL:5]

##### TimeInForce:
    [IOC:1,GTC:3]

##### DealingOrderType:
    [LIMIT:3,MARKET:5]

##### PricingRestriction:
    [NORMAL:1,OFF:9]

##### LoginRestriction:
    [NORMAL:1,OFF:9]

##### BrokerStatus:
    [ACTIVE:1,DISABLED:9]

##### TradingRestriction:
    [NORMAL:1,SHORT_OFF:2,LONG_OFF:3,OFF:9]


### 登陆接口
POST /api/v1/operator/login  

***请求参数***

| NAME     | REQUIRED | TYPE   | DESCRIBE | DEFAULT | VALUES RANGE |  
|:---------|:---------|:-------|:---------|:--------|:-------------|  
| loginId  | Y        | String |          | 用户名   |             |  
| password | Y        | String |          | 密码     |             |  


***返回参数***

| NAME     | TYPE   | DESCRIBE |  
|:---------|:-------|:---------|  
| token    | String |   token  |  

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
### 获取CP列表
GET /api/v1/market/cps

Headers:
X-IDCM-APIKEY:（token，通过登录接口获得.）

***返回参数***

| NAME          | TYPE   | DESCRIBE |  
|:--------------|:-------|:---------|  
| id            | short | ID       |  
| name          | String | 名称缩写 |  
| tradingEnabled| boolean | 交易限制 |  

***返回参数示例***
```
{
  "data": [
    {
      "name": "NT_XX1",
      "id": 257,
      "tradingEnabled": true
    },
    {
      "name": "NT_XX2",
      "id": 258,
      "tradingEnabled": true
    }
  ],
  "result": "SUCCESS",
  "type": "API"
}
```

### 获取symbol列表
GET  /api/v1/market/symbols

Headers:
X-IDCM-APIKEY:（token，通过登录接口获得.）

***返回参数***

| NAME               | TYPE   | DESCRIBE     | 
|:-------------------|:-------|:-------------|
| id                 | int    | ID           | 
| name               | String | 名称         | 
| tradingMaxVolume   | BigDecimal | 交易最大数量  |
| tradingMinVolume   | BigDecimal | 交易最小数量  |
| tradingPriceScale  | byte | 价格精度      |
| tradingVolumeScale | byte | 交易量精度      |

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

### 交易
POST /api/v1/trades/place

Headers:
X-IDCM-APIKEY:（token，通过登录接口获得.）

***请求参数***

| NAME     | REQUIRED | TYPE   | DESCRIBE | DEFAULT | VALUES RANGE |  
|:---------|:---------|:-------|:---------|:--------|:-------------|  
| cpId     | Y        | Short |        CP ID   |             |  
| orderPrice | Y      | BigDecimal|    挂单价格     |             |  
| orderType | Y       | String |       挂单类型     |             | 
| orderVolume | Y     | BigDecimal |   挂单数量     |             | 
| side | Y            | String |       买卖方向     |             | 
| symbolId | Y        | Integer |      货币对ID     |             | 
| timeInForce | Y     | String |       过期类型     |             | 
 
***返回参数示例***
```
{
  "data": {
    "data": {
      "orderPrice": "INVALID",
      "orderVolume": "UNDERFLOW"
    },
    "type": "VALIDATION"
  },
  "result": "INVALID_DATA",
  "type": "API"
}
```

### 获取CP成交详细
GET  /api/v1/trades/cpExecutionDetail

Headers:
X-IDCM-APIKEY:（token，通过登录接口获得.）

***请求参数***

| NAME               | REQUIRED | TYPE   | DESCRIBE     | DEFAULT | VALUES RANGE |
|:-------------------|:---------|:-------|:-------------|:--------|:-------------|
| orderId            | Y        | Long   | 订单ID        | -       |              |

***返回参数***

| NAME           | TYPE   | DESCRIBE |
|:-------------- |:-------|:---------|
| accountId      | long   | 账户ID    | 
| commission     | double | 手续费  | 
| cpId           | short  | CP ID    | 
| executeAmount  | BigDecimal | 成交金额  | 
| executeComment | String | 成交备注    | 
| executePrice   | BigDecimal | 成交价格 |
| executeTime    | long   | 约定时间    |
| executeVolume  | BigDecimal | 成交数量    |
| id             | long   | ID        | 
| orderId        | long   | 订单ID    | 
| side           | String | 买卖方向  |
| symbolId       | int    | 货币对ID    |

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

### 获取订单详细
GET /api/v1/trades/orderDetail

Headers:
X-IDCM-APIKEY:（token，通过登录接口获得.）

***请求参数***

| NAME               | REQUIRED | TYPE   | DESCRIBE     | DEFAULT | VALUES RANGE |
|:-------------------|:---------|:-------|:-------------|:--------|:-------------|
| sourceId           | Y        | Long   | 父订单ID     | -       |              |

***返回参数***

| NAME           | TYPE   | DESCRIBE | 
|:-------------- |:-------|:---------| 
| pageCount     | int    | 总页数    |
| pageNo        | int    | 页码      |
| pageSize      | int    | 每页数量  |
| total         | int    | 总条数    | 
| accountId      | short | 账户ID  |  
| commission     | BigDecimal | 手续费  |  
| cpId           | short | CP ID  |   
| executeAmount  | BigDecimal | 成交金额  |  
| executeTime    | long | 成交时间  | 
| executeVolume  | BigDecimal | 成交数量    |
| id             | long |  ID  |     
| orderComment   | String | 备注  |   
| orderResult    | String | 结果  |   
| orderTime      | long | 挂单时间|    
| orderType      | String | 挂单类型|    
| orderPrice     | BigDecimal | 挂单价格|   
| orderVolume    | BigDecimal | 挂单数量|    
| pendingVolume  | BigDecimal | 执行数量|    
| side           | String | 买卖方向|  
| sourceId       | long | 父订单ID  |
| status         | String | 状态  |    
| symbolId       | int | 货币对ID  |
| timeInForce    | String | 过期类型 |
| accountId      | String | 账户ID  | 
| executeComment | String | 成交备注  |
| executePrice   | String | 成交价格 |
| orderId        | String | 订单ID  |

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
 

### 获取CP订单历史 列表
GET  /api/v1/trades/cpOrderHistory

Headers:
X-IDCM-APIKEY:（token，通过登录接口获得.）

***请求参数***

| NAME               | REQUIRED | TYPE   | DESCRIBE     | DEFAULT | VALUES RANGE |
|:-------------------|:---------|:-------|:-------------|:--------|:-------------|
| cpId               |         | Short   | CP ID         | -       |              |
| symbolId           |         | Integer   | 货币对ID     | -       |              |
| status             |         | String   | 状态     | -       |              |
| from               | Y       | Long   | 开始时间       | -       |              |
| to                 | Y       | Long   | 结束时间       | -       |              |
| pageNo             |         | Integer    | 页码          | -       |               |

***返回参数***

| NAME          | TYPE   | DESCRIBE |
|:--------------|:-------|:---------|
| pageCount     | int    | 总页数    |
| pageNo        | int    | 页码      |
| pageSize      | int    | 每页数量  |
| total         | int    | 总条数    | 
| accountId     | short | 账户ID    | 
| cpId          | short | CP  ID      |
| executeAmount | double | 成交金额   | 
| executeTime   | long | 成交时间    |
| executeVolume | double | 成交数量    |
| id            | long | ID        | 
| orderComment  | String | 备注       | 
| orderPrice    | BigDecimal | 挂单价格    |
| orderResult    | String | 结果    |
| orderTime     | long | 挂单时间    |
| orderType     | String | 挂单类型    |
| orderVolume   | BigDecimal | 挂单数量    |
| pendingVolume | BigDecimal | 执行数量    |
| rejectReason  | String | 拒绝原因   | 
| side          | String | 买卖方向    |
| sourceId      | long | 父订单       | 
| status        | String | 状态       | 
| symbolId      | int | 货币对ID  |  
| timeInForce   | String | 过期类型   |
| commission    | BigDecimal | 手续费     |

***返回参数示例***
```
{
  "data": {
    "dealingOrders": [
      {
        "accountId": 0,
        "commission": "0.999900000000",
        "cpId": 257,
        "executions": [
          {
            "accountId": "0",
            "bkSymbolId": 65537,
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


### 获取CP成交历史 列表
GET  /v1/trades/cpExecutionHistory

Headers:
X-IDCM-APIKEY:（token，通过登录接口获得.）

***请求参数***

| NAME               | REQUIRED | TYPE   | DESCRIBE     | DEFAULT | VALUES RANGE |
|:-------------------|:---------|:-------|:-------------|:--------|:-------------|
| cpId               |          | Short   | CP ID        | -       |              |
| symbolId           |          | Integer   | 货币对ID    | -       |              |
| from               | Y        | Long   | 开始时间      | -       |              |
| to                 | Y        | Long   | 结束时间      | -       |              |
| pageNo             |          | Integer   | 页码          | -       |              |

***返回参数***

| NAME          | TYPE   | DESCRIBE | 
|:--------------|:-------|:---------|
| pageCount     | int    | 总页数    |
| pageNo        | int    | 页码      |
| pageSize      | int    | 每页数量  |
| total         | int    | 总条数    |  
| accountId     | long   | 账户ID    |
| commission    | double | 手续费    |
| cpId          | short  | CP ID     |
| executeAmount | BigDecimal | 成交金额  |
| executeComment| String | 备注      |
| executePrice  | BigDecimal | 价格      |
| executeTime   | long   | 时间      |
| executeVolume | BigDecimal | 成交数量    |
| id            | long   | ID       | 
| orderId       | long   | 订单ID    |
| side          | String | 买卖方向  | 
| symbolId      | int    | 货币对ID  |

***返回参数示例***
```
{
  "data": {
    "pageCount": 2,
    "pageNo": 1,
    "pageSize": 100,
    "records": [
      {
        "accountId": "0",
        "commission": "0.1278",
        "cpId": 257,
        "executeAmount": "127.8",
        "executeComment": "CommissionAsset: USDT",
        "executePrice": "6390",
        "executeTime": "1537409484740",
        "executeVolume": "0.02",
        "id": "720040235022424617",
        "orderId": "720040228848408617",
        "side": -1,
        "symbolId": 65537
      }
    ],
    "total": 123
  },
  "result": "SUCCESS",
  "type": "API"
}
```
