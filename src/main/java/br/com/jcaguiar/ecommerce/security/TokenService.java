package br.com.jcaguiar.ecommerce.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public final class TokenService {

	public String createToken(Authentication userAutenticado) {
		System.out.printf("<TOKEN SERVICE>\n");
		Usuario user = (Usuario) userAutenticado.getPrincipal();
		Date hoje = new Date();
		Date validade = new Date(hoje.getTime() + 1800000 );
		String segredo = "AAAAB3NzaC1yc2EAAAADAQABAAABAQCu9uKkd/f23+CSmwp/Sx72HkRu1wW5Qn238DRzTW7IZWJi2IruikgxXewhaL9ncS8Bm437ScfmjjewLZuVxyRwMs2vBCb4yuXvYl4v2gd+vjw3QdlpHOplTE3BzA1LPco8vVEevBO9j8vFJoHcYjdwnhaOVqFl2Nm+I2WEBFVlnJtWV/zmdmVZxrCxvYEuZ1kLigfA9dtwtOEWrvcieIg132rB73HgmnjhKUKjBjbXzDEW0drgUnjt/Q8Jr/ix6IgPX6F71V6bwkJb0POv/rOHXOnh8gshgZQMgvrQ9/IFk6Ko+FBtMenqIeEZyNnB0chwo2SPAyOdo5w9y6XxcIQ9 ";
		System.out.printf("</TOKEN SERVICE>\n");
		return Jwts.builder()
				.setIssuer("API ECOMMERCE")
				.setSubject( user.getId().toString() )
				.setIssuedAt(hoje)
				.setExpiration(validade)
				.signWith(SignatureAlgorithm.HS256, segredo)
				.compact();
	}
	
	
	
}
