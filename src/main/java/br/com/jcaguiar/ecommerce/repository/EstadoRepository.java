package br.com.jcaguiar.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	
	Estado findBySiglaEquals(String sigla);
	
}
