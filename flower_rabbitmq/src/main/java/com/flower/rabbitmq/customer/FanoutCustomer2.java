package com.flower.rabbitmq.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout2")
public class FanoutCustomer2 {
    @RabbitHandler
    public void showMassage(String message){
        System.out.println("fanout2---Customer："+message);
    }
}