package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class MasterService<T, ID> {

	private JpaRepository<T, ID> jpaRepo;
	
	public MasterService(JpaRepository<T, ID> jpaRepo) {
		this.jpaRepo = jpaRepo; 
	}
	
	public T salvar(T objeto) {
		return jpaRepo.save(objeto);
	}
	
	public List<T> saveAll(Iterable<T> objetos) {
		return jpaRepo.saveAll(objetos);
	}
	
	public T findOne(ID id) {
		return jpaRepo.getOne(id);
	}
	
	public Optional<T> findById(ID id) {
		return jpaRepo.findById(id);
	}
	
	public abstract Optional<T> findByIdLimited(ID id);
	
	public List<T> findAllById(Iterable<ID> id) {
		return jpaRepo.findAllById(id);
	}
	
	public List<T> findAllById(Iterable<ID> id, Sort ordene) {
		return jpaRepo.findAllById(id);
	}
	
	public List<T> findAll() {
		return jpaRepo.findAll();
	}
	
	public List<T> findAll(Sort ordene) {
		return jpaRepo.findAll(ordene);
	}
	
	public abstract List<T> findAllLimited();

	public abstract List<T> findByNomeContaining(String nome);

	public abstract List<T> findByNomeContainingLimited(String nome);

}
