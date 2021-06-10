package br.com.jcaguiar.ecommerce;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import br.com.jcaguiar.ecommerce.interceptor.InterceptarAcesso;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor( new InterceptarAcesso() ).addPathPatterns("/**");
	}
	
}
