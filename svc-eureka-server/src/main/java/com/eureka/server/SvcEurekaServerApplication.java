package com.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SvcEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvcEurekaServerApplication.class, args);
	}

}
