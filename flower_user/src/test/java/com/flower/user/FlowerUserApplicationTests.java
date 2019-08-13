package com.flower.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlowerUserApplication.class)
public class FlowerUserApplicationTests {
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	public void contextLoads() {
		System.out.println(encoder.encode("admin"));
	}

}
