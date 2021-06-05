package br.com.jcaguiar.ecommerce.contorller;
//
//package br.com.jcaguiar.ecommerce.contorller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import br.com.jcaguiar.ecommerce.model.Setor;
//import br.com.jcaguiar.ecommerce.repository.SetorRepository;
//
//@Controller
//@RequestMapping("**/login")
//public class LoginController {
//	
//	@Autowired
//	private SetorRepository setorRep;
//	
//	@GetMapping("add/{nome}")
//	public ModelAndView add(@PathVariable String nome) {
//		String mensagem;
//		ModelAndView pagina = new ModelAndView("Generico/mensagem");
//		if( setorRep.findByNome(nome) == null ) {
//			Setor setor = Setor.builder()
//					.nome(nome)
//					.build();
//			setorRep.save(setor);
//			mensagem = String.format("Setor %s criado com sucesso.", setor.getNome() );
//		}			
//		else {
//			mensagem = "Já existe Setor cadastrado com esse nome.";
//		}
//		pagina.addObject("mensagem", mensagem);
//		return pagina;
//	}
//	
//	
//	@GetMapping("del/{nome}")
//	public ModelAndView del(@PathVariable String nome) {
//		String mensagem;
//		ModelAndView pagina = new ModelAndView("Generico/mensagem");
//		if( setorRep.findByNome(nome) != null ) {
//			Setor setor = Setor.builder()
//					.nome(nome)
//					.build();
//			setorRep.delete(setor);
//			mensagem = String.format("Setor %s deletado com sucesso.", setor.getNome() );
//		}			
//		else {
//			mensagem = "Não existe Setor cadastrado com esse nome.";
//		}
//		pagina.addObject("mensagem", mensagem);
//		return pagina;
//	}
//
//}
