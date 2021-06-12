package br.com.jcaguiar.ecommerce.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import br.com.jcaguiar.ecommerce.model.Acesso;
import br.com.jcaguiar.ecommerce.model.Usuario;
import br.com.jcaguiar.ecommerce.service.ProdutoService;
import br.com.jcaguiar.ecommerce.service.UsuarioService;

@Configuration
public class InterceptarAcesso implements HandlerInterceptor {

	@Autowired UsuarioService userService;
	@Autowired ProdutoService prodService;

	@Override
	final public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	throws Exception {
		//final Sort ordene = Sort.by("id").ascending();
		final Usuario USUARIO = getUsuarioLogin(request);
		final Acesso ACESSO = Acesso.builder()
				.usuario(USUARIO)
				.url(request.getRequestURI())
				.build();
		request.setAttribute("acesso", ACESSO);
		return true;
	}

	@Override
	final public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	throws Exception {
		
		Acesso acesso = (Acesso) request.getAttribute("acesso");
		acesso.setDuracao( Duration.between(acesso.getData_acesso(), LocalDateTime.now()) );
		System.out.printf( acesso.print() );
		//HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	final private Usuario getUsuarioLogin(HttpServletRequest request) {
		try {
			final String USER_NAME = request.getUserPrincipal().getName();
			return userService.findByNomeContainingLimited(USER_NAME).get(0);
		}
		catch (Exception e) {
			return Usuario.builder().email("Usuario não logado").build();
		}
	}
}
