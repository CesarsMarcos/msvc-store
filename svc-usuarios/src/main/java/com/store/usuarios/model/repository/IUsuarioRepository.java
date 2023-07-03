package com.store.usuarios.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.store.usuarios.model.entity.Usuario;

public interface IUsuarioRepository  extends JpaRepository<Usuario, Long>{
	
	@Query("SELECT u FROM Usuario u WHERE u.indBaja ='N' AND u.rol.idRol <> 3")
	List<Usuario> usuarioNoEspecialistas();
	
	@Query("SELECT u FROM Usuario u WHERE u.indBaja ='N'")
	List<Usuario> usuariosActivos();
	
	Optional<Usuario> findByUsuario(String username);
	
}
