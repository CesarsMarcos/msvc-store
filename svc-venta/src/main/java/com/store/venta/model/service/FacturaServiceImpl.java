package com.store.venta.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.store.venta.client.ClienteClient;
import com.store.venta.client.ProductoClient;
import com.store.venta.model.Cliente;
import com.store.venta.model.Producto;
import com.store.venta.model.entity.Factura;
import com.store.venta.model.entity.FacturaItem;
import com.store.venta.model.repository.FacturaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FacturaServiceImpl implements IFacturaService {

	// private final FacturaItemRepository itemRepo;

	private final FacturaRepository facturaRepo;

	private final ClienteClient clienteClient;

	private final ProductoClient productoClient;

	@Override
	public List<Factura> findFacturaAll() {
		return facturaRepo.findAll();
	}

	@Override
	public Factura crearFactura(Factura factura) {
		
		Factura facturaSave = facturaRepo.findByNumeroFactura(factura.getNumeroFactura());

		if (facturaSave != null) {
			return facturaSave;
		}
		factura.setEstado("CREATED");
		facturaSave = facturaRepo.save(factura);
		
		facturaSave.getItems().forEach(invoiceItem -> {
			productoClient.updateStockProducto(invoiceItem.getProductoId(), invoiceItem.getCantidad() * -1);
		});

		return facturaSave;
	}

	@Override
	public Factura updateFactura(Factura factura) {
		
		Factura facturaSave = getFactura(factura.getId());
		
		if(facturaSave == null) {
			return null;
		}
		
		facturaSave.setClienteId(factura.getClienteId());
		facturaSave.setDescripcion(factura.getDescripcion());
		facturaSave.getItems().clear();
		facturaSave.setItems(factura.getItems());
		
		return facturaRepo.save(facturaSave);
	}

	@Override
	public Factura deleteFactura(Factura factura) {
		
		Factura facturaSave = getFactura(factura.getId());
		if (facturaSave == null) {
			return null;
		}
		facturaSave.setEstado("DELETE");
		return facturaRepo.save(facturaSave);
	}

	@Override
	public Factura getFactura(Long id) {
		
		Factura factura = facturaRepo.findById(id).orElse(null);
		if (factura != null) {
			Cliente cliente = clienteClient.getCliente(factura.getClienteId()).getBody();
			factura.setCliente(cliente);

			List<FacturaItem> lista = factura.getItems().stream().map(x -> {
				Producto producto = productoClient.producto(x.getProductoId()).getBody();
				x.setProducto(producto);
				return x;
			}).collect(Collectors.toList());

			factura.setItems(lista);
		}

		return factura;
	}

}
