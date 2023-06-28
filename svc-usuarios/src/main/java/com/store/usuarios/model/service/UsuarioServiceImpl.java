package com.store.usuarios.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.store.usuarios.model.entity.Usuario;
import com.store.usuarios.model.repository.IUsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {

	private final static Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	private final IUsuarioRepository usuarioRepo;

	@Override
	public Usuario registrar(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtenerPorId(Long idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> usuariosActivos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> usuariosNoEspecialistas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long idUsuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario obtenerPorUsuario(String userName) {
		Usuario usuarioSave = usuarioRepo.findByUsuario(userName);
		
		if(usuarioSave == null) {
			logger.error("El usuario '"+userName+"' no existe ");
		}
		
		return usuarioSave;
	}

}
