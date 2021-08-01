package br.com.jcaguiar.ecommerce.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Usuario;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Service
/**
 * 
 * @author JM Costal Aguiar
 *
 */
public final class TokenService {
	/**ATRIBUTOS
	 * segredo:		assinatura de validação dos tokens
	 * tempoLogin:	validade do token após criado (em milisegundos)
	 * log:			para exibir informações no console
	 * 				(valor coletado no arquivo "application.properties")
	 */
	private String segredo = "AAAAB3NzaC1yc2EAAAADAQABAAABAQCu9uKkd/f23+CSmwp/Sx72HkRu1wW5Qn238DRzTW7IZWJi2IruikgxXewhaL9ncS8Bm437ScfmjjewLZuVxyRwMs2vBCb4yuXvYl4v2gd+vjw3QdlpHOplTE3BzA1LPco8vVEevBO9j8vFJoHcYjdwnhaOVqFl2Nm+I2WEBFVlnJtWV/zmdmVZxrCxvYEuZ1kLigfA9dtwtOEWrvcieIg132rB73HgmnjhKUKjBjbXzDEW0drgUnjt/Q8Jr/ix6IgPX6F71V6bwkJb0POv/rOHXOnh8gshgZQMgvrQ9/IFk6Ko+FBtMenqIeEZyNnB0chwo2SPAyOdo5w9y6XxcIQ9 ";
	private int tempoLogin = 1800000;
	@Value("${ecommerce.system.log}") private boolean log;
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**CRIANDO TOKEN APÓS LOGIN
	 * Uma vez autenticado, o token JWT será gerado a este usuário
	 * 1) Coletando usuário
	 * 			Authentication:		Classe gerenciada pelo AuthenticationManager (no LoginController) e quando esta mesma
	 * 								classe é instanciada, recebe a email e senha do usuário.
	 * 			getPrincipal:		Método que retorna a classe usuário que está salvo no Authentication.
	 * 
	 * 2) Definindo datas
	 * 			hoje:				Data atual.
	 * 			validade:			Data de expiração do token para esse login.
	 * 
	 * 3) Classe Jwt para criação do token:
	 * 			builder:			Preenchendo campos do construtor Jwts.
	 * 			setIssuer:			Nome do emissor.
	 * 			setSubject:			Identificador único (id) do objeto de login (usuário) em formato String.
	 * 			setIssuedAt:		Data emissáo do token.
	 * 			setExpiration:		Data de expiração de uso do token.
	 * 			signWith:			Recebe método de criptografia e assinatura secreta da API.
	 * 			SignatureAlgorithm:	Método estático do Jwts com criptorgrafias disponíveis.
	 * 			compact:			Criar token.
	 * 
	 * @param userAutenticado
	 * @return
	 */
	public String newToken(Authentication userAutenticado) {
		System.out.printf("<TOKEN SERVICE>\n");
		Usuario user = (Usuario) userAutenticado.getPrincipal();
		Date hoje = new Date();
		Date validade = new Date(hoje.getTime() + tempoLogin);
		System.out.printf("</TOKEN SERVICE>\n");
		return Jwts.builder()
				.setIssuer("API ECOMMERCE")
				.setSubject( user.getId().toString() )
				.setIssuedAt(hoje)
				.setExpiration(validade)
				.signWith(SignatureAlgorithm.HS256, segredo)
				.compact();
	}

	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**VALIDANDO TOKEN DO REQUEST
	 * 1) Tentar decodificar token do usuário
	 * 		Jwts:				Classe responsável pelas interfaces Jwt.
	 * 		parser: 			Decodificador de token.
	 * 		setSigningKey:	 	Definir assinatura do decodificador, 
	 * 				  			(tanto o token quanto o sistema precisam ser iguais).
	 * 		parseClaimsJws: 	Converta o playload (usuário).
	 *
	 */
	public boolean validar(String token) {
		try {
			//Processando token Jwt
			Jwts.parser().setSigningKey(segredo).parseClaimsJws(token);
			return true;
		}
		catch (MalformedJwtException e) {
			//Se o token não estiver no padrão JWS
			log("O token do usuário não é um JWS válido\n");
		}
		catch (SignatureException e) {
			//Se a assinatura do token não corresponde
			log("Assinatura do token não é compatível\n");
		}
		catch (ExpiredJwtException e) {
			//Se o tempo de validade do token expirou
			log("Token com tempo de validade expirado\n");
		}
		catch (IllegalArgumentException e) {
			//Se o token está em branco, só com espaços em brancos ou nulo
			log("Token com valores incorretos (vazio, nulo ou em branco)\n");
		}
		return false;
	}
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**EXIBINDO MENSAGENS DO SISTEMA
	 * Variável local "log" precisa estar ativada 
	 * @param mensagem
	 */
	private void log(String mensagem) {
		if(log)
			System.out.printf(mensagem);
	}
	
}