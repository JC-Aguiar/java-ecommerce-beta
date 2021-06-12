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
import br.com.jcaguiar.ecommerce.model.Endereco;
import br.com.jcaguiar.ecommerce.projection.ClientesReport;
import br.com.jcaguiar.ecommerce.service.ClienteService;
import br.com.jcaguiar.ecommerce.service.EnderecoService;

@RestController
@RequestMapping("endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService ENDERECO_SERVICE;
	
	//BUSCA GERAL
	@GetMapping
	public ResponseEntity<List<?>> findAll(HttpServletRequest request) {
		final Sort ORDENE = Sort.by("id").ascending();
		List<Endereco> endereco = ENDERECO_SERVICE.findAll(ORDENE);
		return new ResponseEntity<>(endereco, HttpStatus.FOUND);
	}
	
	//BUSCA ESPECIFICA ID
	@GetMapping("/{var}")
	public ResponseEntity<?> findById(@PathVariable(name = "var")String var) {
		try {
			final int ID = Integer.parseInt(var);
			final Sort ORDENE = Sort.by("id").ascending();
			final Optional<Endereco> endereco = ENDERECO_SERVICE.findById(ID);
			return new ResponseEntity<>(endereco, HttpStatus.FOUND);
		}
		catch (NumberFormatException e) {
			return findByBairro(var);
		}
	}
	
	//BUSCA ESPECIFICA RUA
	@GetMapping("/rua/{rua}")
	public ResponseEntity<List<?>> findByRua(@PathVariable(name = "rua")String rua) {
		final Sort ORDENE = Sort.by("id").ascending();
		final List<Endereco> endereco = ENDERECO_SERVICE.findByRuaContaining(rua, ORDENE);
		return new ResponseEntity<>(endereco, HttpStatus.FOUND);
	}
	
	//BUSCA ESPECIFICA BAIRRO
	public ResponseEntity<List<?>> findByBairro(String bairro) {
		final Sort ORDENE = Sort.by("id").ascending();
		final List<Endereco> endereco = ENDERECO_SERVICE.findByBairroContaining(bairro, ORDENE);
		return new ResponseEntity<>(endereco, HttpStatus.FOUND);
	}

	//BUSCA ESPECIFICA CEP
	@GetMapping("/rua/{cep}")
	public ResponseEntity<List<?>> findByCep(@PathVariable(name = "cep")String cep) {
		final Sort ORDENE = Sort.by("id").ascending();
		final List<Endereco> endereco = ENDERECO_SERVICE.findByCepContaining(cep, ORDENE);
		return new ResponseEntity<>(endereco, HttpStatus.FOUND);
	}
	
}
