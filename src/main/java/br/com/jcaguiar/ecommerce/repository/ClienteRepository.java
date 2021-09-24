package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Cliente;
import br.com.jcaguiar.ecommerce.model.Endereco;
import br.com.jcaguiar.ecommerce.projection.ClientesGET;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	//List<Cliente> findByUsuario(Usuario usuario, Sort sort);
	
	List<Cliente> findByNomeContaining(String nome, Sort sort);
	
	List<Cliente> findBySobrenomeContaining(String sobrenome, Sort sort);
	
	List<Cliente> findByCpfContaining(String cpf, Sort sort);
	
	List<Cliente> findByEndereco(Endereco endereco, Sort sort);

	@Query(nativeQuery = true,
			value = "SELECT  c.nome, c.sobrenome, c.cpf, c.phone, u.email "
					+ "FROM cliente c, usuario u "
					+ "WHERE c.id = ?1 AND u.id = c.usuario_id")
	ClientesGET findByIdLimited(int id);
	
	@Query(nativeQuery = true,
			value = "SELECT  c.nome, c.sobrenome, c.cpf, c.phone, u.email "
					+ "FROM cliente c, usuario u "
					+ "WHERE u.id = c.usuario_id")
	List<ClientesGET> findAllLimited();	

	@Query(nativeQuery = true,
			value = "SELECT  c.nome, c.sobrenome, c.cpf, c.phone, u.email "
					+ "FROM cliente c, usuario u "
					+ "WHERE c.nome like %?1% AND u.id = c.usuario_id")
	List<ClientesGET> findByNomeContainingLimited(String name);

	@Query(nativeQuery = true,
			value = "SELECT  u as usuario, c.nome, c.sobrenome, c.cpf, c.phone, "
					+ "e as endereco, c.data_nascimento, c.idade, c.sexo, c.votos "
					+ "FROM cliente c, usuario u "
					+ "LEFT JOIN endereco e ON e.id = c.endereco_id"
					+ "WHERE c.id = ?1 AND u.id = c.usuario_id")
	ClientesGET findMeuCliente(int id);
	
	@Query(nativeQuery = true,
			value = "SELECT  c.nome, c.sobrenome, c.nome as cidade, u.foto "
					+ "FROM cliente c, usuario u "
					+ "LEFT JOIN endereco e ON e.id = c.endereco_id "
					+ "INNER JOIN cidade c ON c.id = e.cidade_id "
					+ "WHERE u.id = c.usuario_id")
	List<ClientesGET> findOutrosClientes();
	
}
