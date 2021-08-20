package br.com.jcaguiar.ecommerce.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import br.com.jcaguiar.ecommerce.Console;

final public class AutenticarTokenFilter extends OncePerRequestFilter{
	/**CONCEITO
	 * 
	 */
	/**ATRIBUTOS
	 * 
	 */
	private TokenService tokenService;
	

	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**CONSTRUTOR
	 * 
	 * @param tokenService
	 */
	public AutenticarTokenFilter(TokenService tokenService) {
		this.tokenService = tokenService;
	}


	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**MÉTODO PRINCIPAL DO FILTRO
	 * Filtro chamado antes do Filtro de autenticação UsernamePasswordAuthenticationFilter
	 * Token é coletado no Header da requisição através do método getRequestHeader
	 * Seguindo adiante na filtragem através do < filterChain.doFilter >
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	throws ServletException, IOException {
		Console.log("<FILTRO DE AUTENTICAÇAO>", +1);
		String token = getRequestHeader(request);
		boolean login = tokenService.validar(token);
		Console.log( Boolean.toString(login) );
		Console.log("</FILTRO DE AUTENTICAÇAO>", -1);
		filterChain.doFilter(request, response); 
	}

	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**COLETAR HEADER DE AUTENTICAÇÃO
	 * 1) Definindo atributos
	 * 
	 * 2) Autorização do Header
	 * 		request:		chamando propriedades da requisição HTTP
	 * 		getHeader:		coletando atributo "Authorization"
	 * 
	 * 		header.startsWith(tipo):
	 * 						se o header "Authentication" começa com o texto da variavel "tipo",
	 * 						o token será este mesmo Header sem o prefixo do "tipo" e sem espaços em branco 
	 * 
	 * @param request
	 * @return
	 */
	private String getRequestHeader(HttpServletRequest request) {
		String tipo = "Bearer";
		String header = request.getHeader("Authorization");
		String token = null;
		try {
			if(header.startsWith(tipo)) {
				token = header.substring(tipo.length());
				token = token.trim();
				Console.log( String.format("TOKEN: [%s] %s", tipo, token) );
			}
			else {
				Console.log("ERRO NA AUTENTICAÇÃO: Header da requisição diferente de Bearer.");
			}
		}
		catch (NullPointerException e) {
			Console.log("ERRO NA AUTENTICAÇÃO: Header da requisição sem Bearer informado.");
		}
		return token;
	}

}
