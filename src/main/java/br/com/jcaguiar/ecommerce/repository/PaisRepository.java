package br.com.jcaguiar.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {
	
	
	//@PersistenceContext
	//public EntityManager gerente;
	
	Pais findByNomeEquals(String nome);
	
}
