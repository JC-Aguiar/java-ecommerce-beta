package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Cliente;
import br.com.jcaguiar.ecommerce.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

	List<Endereco> findByRuaContaining(String rua, Sort ordene);

	List<Endereco> findByBairroContaining(String bairro, Sort ordene);

	List<Endereco> findByCepContaining(String cep, Sort ordene);
	
	@Query("SELECT e FROM endereco e, cliente c WHERE c.endereco = e AND c = ?1")
	Endereco findEnderecoCliente(Cliente cliente);
	
	@Query("SELECT e FROM endereco e, cliente c WHERE c.endereco = e AND c.id = ?1")
	Endereco findEnderecoClienteId(int clienteId);
	
	@Query("SELECT e FROM endereco e, cliente c WHERE c.endereco = e AND c = ?1")
	List<Endereco> findOutrosEnderecosCliente(Cliente cliente);
	
	@Query("SELECT e FROM endereco e, cliente c WHERE c.endereco = e AND c.id = ?1")
	List<Endereco> findOutrosEnderecosClienteId(int clienteId);
	
}
