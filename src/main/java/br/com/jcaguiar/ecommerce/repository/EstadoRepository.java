package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Short> {
	
	Estado findBySiglaEquals(String sigla, Sort ordene);
	
	List<Estado> findBySiglaContaining(String sigla, Sort ordene);
	
	List<Estado> findByNomeContaining(String nome, Sort ordene);
	
}
