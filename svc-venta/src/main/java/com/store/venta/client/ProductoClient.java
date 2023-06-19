package com.store.venta.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.venta.model.Producto;

@FeignClient(name = "svc-productos", url = "localhost:8089" , path = "/productos")
public interface ProductoClient {

	@GetMapping("/{id}")
	public ResponseEntity<Producto> producto(@PathVariable("id") Long id);

	@PutMapping(value = "/{id}/stock")
	 public ResponseEntity<Producto> updateStockProducto(@PathVariable  Long id ,@RequestParam(name = "cantidad", required = true) Integer cantidad);

}
