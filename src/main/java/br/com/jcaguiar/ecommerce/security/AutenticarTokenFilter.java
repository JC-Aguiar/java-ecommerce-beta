package br.com.jcaguiar.ecommerce.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

final public class AutenticarTokenFilter extends OncePerRequestFilter{

	private TokenService tokenService;
	
		
	//CONSTRUTOR
	public AutenticarTokenFilter(TokenService tokenService) {
		this.tokenService = tokenService;
	}


	//MÉTODO PRINCIPAL NO QUAL O FILTRO É CHAMADO
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	throws ServletException, IOException {
		//Coletando token de autenticação Bearer
		String token = getClienteToken(request);
		boolean login = tokenService.validar(token);
		
		//Seguindo adiante na filtragem
		filterChain.doFilter(request, response); 
	}

	
	//MÉTODO PARA COLETAR HEADER DE AUTENTICAÇÃO
	private String getClienteToken(HttpServletRequest request) {
		String tipo = "Bearer";
		String header = request.getHeader("Authorization");
		String token = null;
		
		
		try {
			if(header.startsWith(tipo)) {
				token = header.substring(tipo.length()).trim();
				log( String.format("TOKEN: [%s] %s", tipo, token));
				//Buscando token para Autenticação Bearer 
				//Se o Header "Authentication" começa com a mesma definição da variavel "tipo",
				//o token será esse mesmo Header sem o prefixo do tipo e sem os espaços em branco 
			}
			else {
				log("ERRO NA AUTENTICAÇÃO: Header da requisição diferente de Bearer.");
			}
		}
		catch (NullPointerException e) {
			log("ERRO NA AUTENTICAÇÃO: Header da requisição sem Bearer informado.");
		}
		return token;
	}
	
	
	//MÉTODO PARA MONITORAR O SISTEMA
	public void log(String mensagem) {
		System.out.printf(
				"INTERCEPTADOR DE AUTENTICAÇAO {\n"
				+ "\t%s\n"
				+ "}\n", 
				mensagem);
	}

}
