package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.Produto;
import br.com.jcaguiar.ecommerce.projection.ProdutoReport;
import br.com.jcaguiar.ecommerce.service.ProdutoService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/produto")
public class ProdutoController {

	private ProdutoService PRODUTO_SERVICE;
	final String ADM = "ADMIN";
	
	//BUSCA GERAL
	@GetMapping
	public ResponseEntity<List<?>> findAll(HttpServletRequest request) {
		final Sort ORDENE = Sort.by("id").ascending();
		if( request.isUserInRole(ADM) ) {
			System.out.printf("Consulta ADMIN\n");
			List<Produto> produtos = PRODUTO_SERVICE.findAll(ORDENE);
			return new ResponseEntity<>(produtos, HttpStatus.FOUND);
		}
		System.out.printf("Consulta USER\n");
		List<ProdutoReport> produtosReport = PRODUTO_SERVICE.findAllLimited(ORDENE);
		return new ResponseEntity<>(produtosReport, HttpStatus.FOUND);
	}
	
	//BUSCA ESPECIFICA ID
	@GetMapping("/{var}")
	public ResponseEntity<?> findById(@PathVariable(name = "var")String var, HttpServletRequest request) {
		try {
			final int ID = Integer.parseInt(var);
			final Sort ORDENE = Sort.by("id").ascending();
			if( request.isUserInRole(ADM) ) {
				System.out.printf("Consulta ADMIN\n");
				final Optional<Produto> produtos = PRODUTO_SERVICE.findById(ID);
				return new ResponseEntity<>(produtos, HttpStatus.FOUND);
			}
			System.out.printf("Consulta USER\n");
			final ProdutoReport produtosLimit = PRODUTO_SERVICE.findByIdLimited(ID);
			return new ResponseEntity<>(produtosLimit, HttpStatus.FOUND);
		}
		catch (NumberFormatException e) {
			return findByeNome(var, request);
		}
	}
	
	//BUSCA ESPECIFICA NOME
	public ResponseEntity<List<?>> findByeNome(String nome, HttpServletRequest request) {
		final Sort ORDENE = Sort.by("id").ascending();
		if( request.isUserInRole(ADM) ) {
			System.out.printf("Consulta ADMIN\n");
			final List<Produto> produtos = PRODUTO_SERVICE.findByNomeContaining(nome, ORDENE);
			return new ResponseEntity<>(produtos, HttpStatus.FOUND);
		}
		System.out.printf("Consulta USER\n");
		final List<ProdutoReport> produtosLimit = PRODUTO_SERVICE.findByNomeContainingLimited(nome);
		return new ResponseEntity<>(produtosLimit, HttpStatus.FOUND);
	}

}
