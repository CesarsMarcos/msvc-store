package com.store.oauth.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.store.oauth.feign.UsuarioFeign;
import com.store.oauth.models.entity.Usuario;
import com.store.oauth.models.service.UsuarioService;

import feign.FeignException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher {

	private final static Logger logger = LoggerFactory.getLogger(AuthenticationSuccessErrorHandler.class);
	
	private final UsuarioFeign usuarioService;
	

	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		
		if (authentication.getDetails() instanceof WebAuthenticationDetails) {
			return;
		}
		/*UserDetails user = (UserDetails) authentication.getPrincipal();
		String mensaje = "Success login: "+user.getUsername();
		logger.info(mensaje);*/
		
		String username = authentication.getName();
		//UserDetails authUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String mensaje = "Success login: "+username;
		logger.info(mensaje);
		
		
		Usuario usuario =  usuarioService.usuarioPorUserName(authentication.getName()).getBody();
		if(usuario.getIntentos() != null && usuario.getIntentos() > 0) {
			usuario.setIntentos(0);
			//usuarioService.modiciar(usuario, usuario.getIdUsuario());
		}
		
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {

		String mensaje = "Error en el login: " + exception.getMessage();
		logger.error(mensaje);
		
		try {
			Usuario usuario =  usuarioService.usuarioPorUserName(authentication.getName()).getBody();
			
			if(usuario.getIntentos() == null) {
				usuario.setIntentos(0);
			}
			
			usuario.setIntentos(usuario.getIntentos() +1);
			
			if(usuario.getIntentos() >= 3) {
				usuario.setIndBaja("S");
			}
			
			
			//usuarioService.modiciar(usuario, usuario.getIdUsuario());
			
		} catch (FeignException e) {
			// TODO: handle exception
		}
		

	}

}
