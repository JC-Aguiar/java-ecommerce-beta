package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Endereco;
import br.com.jcaguiar.ecommerce.repository.EnderecoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnderecoService {
	
	@Autowired
	private final EnderecoRepository enderecoRepo;

	public Endereco salvar(Endereco endereco) {
		return enderecoRepo.save(endereco);
	}
	
	public Optional<Endereco> findById(int id) {
		return enderecoRepo.findById(id);
	}
	
	public List<Endereco> findAll(Sort ordene) {
		return enderecoRepo.findAll(ordene);
	}
	
	public List<Endereco> findByNameContaining(String nome, Sort ordene) {
		return enderecoRepo.findByNomeContaining(nome, ordene);
	}
}
