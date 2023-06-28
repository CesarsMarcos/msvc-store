package com.store.oauth.models.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.store.oauth.feign.UsuarioFeign;
import com.store.oauth.models.entity.Usuario;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

	private final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

	private final UsuarioFeign usuarioClient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioClient.usuarioPorUserName(username).getBody();

		if (usuario == null) {
			logger.error("Error en login, nos existe el usuario '" + username + "' en el sistema");
			throw new UsernameNotFoundException(
					"Error en login, nos existe el usuario '" + username + "' en el sistema");
		}

		SimpleGrantedAuthority rol = new SimpleGrantedAuthority(usuario.getRol().getDesRol());
		List<GrantedAuthority> authorities = Arrays.asList(rol);

		logger.info("Usuario '" + username + "' autenticado ");

		return new User(usuario.getUsuario(), usuario.getPassword(), true, true, true, true, authorities);
	}

}
