# Websocket接口信息(2018-10-12)

WebSocket是HTML5一种新的协议(Protocol)。它实现了客户端与服务器全双工通信，使得数据可以快速地双向传播。通过一次简单的握手就可以建立客户端和服务器连接，服务器根据业务规则可以主动推送信息给客户端。

- Websocket请求地址:     
    生产环境：wss://trade.bthub.com:444    
    测试环境：wss://demo.bthub.com:444     
- Websocket请求需要进行登录认证才可以访问。
- 创建连接且登陆后才可发送相应的指令进行消息的订阅和取消订阅。
- 创建连接后需要定时向服务器发送ping,用来保持连接.频率:30分

## 接口列表

| 请求指令                      | 描述                 |
| :---------------------------- | -------------------- |
| [subscribe:apiOrder](#订阅订单成交结果)             | 订阅订单成交结果     |
| [unsubscribe:apiOrder](#订阅订单成交结果)           | 取消订阅订单成交结果 |
| [subscribe:apiQuote:symbolId](#订阅行情深度)    | 订阅行情深度     (symbolId:货币对ID)    |
| [unsubscribe:apiOrder:symbolId](#订阅行情深度)  | 取消订阅行情深度   (symbolId:货币对ID)  |
| [subscribe:apiAggregatedQuote:symbolId](#订阅聚合行情深度)    | 订阅聚合行情深度     (symbolId:货币对ID)    |
| [unsubscribe:apiAggregatedQuote:symbolId](#订阅聚合行情深度)  | 取消订阅聚合行情深度   (symbolId:货币对ID)  |
| [ping](#保持空闲连接)| 心跳命令 |


## WEBSOCKET API

wss://demo.bthub.com:444/api/realtime?X-API-TOKEN=WHZWUFAxWlV0bzdMMzl5N1dmYy1z
X-API-TOKEN:（token，通过登录接口获得.）

### 订阅行情深度
***汇率请求指令***

| 请求指令                      | 描述             |
| :---------------------------- | :--------------- |
| subscribe:apiQuote:symbolId   | 订阅行情深度     |
| unsubscribe:apiOrder:symbolId | 取消订阅行情深度 |

 ***汇率推送返回参数***

| NAME       | TYPE   | DESCRIBE        |
| :--------- | :----- | :-------------- |
| event      | String | 事件(API_QUOTE) |
| commission | double | 手续费          |
| cpId       | short  | CP ID           |
| symbolId   | int    | 货币对ID        |
| price | double | 价格          |
| volume| short  | 数量           |

 ***汇率推送返回参数示例***

```
 {
 	"event": "API_QUOTE",
 	"data": {
 		"asks": [{
 			"price": "6401.9065",
 			"volume": "0.01966"
 		}, {
 			"price": "6401.9075",
 			"volume": "0.022"
 		}],
 		"bids": [{
 			"price": "6399.302",
 			"volume": "0.8"
 		}, {
 			"price": "6399.2931",
 			"volume": "0.048"
 		}],
 		"commission": "0.0001",
 		"cpId": 259,
 		"symbolId": 65537
 	}
 }
```
### 订阅订单成交结果
***订单请求指令***

| 请求指令             | 描述                 |
| :------------------- | :------------------- |
| subscribe:apiOrder   | 订阅订单成交结果     |
| unsubscribe:apiOrder | 取消订阅订单成交结果 |

 ***订单成交推送返回参数***

| NAME          | TYPE       | DESCRIBE              |
| :------------ | :--------- | :-------------------- |
| event         | String     | 事件(API_ORDER)       |
| id            | long       | ID                    |
| symbolId      | int        | 货币对ID              |
| accountId     | long       | 账户ID                |
| sourceId      | long       | 父订单                |
| side          | String     | [买卖方向(Side)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)        |
| status        | String     | [状态(OrderStatus)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)     |
| orderType     | String     | [挂单类型(OrderType)](https://github.com/lw-bthub/api-demo/blob/master/enum.md)   |
| executeAmount | BigDecimal | 成交金额              |
| executeVolume | BigDecimal | 成交数量              |
| orderVolume   | BigDecimal | 挂单数量              |
| pendingVolume | BigDecimal | 执行数量              |
| executeTime   | long       | 时间                  |
| orderTime     | long       | 挂单时间              |
| commission    | double     | 手续费                |
| timeInForce   | String     | [过期类型(TimeInForce)](https://github.com/lw-bthub/api-demo/blob/master/enum.md) |
| orderComment  | String     | 备注                  |

  ***订单成交结果推送返回参数示例***

```
  {
  	"event": "API_ORDER",
  	"data": [{
  		"accountId": 0,
  		"commission": "0.9999",
  		"cpId": 258,
  		"executeAmount": "0",
  		"executeTime": "0",
  		"executeVolume": "0",
  		"executions": [],
  		"id": "723970960352354857",
  		"orderComment": "723970958215745045.0",
  		"orderTime": "1537878063839",
  		"orderType": 5,
  		"orderVolume": "0.0100",
  		"pendingVolume": "0.0000",
  		"side": -1,
  		"sourceId": "723970960352354345",
  		"status": 1,
  		"symbolId": 1,
  		"timeInForce": 1
  	}, {
  		"accountId": 0,
  		"cpId": 0,
  		"executeAmount": "0",
  		"executeTime": "0",
  		"executeVolume": "0",
  		"executions": [],
  		"id": "723970960352354345",
  		"orderTime": "1537878063839",
  		"orderType": 5,
  		"orderVolume": "0.01",
  		"pendingVolume": "0.0000",
  		"side": -1,
  		"sourceId": "0",
  		"status": 1,
  		"symbolId": 1,
  		"timeInForce": 1
  	}]
  }
```
### 订阅聚合行情深度
***汇率请求指令***

| 请求指令                      | 描述             |
| :---------------------------- | :--------------- |
| subscribe:apiAggregatedQuote:symbolId   | 订阅聚合行情深度     |
| unsubscribe:apiAggregatedQuote:symbolId | 取消订阅聚合行情深度 |

 ***汇率推送返回参数***

| NAME       | TYPE   | DESCRIBE        |
| :--------- | :----- | :-------------- |
| event      | String | 事件(API_AGGREGATED_QUOTE) |
| cpId       | short  | CP ID           |
| symbolId   | int    | 货币对ID        |
| price | double | 价格          |
| volume| short  | 数量           |

 ***汇率推送返回参数示例***

```
 {
 	"event": "API_AGGREGATED_QUOTE",
 	"data": {
 		"asks": [{
 			"cpId": 259,
 			"price": "6489.77778",
 			"volume": "0.04900"
 		}, {
 			"cpId": 259,
 			"price": "6489.77808",
 			"volume": "0.03691"
 		}, {
 			"cpId": 259,
 			"price": "6489.77878",
 			"volume": "0.19228"
 		}, {
 			"cpId": 259,
 			"price": "6489.77888",
 			"volume": "1.28800"
 		}, {
 			"cpId": 259,
 			"price": "6489.77898",
 			"volume": "0.00620"
 		}, {
 			"cpId": 258,
 			"price": "6553.38384",
 			"volume": "0.29030"
 		}, {
 			"cpId": 258,
 			"price": "6553.39394",
 			"volume": "0.89990"
 		}, {
 			"cpId": 257,
 			"price": "6556.12122",
 			"volume": "0.85028"
 		}, {
 			"cpId": 257,
 			"price": "6556.13132",
 			"volume": "1.61673"
 		}, {
 			"cpId": 257,
 			"price": "6556.15152",
 			"volume": "20.80000"
 		}, {
 			"cpId": 257,
 			"price": "6556.17172",
 			"volume": "0.08242"
 		}, {
 			"cpId": 257,
 			"price": "6556.19192",
 			"volume": "0.07693"
 		}],
 		"bids": [{
 			"cpId": 259,
 			"price": "6486.85874",
 			"volume": "0.47000"
 		}, {
 			"cpId": 259,
 			"price": "6486.85864",
 			"volume": "0.10644"
 		}, {
 			"cpId": 259,
 			"price": "6486.69336",
 			"volume": "0.38500"
 		}, {
 			"cpId": 259,
 			"price": "6486.56687",
 			"volume": "0.63044"
 		}, {
 			"cpId": 259,
 			"price": "6485.54138",
 			"volume": "0.50000"
 		}, {
 			"cpId": 257,
 			"price": "6423.60510",
 			"volume": "0.24601"
 		}, {
 			"cpId": 257,
 			"price": "6423.59520",
 			"volume": "0.16851"
 		}, {
 			"cpId": 257,
 			"price": "6423.58530",
 			"volume": "0.19182"
 		}, {
 			"cpId": 258,
 			"price": "6422.67450",
 			"volume": "0.00200"
 		}, {
 			"cpId": 258,
 			"price": "6422.41710",
 			"volume": "0.10000"
 		}, {
 			"cpId": 257,
 			"price": "6420.26880",
 			"volume": "10.06763"
 		}, {
 			"cpId": 257,
 			"price": "6420.15000",
 			"volume": "0.45792"
 		}],
 		"symbolId": 65537
 	}
 }
```

