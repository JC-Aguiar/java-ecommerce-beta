package br.com.jcaguiar.ecommerce.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.Acesso;
import br.com.jcaguiar.ecommerce.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController extends MasterController<Acesso, Long> {

	public PedidoController(PedidoService pedidoService) {
		super(pedidoService);
	}

}
