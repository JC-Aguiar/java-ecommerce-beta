package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Cidade;
import br.com.jcaguiar.ecommerce.model.Cliente;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	List<Cliente> findByNameContaining(String nome, Sort ordene);
	
}
