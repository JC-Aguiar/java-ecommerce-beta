package br.com.jcaguiar.ecommerce.contorller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import br.com.jcaguiar.ecommerce.model.Usuario;
import br.com.jcaguiar.ecommerce.repository.UsuarioRepository;

@Controller
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioRepository usuarioRep;
	
	@Autowired
	private DataSource dataSource;
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/adm").authenticated().and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/home", true)
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
				.and()
			.logout()
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/logout")
				.permitAll();
	}	
	
	/*
	 * @Bean
	 * 
	 * @Override public UserDetailsService userDetailsService() { List<Usuario>
	 * usuarios = usuarioRep.findAll(); List<UserDetails> users = new
	 * ArrayList<UserDetails>(); for(Usuario usuario : usuarios) { users.add(
	 * User.withDefaultPasswordEncoder() .username( usuario.getEmail() ) .password(
	 * usuario.getSenha() ) .roles( usuario.isAdm()? "ADM" : "USER" ) .build() ); }
	 * return new InMemoryUserDetailsManager(users); }
	 */
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder senhaCripto = new BCryptPasswordEncoder();

		 auth.jdbcAuthentication()
		 	.dataSource(dataSource)
		 	.passwordEncoder(senhaCripto);
		 
	}
}

