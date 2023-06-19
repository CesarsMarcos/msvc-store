package com.store.producto.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.producto.model.entity.Categoria;
import com.store.producto.model.entity.Producto;
import com.store.producto.model.service.ProductoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("productos")
@RequiredArgsConstructor
public class ProductoController {

	private final Logger logger = LoggerFactory.getLogger(ProductoController.class);

	private final ProductoService productoService;

	@GetMapping
	public ResponseEntity<List<Producto>> productos(@RequestParam(name = "id", required = false) Long id) {
		List<Producto> lista = new ArrayList<>();
		if (null == id) {
			lista = productoService.listAllProducto();

			if (lista.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		} else {
			lista = productoService.findByCategoria(Categoria.builder().id(id).build());

			if (lista.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Producto> producto(@PathVariable("id") Long id) {
		Producto productoSave = productoService.getProducto(id);
		if (productoSave == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(productoSave);
	}
	
	@PostMapping
	public ResponseEntity<Producto> guardar(@RequestBody Producto producto){
		Producto productoSave =  productoService.registro(producto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoSave);
	}
	
	@PutMapping (value = "/{id}/stock")
	 public ResponseEntity<Producto> updateStockProducto(@PathVariable  Long id ,@RequestParam(name = "cantidad", required = true) Integer cantidad){
		Producto productoSave = productoService.updateStock(id, cantidad);
        if (productoSave == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productoSave);
    }
	
	

}
