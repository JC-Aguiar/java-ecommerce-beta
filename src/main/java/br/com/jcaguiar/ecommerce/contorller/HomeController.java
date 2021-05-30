package br.com.jcaguiar.ecommerce.contorller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.jcaguiar.ecommerce.model.Formulario;
import br.com.jcaguiar.ecommerce.model.Produto;
import br.com.jcaguiar.ecommerce.model.Setor;
import br.com.jcaguiar.ecommerce.repository.ProdutoRepository;

@Controller
@RequestMapping({"/"})
public class HomeController {
	
	@Autowired
	private ProdutoRepository produtoRep; 
	private ModelAndView modeloPagina;
	
	
	@GetMapping("home")
	public ModelAndView home() {
		modeloPagina = new ModelAndView("produtos");
		List<Produto> produtos = produtoRep.findAll();
		modeloPagina.addObject("produtos", produtos);
		modeloPagina.addObject("nome", "CASACOS E JAQUETAS");
		return modeloPagina;
	}
	
	@GetMapping("**/login")
	public String login(ModelAndView pagina) {
		return "login";
	}
	
	@GetMapping("**/logout")
	public ModelAndView logout(HttpServletRequest request) throws ServletException {
		request.logout();
		return home();
	}
	
	@GetMapping("adm")
	public ModelAndView add() {
		String mensagem = "ADM Logado";
		ModelAndView pagina = new ModelAndView("Generico/mensagem");
		pagina.addObject("mensagem", mensagem);
		return pagina;
	}
	
	@GetMapping("addProdutos")
	public ModelAndView addProdutos() {
		List<Produto> produto = new ArrayList<>();
		produto.add( Produto.builder()
				.nome("JAQUETA BOMBER COM ALGODÃO")
				.descricao("JAQUETA CONFECCIONADA EM UM TECIDO COM MISTURA DE ALGODÃO E LINHO. GOLA ELÁSTICA. MANGA COMPRIDA. BOLSOS DE DEBRUM NO QUADRIL. ACABAMENTOS COM NERVURAS. FECHO FRONTAL COM ZÍPER.")
				.valor(35900)
				.estoque(100)
				.imagem("https://static.zara.net/photos///2021/V/0/2/p/1564/480/401/2/w/1280/1564480401_6_3_1.jpg?ts=1618917880265")
				.build()
		);
		produto.add( Produto.builder()
				.nome("JAQUETA BOMBER COM ESTRUTURA")
				.descricao("JAQUETA CONFECCIONADA EM UM TECIDO DE ALGODÃO COM ELASTICIDADE. GOLA ALTA E MANGA COMPRIDA. BOLSOS DE DEBRUM NO QUADRIL. ACABAMENTOS COM NERVURAS. FECHO FRONTAL COM ZÍPER.")
				.valor(35900)
				.estoque(100)
				.imagem("https://static.zara.net/photos///2021/V/0/2/p/0706/477/442/2/w/1280/0706477442_6_3_1.jpg?ts=1614085735006")
				.build()
		);
		produto.add( Produto.builder()
				.nome("JAQUETA BOMBER COM EFEITO SUEDE")
				.descricao("JAQUETA DE GOLA ALTA E MANGA COMPRIDA COM ACABAMENTO COM NERVURAS. BOLSOS DE DEBRUM NO QUADRIL. PARTE INFERIOR COM ACABAMENTO EM ELÁSTICO. FECHO NA FRENTE COM ZÍPER.")
				.valor(35900)
				.estoque(100)
				.imagem("https://static.zara.net/photos///2021/W/0/2/p/3548/451/800/2/w/1280/3548451800_6_3_1.jpg?ts=1614946009893")
				.build()
		);
		produtoRep.saveAll(produto);
		return home();
	}

}
