package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jcaguiar.ecommerce.dto.CategoriaDto;
import br.com.jcaguiar.ecommerce.model.Categoria;
import br.com.jcaguiar.ecommerce.service.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController extends MasterController<Categoria, Short, CategoriaDto> {

	public CategoriaController(CategoriaService MASTER_SERVICE) {
		super("categoria", MASTER_SERVICE);
	}

	@Override
	public ResponseEntity<?> atualizar(@Valid Categoria objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarTodos(@Valid List<Categoria> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletar(@Valid Categoria objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletarTodos(@Valid List<Categoria> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Autowired
//	private CategoriaRepository categoriaRepo;
//	
//	@Autowired
//	private SetorRepository setorRepo;
//	
//	@GetMapping("add/{setorNome}/{categoriaNome}")
//	public ModelAndView add(@PathVariable String setorNome, @PathVariable String categoriaNome) {
//		String mensagem;
//		ModelAndView pagina = new ModelAndView("Generico/mensagem");
//		Setor setor = setorRepo.findByNome(setorNome);
//		if( setor != null ) {
//			if( categoriaRepo.findByNome(categoriaNome) == null ) {
//				Categoria categoria = Categoria.builder()
//						.setor(setor)
//						.nome(categoriaNome)
//						.build();
//				categoriaRepo.save(categoria);
//				mensagem = String.format("Categoria %s criado com sucesso.", categoria.getNome() );
//			}
//			else {
//				mensagem = "Já existe Categoria cadastrada com esse nome.";
//			}
//		}
//		else {
//			mensagem = "Esse Setor não existe.";
//		}
//		pagina.addObject("mensagem", mensagem);
//		return pagina;
//	}
	

}
