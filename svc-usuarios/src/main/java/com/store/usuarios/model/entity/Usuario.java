package com.store.usuarios.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_USUARIOS")
public @Data class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Long idUsuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_ROL", foreignKey = @ForeignKey(name = "FK_USUARIO_ROL"))
	private Rol rol;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COD_USUARIO_REGISTRO", foreignKey = @ForeignKey(name = "FK_USUARIO_USUARIO_REG"))
	private Usuario usuRegistro;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COD_USUARIO_ACTUALIZACION", foreignKey = @ForeignKey(name = "FK_USUARIO_USUARIO_MOD"))
	private Usuario usuActualizacion;

	//@NotNull(message = "los nombres no puede estar vacio")
	@Column(name = "NOMBRES")
	private String nombres;

	//@NotNull(message = "los apellidos no puede estar vacio")
	@Column(name = "APELLIDOS")
	private String apellidos;

	//@NotNull(message = "el usuario no puede estar vacio")
	@Column(name = "USUARIO")
	private String usuario;

	//@NotNull(message = "el  código de empresa no puede estar vacio")
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;

	//@NotNull(message = "el  código de empresa no puede estar vacio")
	@Column(name = "CORREO_EMPRESA")
	private String correoEmpresa;

	@Column(name = "CORREO_PERSONAL")
	private String correoPersonal;

	//@NotNull(message = "el  password de empresa no puede estar vacio")
	@Column(name = "PASSWORD")
	private String password;
	
	private Integer intentos;
	
	@Column(name = "IND_BAJA")
	private String indBaja;

	@Column(name = "FEC_REGISTRO")
	private LocalDateTime fecRegistro;

	@Column(name = "FEC_ACTUALIZACION")
	private LocalDateTime fecActualizacion;

	@PrePersist
	protected void onCreate() {
		fecRegistro = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		fecActualizacion = LocalDateTime.now();
	}

	public String getNombreCompleto() {
		return this.getNombres() + " " + this.getApellidos();
	}

	public Usuario(Long idUsuario) {
		super();
		this.idUsuario = idUsuario;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 4539580713021737197L;

}