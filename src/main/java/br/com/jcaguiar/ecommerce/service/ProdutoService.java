package br.com.jcaguiar.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Produto;
import br.com.jcaguiar.ecommerce.projection.MasterGET;
import br.com.jcaguiar.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService extends MasterService<Produto, Integer> {
	
	public ProdutoService(ProdutoRepository jpaRepo) {
		super(jpaRepo);
	}
	

//	@Cacheable("ProdutoUser")
//	public List<ProdutoUserGET> findTodosUser() {
//		Console.log("<PRODUTO-SERVICE>", +1);
//		Console.log("Coletando produtos");
//		List<Produto> produtos = ((ProdutoRepository) JPA_REPO).findAll();
//		List<ProdutoUserGET> produtosGET = new ArrayList<>();
//		Console.log("Convertendo dados da resposta");
//		for(Produto prd : produtos) {
//			produtosGET.add( ProdutoUserGET.of(prd) );
//		}
//		Console.log("</PRODUTO-SERVICE>", -1);
//		return produtosGET;
//	}
//
//	@Cacheable("ProdutoAdm")
//	public List<ProdutoAdmGET> findTodosAdm() {
//		Console.log("<PRODUTO-SERVICE>", +1);
//		Console.log("Coletando produtos");
//		List<Produto> produtos = ((ProdutoRepository) JPA_REPO).findAll();
//		List<ProdutoAdmGET> produtosGET = new ArrayList<>();
//		Console.log("Convertendo dados da resposta");
//		for(Produto prd : produtos) {
//			produtosGET.add( ProdutoAdmGET.of(prd) );
//		}
//		Console.log("</PRODUTO-SERVICE>", -1);
//		return produtosGET;
//	}

	@Override
	public List<? extends MasterGET> findTodos(Sort ordene) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterGET> findTodosAdm(Sort ordene) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterGET findId(Integer id) {
		return ((ProdutoRepository) JPA_REPO).findByIdLimited(id);
	}

	@Override
	public MasterGET findIdAdm(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterGET findEntidade(Produto entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterGET findEntidadeAdm(Produto entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterGET> findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterGET> findByNomeAdm(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterGET> findByNomeContaining(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterGET> findByNomeContainingAdm(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void removeAll() {
		((ProdutoRepository) JPA_REPO).deleteAll();
	}


	@Override
	public List<? extends MasterGET> findTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
