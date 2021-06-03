package br.com.jcaguiar.ecommerce.contorller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.Cliente;
import br.com.jcaguiar.ecommerce.model.Usuario;
import br.com.jcaguiar.ecommerce.repository.ClienteRepository;
import br.com.jcaguiar.ecommerce.repository.UsuarioRepository;
import kotlin.collections.ArrayDeque;

@RestController
@RequestMapping("user")
public class UsuarioController {
	/** FINALIDADES
	 * 1) BUSCANDO POR USUÁRIOS
	 * 2) ACESSANDO DADOS DE UM USUÁRIO
	 * 3) ATUALIZANDO DADOS DE UM USUÁRIO
	 */
	
	@Autowired
	private UsuarioRepository usuarioRep;
	private ClienteRepository clienteRep;
	
	//BUSCA GERAL
	@GetMapping
	public List<Usuario> findAll(HttpServletRequest request) {
		/** Conceito
		 * Default: retorne cliente
		 * Cliente não cadastrado? retorne usuario
		 * Usuario não identificado? retorne null
		 */
		//final PageRequest PAGINAR = PageRequest.of(0, 10, ORDENE);
		final Sort ORDENE = Sort.by("id").ascending();
		
		if( request.isUserInRole("ADMIN") ) {
			System.out.printf("Consulta ADMIN\n");
			return usuarioRep.findAll(ORDENE);
		}
		else {
			return null;
		}
	}
	
	//BUSCA POR ID/NOME
	@GetMapping("/{var}")
	public List<Usuario> find(@PathVariable(name = "var")String var) {
		final Sort ORDENE = Sort.by("id").ascending();
		List<Usuario> usuarios = new ArrayDeque<Usuario>();
		try {
			final int ID = Integer.parseInt(var);
			usuarios = usuarioRep.findById(ID, ORDENE);
		}
		catch (NumberFormatException e) {
			usuarios = usuarioRep.findByEmailContaining(var, ORDENE);
		}
		return usuarios;
	}

	
	//DELETE POR ID
	@DeleteMapping("/{id}")
	public List<Usuario> del(@PathVariable(name = "id") String id, HttpServletRequest request) throws NumberFormatException {
		final int ID = Integer.parseInt(id);
		usuarioRep.deleteById(ID);
		return findAll(request);
	}
	
	
	
}
