package com.store.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.clientes.model.entity.Cliente;
import com.store.clientes.model.entity.Region;


public interface ClienteRepository  extends JpaRepository<Cliente, Long>{
	
	Cliente  findByRegion(Region  region);
	
}
