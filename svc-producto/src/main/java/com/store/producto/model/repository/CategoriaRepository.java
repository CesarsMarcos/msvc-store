package com.store.producto.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.producto.model.entity.Categoria;


public interface CategoriaRepository  extends JpaRepository<Categoria, Long>{


	
}
