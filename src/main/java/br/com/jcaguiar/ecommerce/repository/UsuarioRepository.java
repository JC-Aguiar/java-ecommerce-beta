package br.com.jcaguiar.ecommerce.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Usuario;

@Repository
public interface UsuarioRepository extends MasterRepository<Usuario, Integer> {
	
	Optional<Usuario> findByEmail(String email);
	
	Optional<Usuario> findByEmailContaining(String email);
	
	Optional<Usuario> deleteByEmail(String email);

}
