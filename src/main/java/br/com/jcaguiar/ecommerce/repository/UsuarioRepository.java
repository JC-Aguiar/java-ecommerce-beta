package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Usuario;

@Repository
public interface UsuarioRepository extends MasterRepository<Usuario, Integer> {
	
	List<Usuario> findByEmail(String email, Sort sort);
	
	List<Usuario> findByEmailContaining(String email, Sort sort);
	
	List<Usuario> deleteByEmail(String email, Sort sort);

}
