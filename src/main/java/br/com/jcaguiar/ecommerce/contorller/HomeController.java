package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jcaguiar.ecommerce.model.Produto;
import br.com.jcaguiar.ecommerce.repository.ProdutoRepository;

@Controller
@RequestMapping({"/"})
public class HomeController {
//	
//	@Autowired
//	private ProdutoRepository produtoRep; 
//	private ModelAndView modeloPagina;
//	
//	
//	@GetMapping("home")
//	public ModelAndView home() {
//		modeloPagina = new ModelAndView("produtos");
//		List<Produto> produtos = produtoRep.findAll();
//		modeloPagina.addObject("produtos", produtos);
//		modeloPagina.addObject("nome", "CASACOS E JAQUETAS");
//		return modeloPagina;
//	}
//	
//	@GetMapping("**/login")
//	public String login(ModelAndView pagina) {
//		return "login";
//	}
//	
//	@GetMapping("**/logout")
//	public ModelAndView logout(HttpServletRequest request) throws ServletException {
//		request.logout();
//		return home();
//	}
//	
//	@GetMapping("adm")
//	public ModelAndView add() {
//		String mensagem = "ADM Logado";
//		ModelAndView pagina = new ModelAndView("Generico/mensagem");
//		pagina.addObject("mensagem", mensagem);
//		return pagina;
//	}

}
