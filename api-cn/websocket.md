# Websocket接口信息(2018-12-28)

WebSocket是HTML5一种新的协议(Protocol)。它实现了客户端与服务器全双工通信，使得数据可以快速地双向传播。通过一次简单的握手就可以建立客户端和服务器连接，服务器根据业务规则可以主动推送信息给客户端。

- Websocket请求地址:     
    生产环境：wss://trade.bthub.com:444    
    测试环境：wss://demo.bthub.com:444    
- Websocket请求需要进行登录认证才可以访问。
- 创建连接且登陆后才可发送相应的指令进行消息的订阅和取消订阅。
- 创建连接后需要定时向服务器发送ping,用来保持连接.频率:30分

## 接口列表

| 请求指令                                                   | 描述                                     |
|:-----------------------------------------------------------|:-----------------------------------------|
| [subscribe:apiOrder](#订阅订单成交结果)                    | 订阅订单成交结果                         |
| [unsubscribe:apiOrder](#订阅订单成交结果)                  | 取消订阅订单成交结果                     |
| [subscribe:apiQuote:symbol](#订阅行情深度)                 | 订阅行情深度     (symbol:币对名称)       |
| [unsubscribe:apiQuote:symbol](#订阅行情深度)               | 取消订阅行情深度   (symbol:币对名称)     |
| [subscribe:apiAggregatedQuote:symbol](#订阅聚合行情深度)   | 订阅聚合行情深度     (symbol:币对名称)   |
| [unsubscribe:apiAggregatedQuote:symbol](#订阅聚合行情深度) | 取消订阅聚合行情深度   (symbol:币对名称) |
| [subscribe:apiRiskPosition:all:book](#订阅风控详情)        | 订阅风控详情     (book:账簿名称)         |
| [unsubscribe:apiRiskPosition:all:book](#取消订阅风控详情)  | 取消订阅风控详情   (book:账簿名称)       |
| [ping](#保持空闲连接)                                      | 心跳命令                                 |


## WEBSOCKET API

wss://demo.bthub.com:444/api/realtime?X-API-TOKEN=WHZWUFAxWlV0bzdMMzl5N1dmYy1z    

X-API-TOKEN:token(通过login获得）

### 订阅行情深度
***汇率请求指令***

| 请求指令                    | 描述             |
|:----------------------------|:-----------------|
| subscribe:apiQuote:symbol   | 订阅行情深度     |
| unsubscribe:apiQuote:symbol | 取消订阅行情深度 |

 ***汇率推送返回参数***

| NAME       | TYPE   | DESCRIBE        |
|:-----------|:-------|:----------------|
| event      | string | 事件(API_QUOTE) |
| commission | number | 手续费          |
| cp         | string | 交易对手名称    |
| symbol     | string | 交易币对名称    |
| price      | number | 价格            |
| volume     | number | 数量            |

 ***汇率推送返回参数示例***

```
 {
 	"event": "API_QUOTE",
 	"data": {
 		"asks": [{
 			"price": "5379.3864",
 			"volume": "0.1"
 		}, {
 			"price": "5379.3865",
 			"volume": "0.166"
 		}, {
 			"price": "5379.6339",
 			"volume": "0.001"
 		}, {
 			"price": "5385.3535",
 			"volume": "1.89179998"
 		}, {
 			"price": "5385.3536",
 			"volume": "0.001"
 		}],
 		"bids": [{
 			"price": "5376.0837",
 			"volume": "0.40748547"
 		}, {
 			"price": "5376.0836",
 			"volume": "0.33848547"
 		}, {
 			"price": "5375.4579",
 			"volume": "1"
 		}, {
 			"price": "5375.4207",
 			"volume": "0.00885"
 		}, {
 			"price": "5375.3574",
 			"volume": "0.00978"
 		}],
 		"commission": "0.0001",
 		"cp": "okex",
 		"symbol": "BTCUSDT"
 	}
 }
```
### 订阅订单成交结果
***订单请求指令***

| 请求指令             | 描述                 |
|:---------------------|:---------------------|
| subscribe:apiOrder   | 订阅订单成交结果     |
| unsubscribe:apiOrder | 取消订阅订单成交结果 |

 ***订单成交推送返回参数***

| NAME          | TYPE    | DESCRIBE                                                                          |
|:--------------|:--------|:----------------------------------------------------------------------------------|
| event         | string  | 事件(API_ORDER)                                                                   |
| cpOrderId     | integer | CP 订单ID                                                                         |
| symbol        | string  | 交易币对名称                                                                      |
| accountId     | integer | 账户ID                                                                            |
| orderId       | integer | 父订单                                                                            |
| side          | string  | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)        |
| status        | string  | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)     |
| orderType     | string  | [订单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)   |
| executeAmount | number  | 成交金额                                                                          |
| executeVolume | number  | 成交数量                                                                          |
| orderVolume   | number  | 订单数量                                                                          |
| pendingVolume | number  | 未成交数量                                                                        |
| executeTime   | integer | 成交时间                                                                          |
| orderTime     | integer | 订单时间                                                                          |
| commission    | number  | 手续费                                                                            |
| timeInForce   | string  | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/enum.md) |
| orderResult   | string  | [结果(OrderResult)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)     |
| orderComment  | string  | 备注                                                                              |

  ***订单成交结果推送返回参数示例***

```
{
  	"event": "API_ORDER",
  	"data": {
  		"cpOrders": [{
  			"commission": "0.0100",
  			"cp": "binance",
  			"cpOrderId": "764451239273443359",
  			"executeAmount": "177.1343336000000000",
  			"executeTime": "1542703689751",
  			"executeVolume": "0.04018000",
  			"executions": [{
  				"cp": "binance",
  				"cpExecutionid": "764451245254521375",
  				"executeAmount": "177.1343336000000000",
  				"executeComment": "CommissionAsset: USDT",
  				"executePrice": "4408.52000000",
  				"executeTime": "1542703689751",
  				"executeVolume": "0.04018000",
  				"side": -1,
  				"symbol": "BTCUSDT"
  			}],
  			"orderComment": "764451230726985237.0",
  			"orderResult": 3,
  			"orderTime": "1542703689130",
  			"orderType": 5,
  			"orderVolume": "0.04018",
  			"pendingVolume": "0.00000000",
  			"side": -1,
  			"status": 4,
  			"symbol": "BTCUSDT",
  			"timeInForce": 1
  		}],
  		"executeAmount": "177.1343336000000000",
  		"executeTime": "1542703689751",
  		"executeVolume": "0.04018000",
  		"orderId": "764451239265054239",
  		"orderResult": 5,
  		"orderTime": "1542703689130",
  		"orderType": 5,
  		"orderVolume": "0.1",
  		"pendingVolume": "0.05982000",
  		"side": -1,
  		"status": 4,
  		"symbol": "BTCUSDT",
  		"timeInForce": 1
  	}
  }
```
### 订阅聚合行情深度
***汇率请求指令***

| 请求指令                              | 描述                 |
|:--------------------------------------|:---------------------|
| subscribe:apiAggregatedQuote:symbol   | 订阅聚合行情深度     |
| unsubscribe:apiAggregatedQuote:symbol | 取消订阅聚合行情深度 |

 ***汇率推送返回参数***

| NAME   | TYPE   | DESCRIBE                   |
|:-------|:-------|:---------------------------|
| event  | string | 事件(API_AGGREGATED_QUOTE) |
| cp     | string | 交易对手名称               |
| symbol | string | 交易币对名称               |
| price  | number | 价格                       |
| volume | number | 数量                       |

 ***汇率推送返回参数示例***

```
 {
 	"event": "API_AGGREGATED_QUOTE",
 	"data": {
 		"asks": [{
 			"cp": "okex",
 			"price": "5378.18262",
 			"volume": "0.00100"
 		}, {
 			"cp": "okex",
 			"price": "5378.31774",
 			"volume": "1.00000"
 		}, {
 			"cp": "okex",
 			"price": "5378.50576",
 			"volume": "0.20000"
 		}, {
 			"cp": "okex",
 			"price": "5378.67577",
 			"volume": "1.00000"
 		}, {
 			"cp": "okex",
 			"price": "5379.02941",
 			"volume": "1.00000"
 		}, {
 			"cp": "binance",
 			"price": "5421.76768",
 			"volume": "0.01488"
 		}, {
 			"cp": "binance",
 			"price": "5422.36364",
 			"volume": "0.00547"
 		}, {
 			"cp": "binance",
 			"price": "5425.82829",
 			"volume": "1.88220"
 		}, {
 			"cp": "binance",
 			"price": "5425.87879",
 			"volume": "0.50000"
 		}, {
 			"cp": "binance",
 			"price": "5427.13132",
 			"volume": "1.17530"
 		}, {
 			"cp": "huobi",
 			"price": "5429.43435",
 			"volume": "0.06310"
 		}, {
 			"cp": "huobi",
 			"price": "5429.44445",
 			"volume": "0.07530"
 		}],
 		"bids": [{
 			"cp": "okex",
 			"price": "5376.75877",
 			"volume": "1.37200"
 		}, {
 			"cp": "okex",
 			"price": "5373.53419",
 			"volume": "0.20828"
 		}, {
 			"cp": "okex",
 			"price": "5373.25302",
 			"volume": "0.00100"
 		}, {
 			"cp": "okex",
 			"price": "5372.76346",
 			"volume": "0.86400"
 		}, {
 			"cp": "okex",
 			"price": "5372.56748",
 			"volume": "0.22866"
 		}, {
 			"cp": "huobi",
 			"price": "5318.87400",
 			"volume": "0.19130"
 		}, {
 			"cp": "huobi",
 			"price": "5317.31970",
 			"volume": "2.30760"
 		}, {
 			"cp": "binance",
 			"price": "5311.43910",
 			"volume": "1.19375"
 		}, {
 			"cp": "binance",
 			"price": "5311.42920",
 			"volume": "0.05459"
 		}, {
 			"cp": "binance",
 			"price": "5311.41930",
 			"volume": "2.28811"
 		}, {
 			"cp": "binance",
 			"price": "5311.40940",
 			"volume": "0.20774"
 		}, {
 			"cp": "binance",
 			"price": "5311.37970",
 			"volume": "0.50000"
 		}],
 		"symbol": "BTCUSDT"
 	}
 }
```


### 订阅风控详情
***风控请求指令***

| 请求指令                             | 描述                               |
|:-------------------------------------|:-----------------------------------|
| subscribe:apiRiskPosition:all:book   | 订阅风控详情     (book:账簿缩写)   |
| unsubscribe:apiRiskPosition:all:book | 取消订阅风控详情   (book:账簿缩写) |

 ***风控推送返回参数***

| NAME       | TYPE   | DESCRIBE                |
|:-----------|:-------|:------------------------|
| event      | string | 事件(API_RISK_POSITION) |
| book       | string | 账簿缩写                |
| cp         | string | 交易对手缩写            |
| openAmount | string | 净头寸                  |
| openVolume | string | 金额                    |
| symbol     | string | 币对名称                |



 ***风控推送返回参数示例***
 ```
{
  "event": "API_RISK_POSITION",
  "data": [
    {
      "book": "B",
      "cp": "binance",
      "openAmount": "266.428871696500",
      "openVolume": "-0.071040000000",
      "symbol": "BTCUSDT10"
    }
  ]
}
 ```
