package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.Cliente;
import br.com.jcaguiar.ecommerce.projection.ClientesInfoLimitada;
import br.com.jcaguiar.ecommerce.service.ClienteService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private final ClienteService CLIENTE_SERVICE;
	final String ADM = "ADMIN";
	
	//BUSCA GERAL
	@GetMapping
	public ResponseEntity<List<?>> findAll(HttpServletRequest request) {
		final Sort ORDENE = Sort.by("id").ascending();
		if( request.isUserInRole(ADM) ) {
			System.out.printf("Consulta ADMIN\n");
			List<Cliente> clientes = CLIENTE_SERVICE.findAll(ORDENE);
			return new ResponseEntity<>(clientes, HttpStatus.FOUND);
		}
		System.out.printf("Consulta USER\n");
		List<ClientesInfoLimitada> clientesLimit = CLIENTE_SERVICE.findAllLimited(ORDENE);
		return new ResponseEntity<>(clientesLimit, HttpStatus.FOUND);
	}
	
	//BUSCA ESPECIFICA ID
	@GetMapping("/{var}")
	public ResponseEntity<?> findOneId(@PathVariable(name = "var")String var, HttpServletRequest request) {
		try {
			final int ID = Integer.parseInt(var);
			final Sort ORDENE = Sort.by("id").ascending();
			if( request.isUserInRole(ADM) ) {
				System.out.printf("Consulta ADMIN\n");
				final Optional<Cliente> cliente = CLIENTE_SERVICE.findById(ID);
				return new ResponseEntity<>(cliente, HttpStatus.FOUND);
			}
			System.out.printf("Consulta USER\n");
			final ClientesInfoLimitada clienteLimit = CLIENTE_SERVICE.findByIdLimited(ID);
			return new ResponseEntity<>(clienteLimit, HttpStatus.FOUND);
		}
		catch (NumberFormatException e) {
			return findOneNome(var, request);
		}
	}
	
	//BUSCA ESPECIFICA NOME
	public ResponseEntity<List<?>> findOneNome(String nome, HttpServletRequest request) {
		final Sort ORDENE = Sort.by("id").ascending();
		if( request.isUserInRole(ADM) ) {
			System.out.printf("Consulta ADMIN\n");
			final List<Cliente> cliente = CLIENTE_SERVICE.findByNameContaining(nome, ORDENE);
			return new ResponseEntity<>(cliente, HttpStatus.FOUND);
		}
		System.out.printf("Consulta USER\n");
		final List<ClientesInfoLimitada> clienteLimit = CLIENTE_SERVICE.findByNameContainingLimited(nome);
		return new ResponseEntity<>(clienteLimit, HttpStatus.FOUND);
	}

	
}
