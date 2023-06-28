package com.store.oauth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.store.oauth.models.entity.Usuario;

@FeignClient(name = "svc-usuarios", path = "usuarios")
public interface UsuarioFeign {

	@GetMapping("/{userName}")
	public ResponseEntity<Usuario> usuarioPorUserName(@PathVariable String userName);

}
