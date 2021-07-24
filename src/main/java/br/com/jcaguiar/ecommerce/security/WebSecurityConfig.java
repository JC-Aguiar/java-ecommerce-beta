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
import org.springframework.stereotype.Controller;

@Controller
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//@Autowired
	//private DataSource dataSource; //Remover se não utilizado mais
	
	@Autowired
	private LoginService loginService;
 
	//MÉTODO PARA CONFIGURAR AUTORIZAÇÕES
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests().mvcMatchers("/adm/**").hasRole("ADMIN").and()
			.authorizeRequests().mvcMatchers("/user/**").hasRole("USER").and()
			.authorizeRequests().mvcMatchers( HttpMethod.POST, "/login" ).permitAll()
			.anyRequest().authenticated().and()
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	//MÉTODO PARA CONFIGURAR AUTENTICAÇÃO
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Método de criptografia de senhas 
		final BCryptPasswordEncoder ENCRIPT = new BCryptPasswordEncoder();
		
		//Método provedor de autenticação
		auth.userDetailsService(loginService).passwordEncoder(ENCRIPT);
	}
	
	//MÉTODO PARA CRIAR BEAN DO AUTHENTICATION MANAGER (USADO NO LOGIN_CONTROLLER)
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}

