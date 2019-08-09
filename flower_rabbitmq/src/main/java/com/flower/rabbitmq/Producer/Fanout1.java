package com.flower.rabbitmq.Producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("fanout1")
public class Fanout1 {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("1")
    public Map send() {
        Map map=new HashMap();
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("flower.fanout","1","分列模式"+i);
        }
        map.put("status","ok");
        return map;
    }
}
