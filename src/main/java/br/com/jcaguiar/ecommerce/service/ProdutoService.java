package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Produto;
import br.com.jcaguiar.ecommerce.projection.ProdutoAdmReport;
import br.com.jcaguiar.ecommerce.projection.ProdutoUserReport;
import br.com.jcaguiar.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService extends MasterService<Produto, Integer> {
	
	public ProdutoService(ProdutoRepository jpaRepo) {
		super(jpaRepo);
	}

	@Override
	@Cacheable("ProdutoUser")
	public List<ProdutoUserReport> findAllBasic() {
		return ((ProdutoRepository) JPA_REPO).findTodosUser();
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
	public List<Produto> findByNomeContainingBasic(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Cacheable("ProdutoAdm")
	public List<ProdutoAdmReport> findAll() {
		return ((ProdutoRepository) JPA_REPO).findTodosAdm();
	}

	@Override
	public List<?> findAllBasic(Sort ordene) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findOneBasic(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<?> findByIdBasic(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> findByNomeBasic(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
