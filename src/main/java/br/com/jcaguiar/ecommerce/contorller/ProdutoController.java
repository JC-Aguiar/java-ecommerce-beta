package br.com.jcaguiar.ecommerce.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jcaguiar.ecommerce.repository.ProdutoRepository;

@Controller
@RequestMapping("produto")
public class ProdutoController {
	
	private ModelAndView modeloPagina;
	private ProdutoRepository produtoRep;
	
	@GetMapping("roupa/add")
	public ModelAndView roupaAdd() {
		modeloPagina = new ModelAndView("Produto/Roupa/formulario_roupa");
		
		return modeloPagina;
	}

}
