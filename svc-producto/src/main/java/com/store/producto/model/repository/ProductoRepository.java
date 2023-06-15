package com.store.producto.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.producto.model.entity.Categoria;
import com.store.producto.model.entity.Producto;

public interface ProductoRepository  extends JpaRepository<Producto, Long>{
	
	public List<Producto> findByCategoria(Categoria categoria);
}
