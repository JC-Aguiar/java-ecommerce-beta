package br.com.jcaguiar.ecommerce.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.Carrinho;
import br.com.jcaguiar.ecommerce.service.CarrinhoService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController extends MasterController<Carrinho, Long> {

	public CarrinhoController(CarrinhoService carrinhoService) {
		super(carrinhoService);
	}




}
