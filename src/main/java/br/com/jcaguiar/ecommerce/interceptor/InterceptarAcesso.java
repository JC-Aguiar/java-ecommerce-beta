package br.com.jcaguiar.ecommerce.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import br.com.jcaguiar.ecommerce.model.Acesso;
import br.com.jcaguiar.ecommerce.repository.AcessoRepository;
import br.com.jcaguiar.ecommerce.repository.UsuarioRepository;

@Configuration
public class InterceptarAcesso implements HandlerInterceptor {

	@Autowired
	UsuarioRepository userRepo;
	@Autowired
	AcessoRepository acessoRepo;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//String userName = request.getUserPrincipal().getName();
		//Sort ordene = Sort.by("id").ascending();
		//List<Usuario> usuario = userRepo.findByEmailContaining(userName, ordene);
		Acesso acesso = new Acesso();
		acesso.setUrl( request.getRequestURI() );;
		request.setAttribute("acesso", acesso);
		//return HandlerInterceptor.super.preHandle(request, response, handler);
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		Acesso acesso = (Acesso) request.getAttribute("acesso");
		acesso.setDuracao( Duration.between(acesso.getData_acesso(), LocalDateTime.now()) );
		System.out.printf( acesso.print() );
		//HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
