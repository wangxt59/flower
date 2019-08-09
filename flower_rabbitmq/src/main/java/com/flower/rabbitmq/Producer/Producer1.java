package com.flower.rabbitmq.Producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("send")
public class Producer1 {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("1")
    public Map send() {
        Map map=new HashMap();
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("itcast","direct直连--"+i);
        }
        map.put("status","ok");
        return map;
    }
}
