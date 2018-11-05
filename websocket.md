# Websocket接口信息(2018-10-12)

WebSocket是HTML5一种新的协议(Protocol)。它实现了客户端与服务器全双工通信，使得数据可以快速地双向传播。通过一次简单的握手就可以建立客户端和服务器连接，服务器根据业务规则可以主动推送信息给客户端。

- Websocket请求地址 
  生产环境：**wss://trade.bthub.com:444** 
  测试环境：**wss://demo.bthub.com:444** 
- Websocket请求需要进行登录认证才可以访问。
- 创建连接且登陆后才可发送相应的指令进行消息的订阅和取消订阅。

## 接口列表

| 请求指令                      | 描述                 |
| :---------------------------- | -------------------- |
| [subscribe:apiOrder](#Mark1)             | 订阅订单成交结果     |
| [unsubscribe:apiOrder](#Mark1)           | 取消订阅订单成交结果 |
| [subscribe:apiQuote:symbolId](#Mark2)    | 订阅行情深度         |
| [unsubscribe:apiOrder:symbolId](#Mark2)  | 取消订阅行情深度     |



## WEBSOCKET API

ws://127.0.0.1:8082/api/realtime?X-API-TOKEN=WHZWUFAxWlV0bzdMMzl5N1dmYy1z
X-API-TOKEN:（token，通过登录接口获得.）
<div id="Mark2"></div> 
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
<div id="Mark1"></div> 
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

