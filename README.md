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

PARAMETER DATA

| NAME     | REQUIRED | TYPE   | DESCRIBE | DEFAULT | VALUES RANGE |  
|:---------|:---------|:-------|:---------|:--------|:-------------|  
| loginId  | Y        | string |          | 用户名   |              |  
| password | Y        | string |          | 密码     |              |  


RESPONSE DATA

| NAME     | TYPE   | DESCRIBE |  
|:---------|:-------|:---------|  
| token    | string |   token  |  

result sample
```
{
  "data": {
    "token": "eVc4NkVRbkRYb09kOFBt"
  },
  "result": "SUCCESS",
  "type": "API"
}
```
### 获取CP列表
GET /api/v1/market/cps

Headers:
X-IDCM-APIKEY:（token，通过登录接口获得.）

NO PARAMETER DATA

RESPONSE DATA

| NAME          | TYPE   | DESCRIBE |  
|:--------------|:-------|:---------|  
| id            | short | ID       |  
| abbreviation  | String | 名称缩写  |  
| tradingEnabled| boolean | 交易限制  |  
result sample
```
{
  "data": [
    {
      "abbreviation": "NT_XX1",
      "id": 257,
      "tradingEnabled": true
    },
    {
      "abbreviation": "NT_XX2",
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

NO PARAMETER DATA

RESPONSE DATA

| NAME               | TYPE   | DESCRIBE     | 
|:-------------------|:-------|:-------------|
| id                 | int    | ID           | 
| name               | String | 名称         | 
| tradingMaxVolume   | double | 交易最大数量  |
| tradingMinVolume   | double | 交易最小数量  |
| tradingPriceScale  | byte | 交易精度      |
| tradingVolumeScale | byte | 交易精度      |

result sample
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

PARAMETER DATA

| NAME               | REQUIRED | TYPE   | DESCRIBE     | DEFAULT | VALUES RANGE |
|:-------------------|:---------|:-------|:-------------|:--------|:-------------|
| cpId            | Y        | short   | CP ID        | -       |              |
| orderPrice            | Y        | double   | 价格        | -       |              |
| orderType            | Y        | string   | 类型        | -       |              |
| orderVolume            | Y        | double   | 数量        | -       |              |
| side            | Y        | string   |  买卖方向        | -       |              |
| symbolId            | Y        | int   | Symbol ID        | -       |              |
| timeInForce            | Y        | String   | 过期类型        | -       |              |
 
result sample
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

### 获取 CP Execution 详细
GET  /api/v1/trades/cpExecutionDetail

Headers:
X-IDCM-APIKEY:（token，通过登录接口获得.）

PARAMETER DATA

| NAME               | REQUIRED | TYPE   | DESCRIBE     | DEFAULT | VALUES RANGE |
|:-------------------|:---------|:-------|:-------------|:--------|:-------------|
| orderId            | Y        | long   | 订单ID        | -       |              |

RESPONSE DATA

| NAME          | REQUIRED | TYPE   | DESCRIBE | DEFAULT | VALUES RANGE |
|:--------------|:---------|:-------|:---------|:--------|:-------------|
| accountId     | Y        | long | 账户ID    | -       |              |
| commission        | Y        | double | 手续费      |        |              |
| cpId      | Y        | short | CP ID  |        |              |
| executeAmount      | Y        | double | 约定量  |        |              |
| executeComment     | Y        | string | 备注    | -       |              |
| executePrice     | Y        | double | 约定价格    | -       |              |
| executeTime     | Y        | long | 约定时间    | -       |              |
| executeVolume     | Y        | double | 月定量    | -       |              |
| id     | Y        | long | ID    | -       |              |
| orderId     | Y        | long | 订单ID    | -       |              |
| side     | Y        | string | 买卖方向    | -       |              |
| symbolId     | Y        | int | 货币对ID    | -       |              |

result sample
```
{
  "data": {
    "executions": [
      {
        "accountId": "0",
        "commission": "0.127800000000",
        "cpId": 257,
        "executeAmount": "127.800000000000",
        "executeComment": "CommissionAsset: USDT",
        "executePrice": "6390.000000000000",
        "executeTime": "1537409484740",
        "executeVolume": "0.020000000000",
        "id": "720040235022424617",
        "orderId": "720040228848408617",
        "side": -1,
        "symbolId": 65537
      }
    ]
  },
  "result": "SUCCESS",
  "type": "API"
}
```

### 获取 Order 详细
GET /api/v1/trades/orderDetail

Headers:
X-IDCM-APIKEY:（token，通过登录接口获得.）

PARAMETER DATA

| NAME               | REQUIRED | TYPE   | DESCRIBE     | DEFAULT | VALUES RANGE |
|:-------------------|:---------|:-------|:-------------|:--------|:-------------|
| sourceId           | Y        | Long   | 父订单ID        | -       |              |

RESPONSE DATA

| NAME          | REQUIRED | TYPE   | DESCRIBE | DEFAULT | VALUES RANGE |
|:--------------|:---------|:-------|:---------|:--------|:-------------|  
| pageCount     | Y        | string | 总页数    | -       |              |  
| pageNo        | Y        | string | 页码      |        |              |  
| pageSize      | Y        | string | 每页数量  |        |              |  
| total         | Y        | string | 总条数  |        |              |  
| accountId     | Y        | string | 账户ID  |        |              |  
| commission    | Y        | string | 手续费  |        |              |  
| cpId          | Y        | string | CP ID  |        |              |  
| executeAmount | Y        | string | 约定量  |        |              |  
| executeTime   | Y        | string | 约定时间  |        |              |  
| executeVolume  | Y        | string | 约定数量  |        |              |  
| id             | Y       | string |  ID  |        |              |  
| orderComment   | Y        | string | 备注  |        |              |  
| orderResult    | Y        | string | 结果  |        |              |  
| orderTime      | Y        | string | 挂单时间  |        |              |  
| orderType      | Y        | string | 挂单类型  |        |              |  
| orderVolume      | Y        | string | 挂单数量  |        |              |  
| pendingVolume      | Y        | string | 执行数量  |        |              |  
| side           | Y        | string | 买卖方向  |        |              |
| sourceId      | Y        | string | 父订单ID  |        |              |
| status        | Y        | string | 状态  |        |              |
| symbolId      | Y        | string | SYMBOL ID  |        |              |
| timeInForce      | Y        | string | 过期类型  |        |              |

| accountId      | Y        | string | 账户ID  |        |              |
| symbolId       | Y        | string | SYMBOL ID  |        |              |
| commission      | Y        | string | 手续费  |        |              |
| cpId           | Y        | string | CP ID  |        |              |
| executeAmount   | Y        | string | 约定量  |        |              |
| executeComment    | Y        | string | 约定备注  |        |              |
| executePrice    | Y        | string | 约定价格  |        |              |
| executeTime      | Y        | string | 约定时间  |        |              |
| executeVolume    | Y        | string | 约定数量  |        |              |
| id              | Y      | string | ID  |        |              |
| orderId          | Y        | string | 订单ID  |        |              |

result sample
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
 

### 获取 Order历史 列表
GET  /api/v1/trades/cpOrderHistory

Headers:
X-IDCM-APIKEY:（token，通过登录接口获得.）

PARAMETER DATA

| NAME               | REQUIRED | TYPE   | DESCRIBE     | DEFAULT | VALUES RANGE |
|:-------------------|:---------|:-------|:-------------|:--------|:-------------|
| cpId               | Y        | Long   | CP ID        | -       |              |
| symbolId           | Y        | Long   | SYMBOL ID    | -       |              |
| status             | Y        | Long   | SYMBOL ID    | -       |              |
| from               | Y        | Long   | 开始时间      | -       |              |
| to                 | Y        | Long   | 结束时间      | -       |              |
| pageNo             | Y        | Long   | 页码          | -       |              |

RESPONSE DATA

| NAME          | REQUIRED | TYPE   | DESCRIBE | DEFAULT | VALUES RANGE |
|:--------------|:---------|:-------|:---------|:--------|:-------------|
| pageCount     | Y        | string | 总页数    | -       |              |
| pageNo        | Y        | string | 页码      |        |              |
| pageSize      | Y        | string | 每页数量  |        |              |
| total      | Y        | string | 总条数  |        |              |
| accountId     | Y        | string | 账户ID    | -       |              |
| cpId     | Y        | string | CP    | -       |              |
| executeAmount     | Y        | string | 约定价格    | -       |              |
| executeTime     | Y        | string | 约定时间    | -       |              |
| executeVolume     | Y        | string | 约定数量    | -       |              |
| id     | Y        | string | ID    | -       |              |
| orderComment     | Y        | string | 备注    | -       |              |
| orderPrice     | Y        | string | 挂单价格    | -       |              |
| orderTime     | Y        | string | 挂单时间    | -       |              |
| orderType     | Y        | string | 挂单类型    | -       |              |
| orderVolume     | Y        | string | 挂单数量    | -       |              |
| pendingVolume     | Y        | string | 执行数量    | -       |              |
| rejectReason     | Y        | string | 拒绝原因   | -       |              |
| side     | Y        | string | 买卖方向    | -       |              |
| sourceId     | Y        | string | 父ID    | -       |              |
| status     | Y        | string | 状态    | -       |              |
| symbolId     | Y        | string | SYMBOL ID    | -       |              |
| timeInForce     | Y        | string | 交易类型    | -       |              |
| commission     | Y        | string | 手续费    | -       |              |

result sample
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


### 获取CP Execution历史 列表
GET  /v1/trades/cpExecutionHistory

Headers:
X-IDCM-APIKEY:（token，通过登录接口获得.）

PARAMETER DATA

| NAME               | REQUIRED | TYPE   | DESCRIBE     | DEFAULT | VALUES RANGE |
|:-------------------|:---------|:-------|:-------------|:--------|:-------------|
| cpId               | Y        | Long   | CP ID        | -       |              |
| symbolId           | Y        | Long   | SYMBOL ID    | -       |              |
| from               | Y        | Long   | 开始时间      | -       |              |
| to                 | Y        | Long   | 结束时间      | -       |              |
| pageNo             | Y        | Long   | 页码          | -       |              |

RESPONSE DATA

| NAME          | REQUIRED | TYPE   | DESCRIBE | DEFAULT | VALUES RANGE |
|:--------------|:---------|:-------|:---------|:--------|:-------------|
| pageCount     | Y        | string | 总页数    | -       |              |
| pageNo        | Y        | string | 页码      |        |              |
| pageSize      | Y        | string | 每页数量  |        |              |
| total      | Y        | string | 总条数  |        |              |
| tradingEnabled| Y        | string | 交易限制  | -       |              |
| accountId     | Y        | string | 账户ID    | -       |              |
| commission    | Y        | string | 手续费    | -       |              |
| cpId          | Y        | string | CP ID     | -       |              |
| executeAmount | Y        | string | 交易价格  | -       |              |
| executeComment| Y        | string | 备注      | -       |              |
| executePrice  | Y        | string | 价格      | -       |              |
| executeTime   | Y        | string | 时间      | -       |              |
| executeVolume | Y        | string | 交易量    | -       |              |
| id            | Y         | string | ID       | -       |              |
| orderId       | Y        | string | 订单ID    | -       |              |
| side          | Y        | string | 买卖方向   | -       |              |
| symbolId      | Y        | string | 货币对ID   | -       |              |

result sample
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