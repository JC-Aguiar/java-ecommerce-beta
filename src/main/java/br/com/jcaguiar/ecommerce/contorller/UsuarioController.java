package br.com.jcaguiar.ecommerce.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.Usuario;
import br.com.jcaguiar.ecommerce.service.UsuarioService;

@RestController
@RequestMapping("user")
public class UsuarioController extends MasterController<Usuario, Integer> {

	public UsuarioController(UsuarioService userService) {
		super(userService);
	}
	
	
	
}
