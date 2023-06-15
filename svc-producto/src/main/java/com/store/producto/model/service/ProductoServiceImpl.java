package com.store.producto.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.producto.model.entity.Categoria;
import com.store.producto.model.entity.Producto;
import com.store.producto.model.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

	private final ProductoRepository productoRepo;
	
	@Override
	public List<Producto> listAllProducto() {
		return productoRepo.findAll();
	}

	@Override
	public Producto getProducto(Long id) {
		return productoRepo.findById(id).get();
	}

	@Override
	public Producto registro(Producto producto) {
		return productoRepo.save(producto);
	}

	@Override
	public Producto modificar(Producto producto) {
		return productoRepo.save(producto);
	}

	@Override
	public void eliminar(Long id) {
		productoRepo.deleteById(id);
	}

	@Override
	public List<Producto> findByCategoria(Categoria categoria) {
		return productoRepo.findByCategoria(categoria);
	}

	@Override
	public Producto updateStock(Long id, Double cantidad) {
		return null;
	}

}
