package com.store.venta.model;

import java.util.Date;
import lombok.Data;

@Data
public class Producto {

	private Long id;

	private String nombre;

	private String descripcion;

	private Integer stock;

	private Double precio;

	private String estado;

	private Date creatAt;

	private Categoria categoria;

}
