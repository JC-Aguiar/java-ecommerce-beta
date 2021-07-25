package br.com.jcaguiar.ecommerce.security;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public final class LoginController {
	
	@Autowired
	private AuthenticationManager gerenteLogin;
	
	@Autowired
	private TokenService tokenService;
	
	//Lógica padrão de Autenticação 
	@PostMapping
	public ResponseEntity<?> eutenticar(@RequestBody @Valid LoginDto login) {
		//Log interno
		System.out.printf("E-mail: %s. Senha: %s.\n", login.getEmail(), login.getSenha());
		
		//Através do AuthenticationManager.authenticate irá consultar as configurações do Spring e irá chamar o provedor LoginService
		try {
			//Se usuário está cadastrado: 200 OK
			UsernamePasswordAuthenticationToken autenticarDados = login.getToken();
			Authentication userAutenticado = gerenteLogin.authenticate(autenticarDados);
			String token = tokenService.createToken(userAutenticado);
			
			//Criando objeto Token com autenticação do tipo Barer (conceitos HTTP) 
			TokenDto tokenDto = new TokenDto(token, "Bearer");
			
			//Log interno
			System.out.printf("Token: %s\n", token );
			
			return ResponseEntity.ok().build();
		}
		catch (Exception e) {
			//Usuário não identificado: 400 BAD REQUEST
			return ResponseEntity.badRequest().build();
		}
		
		
		
		
	}
	
}
