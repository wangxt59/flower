package com.flower.rabbitmq.Producer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("topic")
public class Topic1 {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping("1")
    public Map sendTopic(){

        rabbitTemplate.convertAndSend("flower.topic","goods.aaa","主题模式:goods.aaa");
        rabbitTemplate.convertAndSend("flower.topic","article.content.log","主题模式:article.content.log");
        rabbitTemplate.convertAndSend("flower.topic","goods.log","主题模式:goods.log");


        return new HashMap<String,Object>();
    }
}
