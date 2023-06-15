package com.store.venta.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.venta.model.entity.Factura;
import com.store.venta.model.repository.FacturaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FacturaServiceImpl implements IFacturaService {

	//private final FacturaItemRepository itemRepo;

	private final FacturaRepository facturaRepo;

	@Override
	public List<Factura> findFacturaAll() {
		return facturaRepo.findAll();
	}

	@Override
	public Factura crearFactura(Factura factura) {
		Factura facturaSave  = facturaRepo.findByNumeroFactura(factura.getNumeroFactura());
		 /* if (facturaSave !=null){
	            return  facturaSave;
	        }
		  factura.setState("CREATED");
		  facturaSave = facturaRepo.save(factura);
		  facturaSave.getItems().forEach( invoiceItem -> {
	            productClient.updateStockProduct( invoiceItem.getProductId(), invoiceItem.getQuantity() * -1);
	        });*/
		
		return facturaSave;
	}

	@Override
	public Factura updateFactura(Factura factura) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Factura deleteFactura(Factura factura) {
		Factura facturaSave  = getFactura(factura.getId());
		if (facturaSave ==null){
            return  null;
        }
		facturaSave.setEstado("DELETE");
		return facturaRepo.save(facturaSave);
	}

	@Override
	public Factura getFactura(Long id) {
		return facturaRepo.findById(id).orElse(null);
	}

}
