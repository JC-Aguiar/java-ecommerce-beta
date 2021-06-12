package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sun.el.parser.ParseException;

import br.com.jcaguiar.ecommerce.projection.ProdutoReport;
import br.com.jcaguiar.ecommerce.service.MasterService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public abstract class MasterController<T, ID> {

	private final MasterService<T, ID> MASTER_SERVICE;
	private final String ADM = "ADMIN";
	protected boolean admSql = true;
	
	//BUSCA GERAL
	@GetMapping
	public ResponseEntity<List<?>> findAll(HttpServletRequest request) {
		
		final Sort ORDENE = Sort.by("id").ascending();
		
		if( request.isUserInRole(ADM) || admSql ) {
			System.out.printf("Consulta ADMIN\n");
			List<?> objetos = MASTER_SERVICE.findAll(ORDENE);
			return new ResponseEntity<>(objetos, HttpStatus.FOUND);
		}
		System.out.printf("Consulta USER\n");
		List<?> objetosReport = MASTER_SERVICE.findAllLimited();
		
		return new ResponseEntity<>(objetosReport, HttpStatus.FOUND);
	}
	
	//BUSCA ESPECIFICA ID
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable(name = "id")ID id, HttpServletRequest request)
	throws NumberFormatException, ParseException {
		
		final Sort ORDENE = Sort.by("id").ascending();
		
		if( request.isUserInRole(ADM) || admSql) {
			System.out.printf("Consulta ADMIN\n");
			final Optional<?> objeto = MASTER_SERVICE.findById(id);
			return new ResponseEntity<>(objeto, HttpStatus.FOUND);
		}
		System.out.printf("Consulta USER\n");
		final Optional<?> produtosLimit = MASTER_SERVICE.findByIdLimited(id);
		
		return new ResponseEntity<>(produtosLimit, HttpStatus.FOUND);
	}
	
	//BUSCA ESPECIFICA NOME
	@GetMapping("/nome/{nome}")
	public ResponseEntity<?> findByNome(@PathVariable(name = "nome")String nome, HttpServletRequest request)
	throws NumberFormatException {
		
		final Sort ORDENE = Sort.by("id").ascending();
		
		if( request.isUserInRole(ADM) || admSql) {
			System.out.printf("Consulta ADMIN\n");
			final List<?> objeto = MASTER_SERVICE.findByNomeContaining(nome);
			return new ResponseEntity<>(objeto, HttpStatus.FOUND);
		}
		System.out.printf("Consulta USER\n");
		final List<?> produtosLimit = MASTER_SERVICE.findByNomeContainingLimited(nome);
		
		return new ResponseEntity<>(produtosLimit, HttpStatus.FOUND);
	}

}
