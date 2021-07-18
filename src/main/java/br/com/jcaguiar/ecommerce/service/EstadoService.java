package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Estado;
import br.com.jcaguiar.ecommerce.repository.EstadoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstadoService {

	@Autowired
	private final EstadoRepository estadoRepo;
	
	@CacheEvict(value = "estados")
	public Estado salvar(Estado estado) {
		return estadoRepo.save(estado);
	}
	
	public Optional<Estado> findById(Short id) {
		return estadoRepo.findById(id);
	}
	
	public List<Estado> findAll(Sort ordene) {
		return estadoRepo.findAll(ordene);
	}
	
	public List<Estado> findByNomeContaining(String nome, Sort ordene) {
		return estadoRepo.findByNomeContaining(nome, ordene);
	}
	
}
