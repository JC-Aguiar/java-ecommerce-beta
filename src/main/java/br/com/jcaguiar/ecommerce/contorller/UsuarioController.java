package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.dto.UsuarioDto;
import br.com.jcaguiar.ecommerce.model.Usuario;
import br.com.jcaguiar.ecommerce.service.UsuarioService;

@RestController
@RequestMapping("user")
public class UsuarioController extends MasterController<Usuario, Integer, UsuarioDto> {

	
	public UsuarioController(UsuarioService userService) {
		super(Usuario.class, UsuarioDto.class, "user", userService);
	}

	@Override
	public ResponseEntity<?> atualizar(@Valid Usuario objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarTodos(@Valid List<Usuario> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletar(@Valid Usuario objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletarTodos(@Valid List<Usuario> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
