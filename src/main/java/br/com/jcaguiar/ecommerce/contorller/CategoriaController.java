package br.com.jcaguiar.ecommerce.contorller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.modelmapper.ConfigurationException;
import org.modelmapper.MappingException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.jcaguiar.ecommerce.dto.CadastroCategoriaDto;
import br.com.jcaguiar.ecommerce.model.Categoria;
import br.com.jcaguiar.ecommerce.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController extends MasterController<Categoria, Short, CadastroCategoriaDto> {

	public CategoriaController(CategoriaService categoriaService) {
		super(Categoria.class, CadastroCategoriaDto.class, "categoria", categoriaService);
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

	
	@Override
	protected Categoria converter(CadastroCategoriaDto objetoDto)
	throws IllegalArgumentException, ConfigurationException, MappingException {
		return modelMapper.map(objetoDto, Categoria.class);
	}
	
	@Override
	protected CadastroCategoriaDto converter(Categoria objeto)
	throws IllegalArgumentException, ConfigurationException, MappingException {
		return modelMapper.map(objeto, CadastroCategoriaDto.class);
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
