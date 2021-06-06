package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Categoria;
import br.com.jcaguiar.ecommerce.model.Produto;
import br.com.jcaguiar.ecommerce.projection.ProdutoReport;
import br.com.jcaguiar.ecommerce.repository.ProdutoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProdutoService {

	private final ProdutoRepository PRODUTO_REPO;

	public Produto salvar(Produto produto) {
		return PRODUTO_REPO.save(produto);
	}
	
	public Optional<Produto> findById(int id) {
		return PRODUTO_REPO.findById(id);
	}
	
	public List<Produto> findAll(Sort ordene) {
		return PRODUTO_REPO.findAll(ordene);
	}
	
	public List<Produto> findByNomeContaining(String nome, Sort ordene) {
		return PRODUTO_REPO.findByNomeContaining(nome, ordene);
	}
	
	public List<Produto> findByDescricaoContaining(String descricao, Sort ordene) {
		return PRODUTO_REPO.findByDescricaoContaining(descricao, ordene);
	}
	
	public List<Produto> findByModeloContaining(String modelo, Sort ordene) {
		return PRODUTO_REPO.findByModeloContaining(modelo, ordene);
	}
	
	public List<Produto> findByCategoriaContaining(Categoria categoria, Sort ordene) {
		return PRODUTO_REPO.findByCategoriaContaining(categoria, ordene);
	}

	//ProdutoReport :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public List<ProdutoReport> findAllLimited(Sort ordene) {
		return PRODUTO_REPO.findAllLimited();
	}

	public ProdutoReport findByIdLimited(int id) {
		return PRODUTO_REPO.findByIdLimited(id);
	}

	public List<ProdutoReport> findByNomeContainingLimited(String nome) {
		return PRODUTO_REPO.findByNomeContainingLimited(nome);
	}
}
