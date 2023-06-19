package com.store.venta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SvcVentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvcVentaApplication.class, args);
	}

}
