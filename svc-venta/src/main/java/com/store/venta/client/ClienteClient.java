package com.store.venta.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.store.venta.model.Cliente;


@FeignClient(name = "svc-clientes" , url = "localhost:8092", path = "/clientes")
public interface ClienteClient {

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getCliente(@PathVariable("id") Long id);
	
}
