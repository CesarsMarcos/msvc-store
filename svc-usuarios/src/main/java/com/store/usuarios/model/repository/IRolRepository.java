package com.store.usuarios.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.usuarios.model.entity.Rol;

public interface IRolRepository extends JpaRepository<Rol, Long>{

}
