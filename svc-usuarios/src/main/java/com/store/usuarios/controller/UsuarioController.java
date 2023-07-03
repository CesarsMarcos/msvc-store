package com.store.usuarios.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.usuarios.model.entity.Usuario;
import com.store.usuarios.model.service.IUsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	private final IUsuarioService usuarioService;
	
	@GetMapping("/{userName}")
	public ResponseEntity<Usuario> usuarioPorUserName(@PathVariable String userName){
		Usuario usuario = usuarioService.obtenerPorUsuario(userName);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@PutMapping("/{userName}")
	public ResponseEntity<Usuario> modificarUsuarioPorUserName(@PathVariable String userName){
		Usuario usuario = usuarioService.obtenerPorUsuario(userName);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
}


