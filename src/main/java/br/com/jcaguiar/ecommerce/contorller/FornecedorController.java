package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.Fornecedor;
import br.com.jcaguiar.ecommerce.service.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController extends MasterController<Fornecedor, Short, FornecedorDto> {

	public FornecedorController(FornecedorService fornecedorService) {
		super("fornecedor", fornecedorService);
	}

	@Override
	public ResponseEntity<?> atualizar(@Valid Fornecedor objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarTodos(@Valid List<Fornecedor> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletar(@Valid Fornecedor objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletarTodos(@Valid List<Fornecedor> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
