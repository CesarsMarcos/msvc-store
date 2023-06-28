package com.store.clientes.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.clientes.model.entity.Cliente;
import com.store.clientes.model.entity.Region;
import com.store.clientes.model.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements IClienteService {

	private final ClienteRepository clienteRepo;

	@Override
	public List<Cliente> clientes() {
		return clienteRepo.findAll();
	}

	@Override
	public Cliente clientePorId(Long id) {
		return clienteRepo.findById(id).get();
	}

	@Override
	public Cliente update(Cliente cliente) {
		return clienteRepo.save(cliente);
	}

	@Override
	public void eliminar(Long id) {
		clienteRepo.deleteById(id);
	}

	@Override
	public List<Cliente> findByRegion(Region region) {
		return findByRegion(region);
	}

	@Override
	public Cliente getRegion(Long id) {
		return null;
	}

	@Override
	public Cliente registro(Cliente cliente) {
		return clienteRepo.save(cliente);
	}

}
