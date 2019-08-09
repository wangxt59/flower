package com.flower.message.customer;

import com.flower.message.sendMessage.TencentMessageUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "flower.message")
public class Customer {

    @RabbitHandler
    public void showMassage(Map<String,String> message){
        System.out.println("手机号："+message.get("mobile"));
        System.out.println("验证码："+message.get("code"));
        String msg="[FLOWER]亲的验证码："+message.get("code")+"，"+ 5 +"分钟内有效，为了保障您的账户安全，请勿向他人泄漏验证码信息";
        TencentMessageUtil.sendSingle(message.get("mobile"),msg);
    }
}
