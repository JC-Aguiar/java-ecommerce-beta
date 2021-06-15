package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.Fornecedor;
import br.com.jcaguiar.ecommerce.service.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController extends MasterController<Fornecedor, Short, FornecedorDto> {

	public FornecedorController(FornecedorService fornecedorService) {
		super(fornecedorService);
	}

	@Override
	public ResponseEntity<?> salvarTodos(List<FornecedorDto> objetos, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizar(Fornecedor objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarTodos(List<Fornecedor> objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletar(Fornecedor objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletarTodos(List<Fornecedor> objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	


}
