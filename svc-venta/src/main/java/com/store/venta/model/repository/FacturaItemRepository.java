package com.store.venta.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.venta.model.entity.FacturaItem;

public interface FacturaItemRepository extends JpaRepository<FacturaItem, Long> {

	
	
}
