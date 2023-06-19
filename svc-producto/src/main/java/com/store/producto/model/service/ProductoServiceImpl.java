package com.store.producto.model.service;

import java.util.Date;
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
		return productoRepo.findById(id).orElse(null);
	}

	@Override
	public Producto registro(Producto producto) {
		producto.setEstado("CREATED");
		producto.setCreateAt(new Date());

		return productoRepo.save(producto);
	}

	@Override
	public Producto modificar(Producto producto) {
		Producto productoSave = getProducto(producto.getId());
		if (null == productoSave) {
			return null;
		}
		productoSave.setNombre(producto.getNombre());
		productoSave.setDescripcion(producto.getDescripcion());
		productoSave.setCategoria(producto.getCategoria());
		productoSave.setPrecio(producto.getPrecio());
		return productoRepo.save(productoSave);
	}

	@Override
	public Producto eliminar(Long id) {
		Producto productoSave = getProducto(id);
		if (null == productoSave) {
			return null;
		}
		productoSave.setEstado("DELETED");
		return productoRepo.save(productoSave);
	}

	@Override
	public List<Producto> findByCategoria(Categoria categoria) {
		return productoRepo.findByCategoria(categoria);
	}

	@Override
	public Producto updateStock(Long id, Integer cantidad) {

		Producto productoSave = getProducto(id);

		if (productoSave == null) {
			return null;
		}

		Integer stock = productoSave.getStock() + cantidad;
		productoSave.setStock(stock);

		return productoRepo.save(productoSave);
	}

}
