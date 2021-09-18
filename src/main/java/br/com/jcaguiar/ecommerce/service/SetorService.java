package br.com.jcaguiar.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.Console;
import br.com.jcaguiar.ecommerce.model.Setor;
import br.com.jcaguiar.ecommerce.projection.MasterVO;
import br.com.jcaguiar.ecommerce.repository.SetorRepository;

@Service
public class SetorService extends MasterService<Setor, Short> {

	public SetorService(SetorRepository jpaRepo) {
		super(jpaRepo);
	}
	
	public Setor validarByNome(String nome) {
		Console.log("<SETOR-SERVICE>", +1);
		List<Setor> setores = findObjectByNome(nome);
		Setor setor;
		if( setores.size() == 0 ) {
			setor = Setor.builder()
					.nome(nome)
					.build();
			Console.log(String.format("Novo Setor criado: %s", nome));
		}
		else {
			setor = setores.get(0);
			Console.log(String.format("Setor %s Identificado", nome));
		}
		Console.log("</SETOR-SERVICE>", -1);
		return setor;
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
	public MasterVO findEntidade(Setor entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findEntidadeAdm(Setor entidade) {
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
	

	public List<Setor> findObjectByNome(String nome) {
		return ((SetorRepository) JPA_REPO).findAllByNomeContaining(nome);
	}


	public List<Setor> findSetorByNomeAdm(String nome) {
		
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
