package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Setor;

@Repository
public interface SetorRepository extends MasterRepository<Setor, Short> {
	
	List<Setor> findAllByNomeContaining(String nome);
	
}
