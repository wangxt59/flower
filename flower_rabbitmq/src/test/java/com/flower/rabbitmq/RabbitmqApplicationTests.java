package com.flower.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	public void contextLoads() {

	}
	@Test
	public void testSend() {
		rabbitTemplate.convertAndSend("itcast","我要红包");
	}


}
