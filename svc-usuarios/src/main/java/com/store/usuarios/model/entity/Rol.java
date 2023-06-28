package com.store.usuarios.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Entity 
@Table(name = "TB_ROLES")
public @Data class Rol implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROL")
	private Long idRol;

	@Column(unique = true, name = "DES_ROL")
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
