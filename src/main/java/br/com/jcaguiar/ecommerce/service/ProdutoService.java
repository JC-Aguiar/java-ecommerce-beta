package br.com.jcaguiar.ecommerce.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Produto;
import br.com.jcaguiar.ecommerce.projection.MasterVO;
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
	public List<ProdutoUserReport> findTodos() {
		return ((ProdutoRepository) JPA_REPO).findTodos();
	}

	@Cacheable("ProdutoAdm")
	public List<ProdutoAdmReport> findTodosAdm() {
		return ((ProdutoRepository) JPA_REPO).findTodosAdm();
	}

	@Override
	public List<? extends MasterVO> findTodos(Sort ordene) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterVO> findTodosAdm(Sort ordene) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findIdAdm(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findEntidade(Produto entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findEntidadeAdm(Produto entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterVO> findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterVO> findByNomeAdm(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterVO> findByNomeContaining(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterVO> findByNomeContainingAdm(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
