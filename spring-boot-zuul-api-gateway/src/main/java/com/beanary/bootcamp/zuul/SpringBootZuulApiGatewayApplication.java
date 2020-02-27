package com.beanary.bootcamp.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableZuulProxy
@EnableEurekaServer
@EnableFeignClients
@SpringBootApplication
public class SpringBootZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootZuulApiGatewayApplication.class, args);
	}

}
