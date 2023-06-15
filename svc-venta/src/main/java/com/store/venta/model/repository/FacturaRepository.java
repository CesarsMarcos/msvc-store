package com.store.venta.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.venta.model.entity.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

	public List<Factura> findByClienteId(Long clienteId);

	public Factura findByNumeroFactura(String numeroFactura);

}
