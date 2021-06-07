package br.com.jcaguiar.ecommerce.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.Transportador;
import br.com.jcaguiar.ecommerce.service.TransportadorService;

@RestController
@RequestMapping("/transportador")
public class TransportadorController extends MasterController<Transportador, Short> {

	public TransportadorController(TransportadorService transpService) {
		super(transpService);
	}

}
