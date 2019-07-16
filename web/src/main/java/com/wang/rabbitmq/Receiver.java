package com.wang.rabbitmq;

import com.wang.config.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author cheng
 * @className: Receiver
 * @description: 消费者
 * @dateTime 2018/5/4 16:52
 */
@Component
@RabbitListener(queues = RabbitMQConfig.QUEUE_A)
public class Receiver {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(String content) {
        try {
            Thread.sleep(3000);
        }catch (Exception e){

        }

        System.out.println("接收处理队列A当中的消息： " + content);
//        logger.info("接收处理队列A当中的消息： " + content);
    }

}