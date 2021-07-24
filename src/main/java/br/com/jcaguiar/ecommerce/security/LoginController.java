package br.com.jcaguiar.ecommerce.security;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public final class LoginController {
	
	//Lógica padrão de Autenticação 
	@PostMapping
	public ResponseEntity<?> eutenticar(@RequestBody @Valid LoginDto login) {
		System.out.printf("E-mail: %s. Senha: %s.\n", login.getEmail(), login.getSenha());
		
		return null;
	}
	
}
