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

import br.com.jcaguiar.ecommerce.Console;

@RestController
@RequestMapping("/login")
public final class LoginController {
	/**CONCEITO
	 * 
	 */
	/**ATRIBUTOS
	 * 		gerenteLogin:		Interface AuthenticationManager orignal do Spring.
	 * 							Cria as condições para autenticar objetos UsernamePasswordAuthenticationToken.
	 * 
	 * 		tokenService:		Classe TokenService, destinada à criação e decodificação de tokens de autenticação
	 * 							no formato JWT (Jason Web Tokens).
	 */
	@Autowired
	private AuthenticationManager gerenteLogin;
	
	@Autowired
	private TokenService tokenService;
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**PADRÃO DE AUTENTICAÇÃO
	 * Através dos parametros enviados no corpo da requisição, o sistema tentará:
	 * 1) Autenticar o usuário
	 * 2) Criar Token tipo Bearer desse usuário
	 * 3) Retornar a versão DTO desse token na resposta ao cliente
	 * 
	 * Através do try/catch temos 2 resultados finais:
	 * 			normal: 	usuário cadastrado e autentivado -> 200 OK
	 * 			exception:	usuário não encontrado -> 400 BAD REQUEST
	 * 
	 * 1) Realizando Autenticação:
	 * 			UsernamePasswordAuthenticationToken:
	 * 					Objeto criado através do método "login.compilarDados", da classe LoginDto.
	 * 					Utiliza os atributos "E-mail" e "Senha" para preparar a autenticação.
	 * 
	 * 			Authentication:
	 * 					Através do "AuthenticationManager.authenticate" o sistema consultará
	 * 					as configurações do Spring, chamando o provedor de autenticação 
	 * 					"LoginService", pois este consta usando a interface "UserDetailsService".
	 * 
	 * 2) Criando Token:
	 * 					Através do método "tokenService.newToken", será gerado um token JWT usando
	 * 					os dado deste usuário. Ou seja, é criada uma chave (string) criptografada
	 * 					que representa essa autenticação bem sucedida.
	 * 					
	 * 3) Retornando DTO:
	 * 					Com base no token já criado, é definido o tipo de autenticação que o sistema
	 * 					usa para então gerar o DTO que será retornado ao cliente.
	 * 			
	 */ 
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginDto login) {
		Console.log("<LOGIN CONTROLER> \n");
		Console.log( String.format("Dados coletados: [e-mail]: %s, [senha]: %s.\n", login.getEmail(), login.getSenha() ));
		try {
			UsernamePasswordAuthenticationToken autenticarDados = login.compilarDados();
			Authentication userAutenticado = gerenteLogin.authenticate(autenticarDados);
			Console.log("Realizando Autenticação...\n");
			
			String token = tokenService.newToken(userAutenticado);
			Console.log("Criando Token...\n");
			
			TokenDto tokenDto = new TokenDto(token, "Bearer");
			Console.log( String.format( "Token: %s\n", token ) );
			Console.log("</LOGIN CONTROLER>\n");
			
			return ResponseEntity.ok(tokenDto);
		}
		catch (Exception e) {
			Console.log("</LOGIN CONTROLER> \n");
			return ResponseEntity.badRequest().build();
		}
		
	}
	
}
