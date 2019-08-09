package com.flower.rabbitmq.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic1")
public class TopicCustomer1 {
    @RabbitHandler
    private void getMessage(String message){
        System.out.println("TopicCustomer1: goods.#:"+message);
    }
}
