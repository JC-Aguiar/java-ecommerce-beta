package br.com.jcaguiar.ecommerce.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jcaguiar.ecommerce.model.Categoria;
import br.com.jcaguiar.ecommerce.model.Setor;
import br.com.jcaguiar.ecommerce.repository.CategoriaRepository;
import br.com.jcaguiar.ecommerce.repository.SetorRepository;

@Controller
@RequestMapping("categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Autowired
	private SetorRepository setorRepo;
	
	@GetMapping("add/{setorNome}/{categoriaNome}")
	public ModelAndView add(@PathVariable String setorNome, @PathVariable String categoriaNome) {
		String mensagem;
		ModelAndView pagina = new ModelAndView("Generico/mensagem");
		Setor setor = setorRepo.findByNome(setorNome);
		if( setor != null ) {
			if( categoriaRepo.findByNome(categoriaNome) == null ) {
				Categoria categoria = Categoria.builder()
						.setor(setor)
						.nome(categoriaNome)
						.build();
				categoriaRepo.save(categoria);
				mensagem = String.format("Categoria %s criado com sucesso.", categoria.getNome() );
			}
			else {
				mensagem = "Já existe Categoria cadastrada com esse nome.";
			}
		}
		else {
			mensagem = "Esse Setor não existe.";
		}
		pagina.addObject("mensagem", mensagem);
		return pagina;
	}
	

}
