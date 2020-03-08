package com.beanary.rest.restbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RestBasicApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestBasicApplication.class, args);
	}
}
