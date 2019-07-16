package com.wang.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.applet.Main;

import java.util.HashMap;
import java.util.Map;

@RestController
//@Controller
@RequestMapping("/mq")
public class MyMQ {
    @Autowired
    public SenderService senderService;
    public int num=0;
    @RequestMapping("/send")
    @ResponseBody
    public Map<String,Object> send(String string) {
        Map<String ,Object> map=new HashMap<String, Object>();
        System.out.println("第"+(num++)+"次消息"+string);
        senderService.sendMsg("第"+num+"次消息"+string);
        map.put("code","0");
        map.put("desc","OK");
        return map;
    }
}
