package com.flower.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class FlowerConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowerConfigApplication.class, args);
	}

}
