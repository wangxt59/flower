package com.wang.controller;


import com.wang.websocket_stomp.ClientMessage;
import com.wang.websocket_stomp.ServerMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author cheng
 * @ClassName: WebSocketAction
 * @Description: websocket控制层
 * @date 2017年9月27日 下午4:20:58
 */
@Controller
public class WebSocketAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private SimpUserRegistry userRegistry;

    //客户端只要订阅了/topic/subscribeTest主题，调用这个方法即可
    public void templateTest() {
        messagingTemplate.convertAndSend("/topic/subscribeTest", new ServerMessage("服务器主动推的数据"));
    }
    @RequestMapping(value = "/webSocket")
    public String webSocket() {
        System.out.println("webSocket!!!!");
        return "webSocket";
    }

    @RequestMapping(value = "/stomp")
    public String stomp() {
        System.out.println("stomp!!!!");
        return "stomp";
    }@RequestMapping(value = "/webSocketStomp")
    public String webSocketStomp() {
        System.out.println("webSocketStomp!!!!");
        return "webSocketStomp";
    }


    @MessageMapping("/sendTest")
    @SendTo("/topic/subscribeTest")
    public ServerMessage sendDemo(ClientMessage message) {
        logger.info("接收到了信息" + message.getName());
        return new ServerMessage("你发送的消息为:" + message.getName());
    }

    @SubscribeMapping("/subscribeTest")
    public ServerMessage sub() {
        logger.info("XXX用户订阅了我。。。");
        return new ServerMessage("感谢你订阅了我。。。");
    }

    @RequestMapping(value = "/templateTest")
    public void templateTestM() {
        logger.info("当前在线人数:" + userRegistry.getUserCount());
        int i = 1;
        for (SimpUser user : userRegistry.getUsers()) {
            logger.info("用户" + i++ + "---" + user);
        } //发送消息给指定用户 messagingTemplate.convertAndSendToUser("test", "/queue/message", new ServerMessage("服务器主动推的数据")); }
    }
}