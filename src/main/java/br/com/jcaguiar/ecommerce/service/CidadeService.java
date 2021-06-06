package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Cidade;
import br.com.jcaguiar.ecommerce.model.Cliente;
import br.com.jcaguiar.ecommerce.repository.CidadeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CidadeService {
	
	@Autowired
	private final CidadeRepository cidadeRepo;
	
	
	public Cidade salvar(Cidade cidade) {
		return cidadeRepo.save(cidade);
	}
	
	public Optional<Cidade> findById(int id) {
		return cidadeRepo.findById(id);
	}
	
	public List<Cidade> findAll(Sort ordene) {
		return cidadeRepo.findAll(ordene);
	}

	public List<Cidade> findByNomeContaining(String nome, Sort ordene) {
		return cidadeRepo.findByNomeContaining(nome, ordene);
	}
	

}
