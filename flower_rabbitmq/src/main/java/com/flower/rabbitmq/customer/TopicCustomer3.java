package com.flower.rabbitmq.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic3")
public class TopicCustomer3 {
    @RabbitHandler
    private void getMessage(String message){
        System.out.println("TopicCustomer3: goods.log:"+message);
    }
}
