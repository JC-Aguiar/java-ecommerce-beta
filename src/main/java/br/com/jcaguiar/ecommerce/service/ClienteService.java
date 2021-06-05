package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.dto.ClienteLimitadoDto;
import br.com.jcaguiar.ecommerce.model.Cliente;
import br.com.jcaguiar.ecommerce.projection.ClientesInfoLimitada;
import br.com.jcaguiar.ecommerce.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRep;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRep) {
		this.clienteRep = clienteRep;
	}
	
	public Cliente salvar(Cliente cliente) {
		return clienteRep.save(cliente);
	}
	
	public Optional<Cliente> findById(int id) {
		return clienteRep.findById(id);
	}
	
	public List<Cliente> findAll(Sort ordene) {
		return clienteRep.findAll(ordene);
	}
	
	public List<Cliente> findByNameContaining(String nome, Sort ordene) {
		return clienteRep.findByNomeContaining(nome, ordene);
	}
	
	//ClienteInfoLimitada ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	
	public ClientesInfoLimitada findByIdLimited(int id) {
		return clienteRep.findByIdLimited(id);
	}
	
	public List<ClientesInfoLimitada> findAllLimited(Sort ordene) {
		return clienteRep.findAllLimited();
	}

	public List<ClientesInfoLimitada> findByNameContainingLimited(String name) {
		return clienteRep.findByNameContainingLimited(name);
	}
	
}
