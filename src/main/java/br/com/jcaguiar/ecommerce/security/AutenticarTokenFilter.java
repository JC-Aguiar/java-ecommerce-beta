package br.com.jcaguiar.ecommerce.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.jcaguiar.ecommerce.Console;
import br.com.jcaguiar.ecommerce.model.Usuario;
import br.com.jcaguiar.ecommerce.service.UsuarioService;

final public class AutenticarTokenFilter extends OncePerRequestFilter{
	/**CONCEITO
	 * 
	 */
	/**ATRIBUTOS
	 * 
	 */
	private TokenService tokenService;
	private UsuarioService userService;
	

	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**CONSTRUTOR
	 * 
	 * @param tokenService
	 */
	public AutenticarTokenFilter(TokenService tokenService, UsuarioService userService) {
		this.tokenService = tokenService;
		this.userService = userService;
	}


	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**MÉTODO PRINCIPAL DO FILTRO
	 * Filtro chamado antes do Filtro de autenticação UsernamePasswordAuthenticationFilter
	 * 
	 * getRequestHeaderToken:		Método para coletar o token no Header da requisição 
	 * 
	 * 
	 * 
	 * filterChain.doFilter:		Seguindo adiante na filtragem
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	throws ServletException, IOException {
		Console.log("<FILTRO DE AUTENTICAÇAO>", +1);
		String token = getRequestHexToken(request);
		int userioId = tokenService.validar(token);
		autenticarUsuario(userioId);
		Console.log( "Usuário Autenticado com sucesso.");
		Console.log("</FILTRO DE AUTENTICAÇAO>", -1);
		filterChain.doFilter(request, response); 
	}

	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**COLETAR HEX DE AUTENTICAÇÃO NA HEADER 
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
	 * @param request = HttpServletRequest
	 * @return
	 */
	private String getRequestHexToken(HttpServletRequest request) {
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
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**EFETUAR AUTENTICAÇÃO FINAL
	 * Informando ao sistema que o token validado representa um usuário real agora logado
	 * 1) Obtendo o objeto Usuário
	 * 			userService.findById():		Obtem o objeto usuário através do id.
	 * 			get():						Método preventido para evitar valor nulo.
	 * 
	 * 2) Definindo objeto Authentication
	 * 			Construtor do UsernamePasswordAuthenticationToken exige um objeto
	 * 			da classe que utiliza interface UserDetails, senha (opcional) e
	 * 			o perfil de acesso desse usuário.
	 * 
	 * 3) Efetuando autenticação
	 * 			SecurityContextHolder:		Thread atual do Spring Security com o
	 * 										contexto da autenticação.
	 * 			getContext():				Obtendo o id dessa autenticação.
	 * 			setAuthentication():		Definindo quem estará autenticado.
	 * 			
	 * 
	 * @param login = boolean validador de token
	 * @param token = string hex-code formato JWT
	 * @return
	 */
	private boolean autenticarUsuario(int userioId) {
		try {
			Usuario usuario = userService.findById(userioId).get();
			Authentication dadosUsuario = new UsernamePasswordAuthenticationToken(
					usuario,
					null,
					usuario.getAuthorities()
			);
			SecurityContextHolder.getContext().setAuthentication(dadosUsuario);
			return true;
		} catch (NumberFormatException e) {
			Console.log("ERRO: Id do usuário informado no token não é um número válido");
		}
		return false;
	}

}
