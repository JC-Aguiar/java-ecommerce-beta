package br.com.jcaguiar.ecommerce.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.NotaFiscal;
import br.com.jcaguiar.ecommerce.service.NotaFiscalService;

@RestController
@RequestMapping("/nf")
public class NotaFiscalController extends MasterController<NotaFiscal, Long> {

	public NotaFiscalController(NotaFiscalService nfService) {
		super(nfService);
	}

	
}
