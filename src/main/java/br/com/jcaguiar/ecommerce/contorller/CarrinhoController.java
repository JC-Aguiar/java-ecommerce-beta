package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
		super(Carrinho.class, CarrinhoDto.class, "carrinho", carrinhoService);
	}

	@Override
	public ResponseEntity<?> atualizar(@Valid Carrinho objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarTodos(@Valid List<Carrinho> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletar(@Valid Carrinho objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletarTodos(@Valid List<Carrinho> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}





}
