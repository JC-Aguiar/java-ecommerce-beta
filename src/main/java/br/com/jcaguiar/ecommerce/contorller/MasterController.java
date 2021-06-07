package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.Produto;
import br.com.jcaguiar.ecommerce.projection.ProdutoReport;
import br.com.jcaguiar.ecommerce.service.MasterService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public abstract class MasterController<T, ID> {

	private MasterService<T, ID> MASTER_SERVICE;
	final String ADM = "ADMIN";
	
	//BUSCA GERAL
	@GetMapping
	public ResponseEntity<List<?>> findAll(HttpServletRequest request) {
		final Sort ORDENE = Sort.by("id").ascending();
		if( request.isUserInRole(ADM) ) {
			System.out.printf("Consulta ADMIN\n");
			List<?> objetos = MASTER_SERVICE.findAll(ORDENE);
			return new ResponseEntity<>(objetos, HttpStatus.FOUND);
		}
		System.out.printf("Consulta USER\n");
		List<?> objetosReport = MASTER_SERVICE.findAll(ORDENE);
		return new ResponseEntity<>(objetosReport, HttpStatus.FOUND);
	}

}
