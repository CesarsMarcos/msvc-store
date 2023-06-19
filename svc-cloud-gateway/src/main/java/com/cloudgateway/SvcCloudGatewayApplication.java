package com.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SvcCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvcCloudGatewayApplication.class, args);
	}

}
