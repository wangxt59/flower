package com.flower.base.application;

import com.flower.common.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("com.flower.base")
@EnableJpaRepositories("com.flower.base.dao")
@EntityScan("com.flower.base.pojo")
public class FlowerBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowerBaseApplication.class, args);
	}

	@Bean
	public IdWorker idWorker(){
		return new IdWorker(1,1);
	}
}
