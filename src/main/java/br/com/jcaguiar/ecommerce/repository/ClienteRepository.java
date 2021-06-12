package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.dto.ClienteLimitadoDto;
import br.com.jcaguiar.ecommerce.model.Cliente;
import br.com.jcaguiar.ecommerce.model.Endereco;
import br.com.jcaguiar.ecommerce.model.Usuario;
import br.com.jcaguiar.ecommerce.projection.ClientesReport;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	List<Cliente> findByUsuario(Usuario usuario, Sort sort);
	
	List<Cliente> findByNomeContaining(String nome, Sort sort);
	
	List<Cliente> findBySobrenomeContaining(String sobrenome, Sort sort);
	
	List<Cliente> findByCpfContaining(String cpf, Sort sort);
	
	List<Cliente> findByEndereco(Endereco endereco, Sort sort);
	
	//ClienteInfoLimitada ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	
	@Query(nativeQuery = true,
			value = "SELECT  c.nome, c.sobrenome, c.cpf, c.phone, u.email "
					+ "FROM cliente c, usuario u "
					+ "WHERE c.id = ?1 AND u.id = c.usuario_id")
	ClientesReport findByIdLimited(int id);
	
	@Query(nativeQuery = true,
			value = "SELECT  c.nome, c.sobrenome, c.cpf, c.phone, u.email "
					+ "FROM cliente c, usuario u "
					+ "WHERE u.id = c.usuario_id")
	List<ClientesReport> findAllLimited();	

	@Query(nativeQuery = true,
			value = "SELECT  c.nome, c.sobrenome, c.cpf, c.phone, u.email "
					+ "FROM cliente c, usuario u "
					+ "WHERE c.nome like %?1% AND u.id = c.usuario_id")
	List<ClientesReport> findByNomeContainingLimited(String name);

}
