package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class MasterService<OBJ, ID> {

	private JpaRepository<OBJ, ID> jpaRepo;
	
	public MasterService(JpaRepository<OBJ, ID> jpaRepo) {
		this.jpaRepo = jpaRepo; 
	}
	
	public OBJ salvar(OBJ objeto) {
		return jpaRepo.save(objeto);
	}
	
	public List<OBJ> saveAll(Iterable<OBJ> objetos) {
		return jpaRepo.saveAll(objetos);
	}
	
	public OBJ findOne(ID id) {
		return jpaRepo.getOne(id);
	}
	
	public Optional<OBJ> findById(ID id) {
		return jpaRepo.findById(id);
	}
	
	public abstract Optional<OBJ> findByIdLimited(ID id);
	
	public List<OBJ> findAllById(Iterable<ID> id) {
		return jpaRepo.findAllById(id);
	}
	
	public List<OBJ> findAllById(Iterable<ID> id, Sort ordene) {
		return jpaRepo.findAllById(id);
	}
	
	public List<OBJ> findAll() {
		return jpaRepo.findAll();
	}
	
	public List<OBJ> findAll(Sort ordene) {
		return jpaRepo.findAll(ordene);
	}
	
	public abstract List<OBJ> findAllLimited();
	
	public abstract List<OBJ> findByNome(String nome);

	public abstract List<OBJ> findByNomeContaining(String nome);

	public abstract List<OBJ> findByNomeContainingLimited(String nome);

}
