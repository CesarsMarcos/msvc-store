package com.store.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SvcOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvcOauthApplication.class, args);
	}

}
