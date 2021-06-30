package br.com.jcaguiar.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.ImagemProduto;
import br.com.jcaguiar.ecommerce.projection.MasterVO;
import br.com.jcaguiar.ecommerce.repository.ImagemProdutoRepository;

@Service
public final class ImagemProdutoService extends MasterService<ImagemProduto, Long> {

	public ImagemProdutoService(ImagemProdutoRepository jpaRepo) {
		super(jpaRepo);
	}

	@Override
	public List<? extends MasterVO> findTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterVO> findTodos(Sort ordene) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterVO> findTodosAdm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterVO> findTodosAdm(Sort ordene) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findIdAdm(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findEntidade(ImagemProduto entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findEntidadeAdm(ImagemProduto entidade) {
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
