package br.com.jcaguiar.ecommerce.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.Fornecedor;
import br.com.jcaguiar.ecommerce.service.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController extends MasterController<Fornecedor, Short> {

	public FornecedorController(FornecedorService fornecedorService) {
		super(fornecedorService);
	}

	


}
