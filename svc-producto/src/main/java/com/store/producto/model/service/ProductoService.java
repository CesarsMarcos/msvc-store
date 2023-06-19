package com.store.producto.model.service;

import java.util.List;

import com.store.producto.model.entity.Categoria;
import com.store.producto.model.entity.Producto;

public interface ProductoService {

	public List<Producto> listAllProducto();

	public Producto getProducto(Long id);

	public Producto registro(Producto producto);

	public Producto modificar(Producto producto);

	public Producto eliminar(Long id);

	public List<Producto> findByCategoria(Categoria categoria);

	public Producto updateStock(Long id, Integer cantidad);

}
