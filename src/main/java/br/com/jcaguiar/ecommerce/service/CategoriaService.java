package br.com.jcaguiar.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.Console;
import br.com.jcaguiar.ecommerce.model.Categoria;
import br.com.jcaguiar.ecommerce.model.Setor;
import br.com.jcaguiar.ecommerce.projection.MasterGET;
import br.com.jcaguiar.ecommerce.repository.CategoriaRepository;

@Service
public class CategoriaService extends MasterService<Categoria, Short> {

	public CategoriaService(CategoriaRepository jpaRepo) {
		super(jpaRepo);
	}

	@Override
	public List<? extends MasterGET> findTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterGET> findTodos(Sort ordene) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterGET> findTodosAdm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterGET> findTodosAdm(Sort ordene) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterGET findId(Short id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterGET findIdAdm(Short id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterGET findEntidade(Categoria entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterGET findEntidadeAdm(Categoria entidade) {
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
