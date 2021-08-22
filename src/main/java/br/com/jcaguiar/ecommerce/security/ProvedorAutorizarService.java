package br.com.jcaguiar.ecommerce.security;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import br.com.jcaguiar.ecommerce.Console;
import br.com.jcaguiar.ecommerce.model.Perfil;
import br.com.jcaguiar.ecommerce.model.Usuario;
import br.com.jcaguiar.ecommerce.service.UsuarioService;

@Component
public class ProvedorAutorizarService implements AuthenticationProvider {

    @Autowired private UsuarioService userService;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
    	Console.log("<FILTRO AUTORIZAÇÃO>", +1);
    	String email = auth.getName();
        String senha = auth.getCredentials().toString();
        List<Perfil> perfis = (List<Perfil>) auth.getAuthorities();
        Console.log("E-mail do Usuário: " + email);
        Console.log("Senha do Usuário: " + senha);
        Console.log("Perfils do Usuário: ");
        for(Perfil perfil : perfis) {
        	Console.log(">" + perfil.getAuthority());
        }
        Console.log("</FILTRO AUTORIZAÇÃO>", -1);
        return new UsernamePasswordAuthenticationToken(email, senha, perfis);
        //throw new BadCredentialsException("Este usuário está desativado.");
        //throw new UsernameNotFoundException("Login e/ou Senha inválidos.");
    }

    
    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }

    
    private boolean usuarioAtivo(Usuario usuario) {
        if (usuario.isEnabled()) {
            return true;
        }
        return false;
    }
}
