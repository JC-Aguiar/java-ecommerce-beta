package br.com.jcaguiar.ecommerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;

@Controller
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	/**CONCEITO
	 * 
	 */
	/**ATRIBUTOS
	 * 
	 */
	@Autowired private TokenService tokenService;
	@Autowired private LoginService loginService;
 
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**CONFIGURAR AUTORIZAÇÕES
	 * Configurando quais URLs possuem quais restrições
	 * 1) URLs com "/adm" só podem ser acessadas por usuários logados com perfil ADM
	 * 2) URLs com "/user" só podem ser acessadas pelo pelo próprio usuário logado
	 * 3) Requisição POST para a URL "/login" é liberada a todos
	 * 4) Quais outras URLs acessadas, estão liberadas 
	 * 5) CSRF desabilitado (desnecessário para API de Microserviço)
	 * 6) Definindo política 
	 * @param HttpSecurity
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		Class<UsernamePasswordAuthenticationFilter> filtroAntes = UsernamePasswordAuthenticationFilter.class;
		AutenticarTokenFilter filtroToken = new AutenticarTokenFilter(tokenService);
		
		http
			.authorizeRequests().mvcMatchers("/adm/**").hasRole("ADMIN").and()
			.authorizeRequests().mvcMatchers("/user/**").hasRole("USER").and()
			.authorizeRequests().mvcMatchers( HttpMethod.POST, "/login" ).permitAll()
			.anyRequest().authenticated().and()
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().addFilterBefore(filtroToken, filtroAntes);
	}
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**CONFIGURAR AUTENTICAÇÃO
	 * Método que configura amdefine autenticação:
	 * 1) Definindo algoritmo de criptografia para senhas
	 * 2) Definindo LoginService como provedor de autenticação, através da interface UserDetailsService
	 *  
	 * @param AuthenticationManagerBuilder
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Classe de criptografia de senhas 
		final BCryptPasswordEncoder ENCRIPT = new BCryptPasswordEncoder();
		
		//Método provedor de autenticação
		auth.userDetailsService(loginService).passwordEncoder(ENCRIPT);
	}
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**PROVIDENCIANDO AUTHENTICATION MANAGER
	 * Método para criar Bean do Authentication Manager, necessãrio no LoginController
	 * Por padrão o Spring não permite que o Authentication Manager seja uma dependência injetãvel
	 */
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}

