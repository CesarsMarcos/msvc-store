package com.store.venta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	
	private Long id;
	
	private String documento;
	
	private String nombre;
	
	private String apellidos;
	
	private String email;

	private String urlFoto;
	

	private Region region;
	
	private String estado;

}
