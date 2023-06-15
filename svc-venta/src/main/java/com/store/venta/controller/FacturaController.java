package com.store.venta.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.venta.model.entity.Factura;
import com.store.venta.model.service.IFacturaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("facturas")
@RequiredArgsConstructor
public class FacturaController {

	private final Logger logger = LoggerFactory.getLogger(FacturaController.class);

	private final IFacturaService facturaService;

	@GetMapping
	public ResponseEntity<List<Factura>> listAllInvoices() {
		List<Factura> factura = facturaService.findFacturaAll();
		if (factura.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(factura);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Factura> getFactura(@PathVariable("id") long id) {
		logger.info("Fetching Factura with id {}", id);
		Factura factura = facturaService.getFactura(id);
		if (null == factura) {
			logger.error("Factura with id {} not found.", id);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(factura);
	}

	@PostMapping
	public ResponseEntity<Factura> createInvoice(@RequestBody Factura factura) {
		logger.info("Creating Factura : {}", factura);
		Factura facturaDB = facturaService.crearFactura(factura);
		return ResponseEntity.status(HttpStatus.CREATED).body(facturaDB);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateInvoice(@PathVariable("id") long id, @RequestBody Factura factura) {
		logger.info("Updating Factura with id {}", id);

		factura.setId(id);
		Factura currentInvoice = facturaService.updateFactura(factura);

		if (currentInvoice == null) {
			logger.error("Unable to update. Invoice with id {} not found.", id);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(currentInvoice);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Factura> deleteInvoice(@PathVariable("id") long id) {
		logger.info("Factura & Deleting Invoice with id {}", id);

		Factura factura = facturaService.getFactura(id);
		if (factura == null) {
			logger.error("Unable to delete. Factura with id {} not found.", id);
			return ResponseEntity.notFound().build();
		}
		factura = facturaService.deleteFactura(factura);
		return ResponseEntity.ok(factura);
	}

}
