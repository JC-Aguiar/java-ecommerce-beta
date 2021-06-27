package br.com.jcaguiar.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.projection.MasterVO;
import br.com.jcaguiar.ecommerce.repository.MasterRepository;

@Service
public abstract class MasterService<OBJ, ID> {

	protected final MasterRepository<OBJ, ID> JPA_REPO;
	protected final List<Object> DTO = new ArrayList<>();
	
	public MasterService(MasterRepository<OBJ, ID> jpaRepo) {
		this.JPA_REPO = jpaRepo; 
	}
	
	//SALVAR ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public OBJ salvar(OBJ objeto) {
		return JPA_REPO.save(objeto);
	}
	
	public List<OBJ> saveAll(Iterable<OBJ> objetos) {
		return JPA_REPO.saveAll(objetos);
	}
	
	//BUSQUE TODOS ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public List<OBJ> findAll() {
		return JPA_REPO.findAll();
	}
	
	public List<OBJ> findAll(Sort ordene) {
		return JPA_REPO.findAll();
	}
	
	public abstract List<? extends MasterVO> findTodos();
	
	public abstract List<? extends MasterVO> findTodos(Sort ordene);
	
	public abstract List<? extends MasterVO> findTodosAdm();
	
	public abstract List<? extends MasterVO> findTodosAdm(Sort ordene);
	
	//BUSQUE POR ID ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public OBJ findOne(ID id) {
		return JPA_REPO.getOne(id);
	}
	
	public Optional<OBJ> findById(ID id) {
		return JPA_REPO.findById(id);
	}
	
	public abstract MasterVO findId(ID id);
	
	public abstract MasterVO findIdAdm(ID id);
	
	public abstract MasterVO findEntidade(OBJ entidade);
	
	public abstract MasterVO findEntidadeAdm(OBJ entidade);
	
	//BUSQUE POR NOME ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public abstract List<? extends MasterVO> findByNome(String nome);

	public abstract List<? extends MasterVO> findByNomeAdm(String nome);
	
	public abstract List<? extends MasterVO> findByNomeContaining(String nome);

	public abstract List<? extends MasterVO> findByNomeContainingAdm(String nome);

}
