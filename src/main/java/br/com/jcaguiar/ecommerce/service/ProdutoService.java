package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Categoria;
import br.com.jcaguiar.ecommerce.model.Produto;
import br.com.jcaguiar.ecommerce.projection.ProdutoDtoReport;
import br.com.jcaguiar.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService extends MasterService<Produto, Integer> {
	
	public ProdutoService(ProdutoRepository jpaRepo) {
		super(jpaRepo);
	}

	public List<Produto> findByNomeContaining(String nome, Sort ordene) {
		return ((ProdutoRepository) JPA_REPO).findByNomeContaining(nome, ordene);
	}
	
	public List<Produto> findByDescricaoContaining(String descricao, Sort ordene) {
		return ((ProdutoRepository) JPA_REPO).findByDescricaoContaining(descricao, ordene);
	}
	
	public List<Produto> findByModeloContaining(String modelo, Sort ordene) {
		return ((ProdutoRepository) JPA_REPO).findByModeloContaining(modelo, ordene);
	}
	
	public List<Produto> findByCategoriaContaining(Categoria categoria, Sort ordene) {
		return ((ProdutoRepository) JPA_REPO).findByCategoriaContaining(categoria, ordene);
	}

	
	@Override
	public Optional<Produto> findByIdLimited(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdutoDtoReport> findAllLimited() {
		return ((ProdutoRepository) JPA_REPO).findAllLimited();
	}

	@Override
	public List<Produto> findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> findByNomeContaining(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> findByNomeContainingLimited(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
