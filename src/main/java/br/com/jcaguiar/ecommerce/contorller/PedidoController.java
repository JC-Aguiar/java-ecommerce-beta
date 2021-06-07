package br.com.jcaguiar.ecommerce.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.Pedido;
import br.com.jcaguiar.ecommerce.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController extends MasterController<Pedido, Long> {

	public PedidoController(PedidoService pedidoService) {
		super(pedidoService);
	}

}
