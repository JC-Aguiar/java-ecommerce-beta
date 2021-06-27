package br.com.jcaguiar.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.repository.MasterRepository;

@Service
public abstract class MasterService<OBJ, ID, VO, VO_BASIC> {

	protected final MasterRepository<OBJ, ID,  VO, VO_BASIC> JPA_REPO;
	protected final List<Object> DTO = new ArrayList<>();
	
	public MasterService(MasterRepository<OBJ, ID, VO, VO_BASIC> jpaRepo) {
		this.JPA_REPO = jpaRepo; 
	}
	
	//SALVAR ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public Object salvar(OBJ objeto) {
		return JPA_REPO.save(objeto);
	}
	
	public List<?> saveAll(Iterable<OBJ> objetos) {
		return JPA_REPO.saveAll(objetos);
	}
	
	//BUSQUE TODOS ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public List<?> findAll() {
		return JPA_REPO.findAll();
	}
	
	public List<?> findAll(Sort ordene) {
		return JPA_REPO.findAll();
	}
	
	public abstract List<?> findAllBasic();
	
	public abstract List<?> findAllBasic(Sort ordene);
	
	//BUSQUE POR ID ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public Object findOne(ID id) {
		return JPA_REPO.getOne(id);
	}
	
	public Optional<?> findById(ID id) {
		return JPA_REPO.findById(id);
	}
	
	public abstract Object findOneBasic(ID id);
	
	public abstract Optional<?> findByIdBasic(ID id);
	
	//BUSQUE POR NOME ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public abstract List<?> findByNome(String nome);

	public abstract List<?> findByNomeContaining(String nome);
	
	public abstract List<?> findByNomeBasic(String nome);

	public abstract List<?> findByNomeContainingBasic(String nome);

}
