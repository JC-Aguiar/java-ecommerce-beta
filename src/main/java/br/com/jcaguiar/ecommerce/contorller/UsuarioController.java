package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
		super(userService);
	}

	@Override
	public ResponseEntity<?> salvarTodos(List<UsuarioDto> objetos, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizar(Usuario objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarTodos(List<Usuario> objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletar(Usuario objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletarTodos(List<Usuario> objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
