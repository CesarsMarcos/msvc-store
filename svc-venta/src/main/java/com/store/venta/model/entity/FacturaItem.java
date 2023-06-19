package com.store.venta.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.store.venta.model.Producto;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_factura_items")
public class FacturaItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer cantidad;
	
	private Double precio;

	@Column(name = "producto_id")
	private Long productoId;

	@Transient
	private Double subTotal;

	@Transient
	private Producto producto;

	public Double getSubTotal() {
		if (this.precio > 0 && this.cantidad > 0) {
			return this.cantidad * this.precio;
		} else {
			return (double) 0;
		}
	}

	public FacturaItem() {
		this.cantidad = (int) 0;
		this.precio = (double) 0;

	}

}
