package com.store.oauth.models.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class Usuario implements Serializable {

	private Long idUsuario;

	private Rol rol;

	private Usuario usuRegistro;

	private Usuario usuActualizacion;

	private String nombres;

	private String apellidos;

	private String usuario;

	private String codEmpresa;

	private String correoEmpresa;

	private String correoPersonal;

	private String password;

	private String indBaja;

	private LocalDateTime fecRegistro;

	private LocalDateTime fecActualizacion;

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4539580713021737197L;

}