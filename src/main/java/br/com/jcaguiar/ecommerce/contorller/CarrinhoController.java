package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.dto.CarrinhoDto;
import br.com.jcaguiar.ecommerce.model.Carrinho;
import br.com.jcaguiar.ecommerce.service.CarrinhoService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController extends MasterController<Carrinho, Long, CarrinhoDto> {

	public CarrinhoController(CarrinhoService carrinhoService) {
		super(carrinhoService);
	}

	@Override
	public ResponseEntity<?> salvarTodos(List<CarrinhoDto> objetos, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizar(Carrinho objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarTodos(List<Carrinho> objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletar(Carrinho objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletarTodos(List<Carrinho> objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}




}
