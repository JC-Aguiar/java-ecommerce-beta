package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.Usuario;
import br.com.jcaguiar.ecommerce.repository.UsuarioRepository;

@RestController
@RequestMapping("user")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRep;
	
	@GetMapping
	public List<Usuario> findAll() {
		Sort ordene = Sort.by("id").ascending();
		PageRequest paginacao = PageRequest.of(0, 10, ordene);
		return usuarioRep.findAll(ordene);
	}
	
	@GetMapping("/{email}")
	public Usuario findOne(@PathVariable(name = "email")String email) {
		return usuarioRep.findByEmail(email);
	}
	
	@DeleteMapping("/{email}")
	public List<Usuario> del(@PathVariable(name = "email") String email) {
		usuarioRep.deleteByEmail(email);
		return findAll();
	}

}
