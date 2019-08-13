package com.flower.message;

import com.flower.message.sendMessage.TencentMessageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MessageApplication.class)
public class MessageApplicationTests {
	@Autowired
	public TencentMessageUtil tencentMessageUtil;

	@Test
	public void contextLoads() {
		tencentMessageUtil.getParameter();
	}

}
