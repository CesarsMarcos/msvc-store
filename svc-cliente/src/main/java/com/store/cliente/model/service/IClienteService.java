package com.store.cliente.model.service;

import java.util.List;

import com.store.cliente.model.entity.Cliente;
import com.store.cliente.model.entity.Region;

public interface IClienteService {

	List<Cliente> clientes();

	Cliente clientePorId(Long id);

	Cliente update(Cliente cliente);

	void eliminar(Long id);

	List<Cliente> findByRegion(Region build);

	Cliente getRegion(Long id);

	Cliente registro(Cliente cliente);


}
