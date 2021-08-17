package br.com.jcaguiar.ecommerce.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.Console;
import br.com.jcaguiar.ecommerce.model.Usuario;
import br.com.jcaguiar.ecommerce.service.UsuarioService;

@Service
public class LoginService implements UserDetailsService {
	/**CONCEITO
	 * 
	 */
	/**ATRIBUTOS
	 * 	userService:		Classe com os métodos CRUD da entidade Usuário.
	 * 
	 */
	@Autowired
	private UsuarioService userService;
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**CONSULTAR USUÁRIO
	 * Método evocado pelo "LoginController" para coletar e retornar o usuário com base no atributo do email.
	 * Método utilizado pela classe ???.
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Console.log("<LOGIN SERVICE> \n");
		Optional<Usuario> usuario = userService.findByEmail(email);		
		Console.log( String.format("%s\n", usuario.get().getEmail()) );
		if( !usuario.isPresent() ) {
			throw new UsernameNotFoundException("Credenciais inválidas.");
		}
		Console.log("usuário identificado\n");
		Console.log("</LOGIN SERVICE> \n");
		
		return usuario.get();
	}

}
