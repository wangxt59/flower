package com.flower.rabbitmq.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout1")
public class FanoutCustomer1 {
    @RabbitHandler
    public void showMassage(String message){
        System.out.println("fanout1---Customer："+message);
    }
}
