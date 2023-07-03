package com.store.usuarios.model.service;

import java.util.List;

import com.store.usuarios.model.entity.Usuario;
public interface IUsuarioService {

	public Usuario registrar(Usuario usuario);

	public Usuario modificar(String userName, Usuario usuario);

	public Usuario obtenerPorId(Long idUsuario);

	public List<Usuario> usuariosActivos();

	public List<Usuario> usuariosNoEspecialistas();

	public void eliminar(Long idUsuario);
	
	public Usuario obtenerPorUsuario(String userName);

}
