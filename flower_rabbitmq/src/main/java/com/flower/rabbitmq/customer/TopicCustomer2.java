package com.flower.rabbitmq.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic2")
public class TopicCustomer2 {
    @RabbitHandler
    private void gteMessage(String message){
        System.out.println("TopicCustomer2:#.log:"+message);
    }
}
