package com.store.oauth.models.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class Rol implements Serializable {

	
	private Long idRol;

	private String desRol;

	public Rol(Long idRol) {
		super();
		this.idRol = idRol;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = -4700636165751120866L;


}
