package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.dto.ProdutoDto;
import br.com.jcaguiar.ecommerce.model.Produto;
import br.com.jcaguiar.ecommerce.projection.ProdutoAdmReport;
import br.com.jcaguiar.ecommerce.projection.ProdutoUserReport;
import br.com.jcaguiar.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController extends MasterController<Produto, Integer, ProdutoDto>{
	
	public ProdutoController(ProdutoService produtoService) {
		super(Produto.class, ProdutoDto.class, "produto", produtoService);
	}
	
	@Override
	@GetMapping
	@Transactional
	public ResponseEntity<List<?>> buscarTodos(HttpServletRequest request) {
		//Preparando ordenação
		final Sort ORDENE = Sort.by("id").ascending();
		
		//Usuário da consulta ADMIN?
		if( request.isUserInRole(ADM) || admSql ) {
			log(0);//Consulta ADMIN
			List<ProdutoAdmReport> produtos =  ((ProdutoService) MASTER_SERVICE).findTodosAdm();			
			return new ResponseEntity<>(produtos, HttpStatus.OK);
		}
		log(1);//Consulta USER
		List<ProdutoUserReport> produtos = ((ProdutoService) MASTER_SERVICE).findTodos();
		return new ResponseEntity<>(produtos, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> atualizar(@Valid Produto objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarTodos(@Valid List<Produto> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletar(@Valid Produto objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletarTodos(@Valid List<Produto> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}


}
