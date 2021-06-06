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

import br.com.jcaguiar.ecommerce.model.Cidade;
import br.com.jcaguiar.ecommerce.model.Cliente;
import br.com.jcaguiar.ecommerce.model.Estado;
import br.com.jcaguiar.ecommerce.projection.ClientesInfoLimitada;
import br.com.jcaguiar.ecommerce.service.CidadeService;
import br.com.jcaguiar.ecommerce.service.ClienteService;
import br.com.jcaguiar.ecommerce.service.EstadoService;

@RestController
@RequestMapping("estado")
public class EstadoController {
	
	@Autowired
	private EstadoService ESTADO_SERVICE;
	
	//BUSCA GERAL
	@GetMapping
	public ResponseEntity<List<?>> findAll(HttpServletRequest request) {
		final Sort ORDENE = Sort.by("id").ascending();
		List<Estado> estados = ESTADO_SERVICE.findAll(ORDENE);
		return new ResponseEntity<>(estados, HttpStatus.FOUND);
	}
	
	//BUSCA ESPECIFICA ID
	@GetMapping("/{var}")
	public ResponseEntity<?> findById(@PathVariable(name = "var")String var, HttpServletRequest request) {
		try {
			final short ID = Short.parseShort(var);
			final Sort ORDENE = Sort.by("id").ascending();
			final Optional<Estado> estados = ESTADO_SERVICE.findById(ID);
			return new ResponseEntity<>(estados, HttpStatus.FOUND);
		}
		catch (NumberFormatException e) {
			return findByNome(var, request);
		}
	}
	
	//BUSCA ESPECIFICA NOME
	public ResponseEntity<List<?>> findByNome(String nome, HttpServletRequest request) {
		final Sort ORDENE = Sort.by("id").ascending();
		final List<Estado> estados = ESTADO_SERVICE.findByNomeContaining(nome, ORDENE);
		return new ResponseEntity<>(estados, HttpStatus.FOUND);
	}

	
}
