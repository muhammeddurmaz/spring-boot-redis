package com.muhammed.springbootredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class SpringbootredisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootredisApplication.class, args);
	}

}
