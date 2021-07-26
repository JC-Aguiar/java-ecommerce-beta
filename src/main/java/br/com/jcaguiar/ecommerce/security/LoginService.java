package br.com.jcaguiar.ecommerce.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Usuario;
import br.com.jcaguiar.ecommerce.service.UsuarioService;

@Service
public class LoginService implements UserDetailsService {
	
	@Autowired
	private UsuarioService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.printf("<LOGIN SERVICE>\n");
		Optional<Usuario> usuario = userService.findByEmail(email);
		System.out.printf("</LOGIN SERVICE>\n");
		if( !usuario.isPresent() ) {
			throw new UsernameNotFoundException("Credenciais inválidas.");
		}
		return usuario.get();
	}

}
