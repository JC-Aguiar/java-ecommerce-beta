package br.com.jcaguiar.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.Console;
import br.com.jcaguiar.ecommerce.model.Categoria;
import br.com.jcaguiar.ecommerce.model.Setor;
import br.com.jcaguiar.ecommerce.projection.MasterVO;
import br.com.jcaguiar.ecommerce.repository.CategoriaRepository;

@Service
public class CategoriaService extends MasterService<Categoria, Short> {

	public CategoriaService(CategoriaRepository jpaRepo) {
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
	public MasterVO findId(Short id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findIdAdm(Short id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findEntidade(Categoria entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findEntidadeAdm(Categoria entidade) {
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

	public Categoria validarByNome(Setor setor, String nomeCategoria) {
		Console.log("<CATEGORIA-SERVICE>", +1);
		List<Categoria> categorias = findCategoriaBySetorAndNome(setor, nomeCategoria);
		Categoria categoria;
		if( categorias.size() == 0 ) {
			categoria = Categoria.builder()
					.setor(setor)
					.nome(nomeCategoria)
					.build();
			Console.log(String.format(
					"Nova Categoria criada: %s [Setor %s]",
					nomeCategoria, setor.getNome()
			));
		}
		else {
			categoria = categorias.get(0);
			Console.log(String.format(
					"Categoria %s Identificada",
					nomeCategoria
			));
		}
		Console.log("<CATEGORIA-SERVICE>", -1);
		return categoria;
	}
	
	public List<Categoria> findCategoriaBySetorAndNome(Setor setor, String nomeCategoria) {
		return ((CategoriaRepository) JPA_REPO).findAllBySetorAndNomeContaining(setor, nomeCategoria);
	}

}
