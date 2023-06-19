package com.store.cliente.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.cliente.controller.ClienteController;
import com.store.cliente.model.entity.Region;
import com.store.cliente.model.entity.Cliente;
import com.store.cliente.model.service.IClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {

	
	private final Logger logger = LoggerFactory.getLogger(ClienteController.class);

	private final IClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<Cliente>> clientes(@RequestParam(name = "id", required = false) Long id) {
		List<Cliente> lista = new ArrayList<>();
		if (null == id) {
			lista = clienteService.clientes();

			if (lista.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		} else {
			lista = clienteService.findByRegion(Region.builder().id(id).build());

			if (lista.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getCliente(@PathVariable("id") Long id) {
		Cliente clienteSave = clienteService.clientePorId(id);
		if (clienteSave == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(clienteSave);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> guardar(@RequestBody Cliente cliente){
		Cliente clienteSave =  clienteService.registro(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteSave);
	}
	
	
	
	
	
	
}
