package br.com.jcaguiar.ecommerce.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Usuario;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Service
public final class TokenService {
	/**ATRIBUTOS
	 * segredo:		assinatura de validação dos tokens
	 * tempoLogin:	validade do token após criado (em milisegundos)
	 */
	private String segredo = "AAAAB3NzaC1yc2EAAAADAQABAAABAQCu9uKkd/f23+CSmwp/Sx72HkRu1wW5Qn238DRzTW7IZWJi2IruikgxXewhaL9ncS8Bm437ScfmjjewLZuVxyRwMs2vBCb4yuXvYl4v2gd+vjw3QdlpHOplTE3BzA1LPco8vVEevBO9j8vFJoHcYjdwnhaOVqFl2Nm+I2WEBFVlnJtWV/zmdmVZxrCxvYEuZ1kLigfA9dtwtOEWrvcieIg132rB73HgmnjhKUKjBjbXzDEW0drgUnjt/Q8Jr/ix6IgPX6F71V6bwkJb0POv/rOHXOnh8gshgZQMgvrQ9/IFk6Ko+FBtMenqIeEZyNnB0chwo2SPAyOdo5w9y6XxcIQ9 ";
	private int tempoLogin = 1800000;
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/** CRIANDO TOKEN APÓS LOGIN
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
	/** VALIDANDO TOKEN DO REQUEST
	 * 1) Tentar decodificar token do usuário
	 * 		Jwts:				classe responsável pelas interfaces Jwt
	 * 		parser: 			decodificador de token
	 * 		setSigningKey:	 	definir assinatura do decodificador, 
	 * 				  			(tanto o token quanto o sistema precisam ser iguais).
	 * 		parseClaimsJws: 	converta o playload (usuário)
	 * 2) 
	 */
	public boolean validar(String token) {
		try {
			//Processando token Jwt
			Jwts.parser().setSigningKey(segredo).parseClaimsJws(token);
			return true;
		}
		catch (MalformedJwtException e) {
			//Se o token não estiver no padrão JWS
			System.out.printf("O token do usuário não é um JWS válido\n");
		}
		catch (SignatureException e) {
			//Se a assinatura do token não corresponde
			System.out.printf("Assinatura do token não é compatível\n");
		}
		catch (ExpiredJwtException e) {
			//Se o tempo de validade do token expirou
			System.out.printf("Token com tempo de validade expirado\n");
		}
		catch (IllegalArgumentException e) {
			//Se o token está em branco, só com espaços em brancos ou nulo
			System.out.printf("Token com valores incorretos (vazio, nulo ou em branco)\n");
		}
		return false;
	}
	
	
	
}
