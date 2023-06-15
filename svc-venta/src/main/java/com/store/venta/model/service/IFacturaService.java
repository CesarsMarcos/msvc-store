package com.store.venta.model.service;

import java.util.List;

import com.store.venta.model.entity.Factura;

public interface IFacturaService {

	public List<Factura> findFacturaAll();

	public Factura crearFactura(Factura factura);

	public Factura updateFactura(Factura factura);

	public Factura deleteFactura(Factura factura);

	public Factura getFactura(Long id);

}
