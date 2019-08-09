package com.flower.rabbitmq.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "itcast")
public class Customer3 {

    @RabbitHandler
    public void showMassage(String message){
        System.out.println("itcast---Customer3："+message);
    }
}
