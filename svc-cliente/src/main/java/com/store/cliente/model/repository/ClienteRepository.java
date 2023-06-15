package com.store.cliente.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.cliente.model.entity.Cliente;
import com.store.cliente.model.entity.Region;


public interface ClienteRepository  extends JpaRepository<Cliente, Long>{
	
	Cliente  findByRegion(Region  region);
	
}
