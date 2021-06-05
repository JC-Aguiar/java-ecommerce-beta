package br.com.jcaguiar.ecommerce.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Cliente;
import br.com.jcaguiar.ecommerce.model.Endereco;
import br.com.jcaguiar.ecommerce.model.Usuario;
import br.com.jcaguiar.ecommerce.projection.ClientesInfoLimitada;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	//@Query("SELECT c.nome, c.sobrenome, c.idade, c.usuario.email FROM cliente c")
	@Query("SELECT  c.nome, c.sobrenome, c.cpf, c.phone, c.usuario FROM cliente c")
	List<ClientesInfoLimitada> findAllLimited();
	
	@Query("SELECT c.nome, c.sobrenome, c.idade, u.email, c.endereco FROM usuario u, cliente c WHERE u.id = :id AND u.id = c.usuario")
	Cliente findByIdLimited(int id, Sort sort);
	
	List<Cliente> findByUsuario(Usuario usuario, Sort sort);
	
	List<Cliente> findByNomeContaining(String nome, Sort sort);
	
	List<Cliente> findBySobrenomeContaining(String sobrenome, Sort sort);
	
	List<Cliente> findByCpfContaining(String cpf, Sort sort);
	
	List<Cliente> findByEndereco(Endereco endereco, Sort sort);

}
