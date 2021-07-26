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
		System.out.printf("<LOGIN CONTROLER>\n");
		System.out.printf("E-mail: %s. Senha: %s.\n", login.getEmail(), login.getSenha());
		
		//Se usuário cadastrado: 200 OK
		//Senão: 400 BAD REQUEST
		try {
			System.out.printf("Preparando Token...\n");
			UsernamePasswordAuthenticationToken autenticarDados = login.getToken();
			
			System.out.printf("Autenticando via AuthenticationManager...\n");
			Authentication userAutenticado = gerenteLogin.authenticate(autenticarDados);
			//Através do AuthenticationManager.authenticate o sistema consultará as configurações do Spring, chamando o provedor LoginService
			
			System.out.printf("Criando Token...\n");
			String token = tokenService.createToken(userAutenticado);
			
			TokenDto tokenDto = new TokenDto(token, "Bearer");
			System.out.printf("Token: %s\n", token );
			System.out.printf("</LOGIN CONTROLER>\n");
			//Criando objeto Token com autenticação do tipo Barer (conceitos HTTP)
			
			return ResponseEntity.ok(tokenDto);
		}
		catch (Exception e) {
			System.out.printf("</LOGIN CONTROLER>\n");
			return ResponseEntity.badRequest().build();
		}
		
	}
	
}
