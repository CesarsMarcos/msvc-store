package com.store.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class SvcUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvcUsuariosApplication.class, args);
	}

}
