package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

	List<Endereco> findByRuaContaining(String rua, Sort ordene);

	List<Endereco> findByBairroContaining(String bairro, Sort ordene);

	List<Endereco> findByCepContaining(String cep, Sort ordene);
	
}
