package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class MasterService<OBJ, ID> {

	protected final JpaRepository<OBJ, ID> JPA_REPO;
	
	public MasterService(JpaRepository<OBJ, ID> jpaRepo) {
		this.JPA_REPO = jpaRepo; 
	}
	
	public OBJ salvar(OBJ objeto) {
		return JPA_REPO.save(objeto);
	}
	
	public List<OBJ> saveAll(Iterable<OBJ> objetos) {
		return JPA_REPO.saveAll(objetos);
	}
	
	public OBJ findOne(ID id) {
		return JPA_REPO.getOne(id);
	}
	
	public Optional<OBJ> findById(ID id) {
		return JPA_REPO.findById(id);
	}
	
	public abstract Optional<?> findByIdLimited(ID id);
	
	public List<OBJ> findAllById(Iterable<ID> id) {
		return JPA_REPO.findAllById(id);
	}
	
	public List<OBJ> findAllById(Iterable<ID> id, Sort ordene) {
		return JPA_REPO.findAllById(id);
	}
	
	public List<OBJ> findAll() {
		return JPA_REPO.findAll();
	}
	
	public List<OBJ> findAll(Sort ordene) {
		return JPA_REPO.findAll(ordene);
	}
	
	public abstract List<?> findAllLimited();
	
	public abstract List<?> findByNome(String nome);

	public abstract List<?> findByNomeContaining(String nome);

	public abstract List<?> findByNomeContainingLimited(String nome);

}
