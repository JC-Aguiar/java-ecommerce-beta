package br.com.jcaguiar.ecommerce.contorller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.modelmapper.ConfigurationException;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sun.el.parser.ParseException;

import br.com.jcaguiar.ecommerce.dto.MasterDto;
import br.com.jcaguiar.ecommerce.model.Entidade;
import br.com.jcaguiar.ecommerce.service.MasterService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor 
public abstract class MasterController<OBJ extends Entidade<ID>, ID, DTO extends MasterDto> {

	private final String PATH; 
	@Autowired private ModelMapper modelMapper;
	protected boolean admSql = true;
	private Class<DTO> classeDto;
	private Class<OBJ> classeObj;
	protected final MasterService<OBJ, ID> MASTER_SERVICE;
	private static final String ADM = "ADMIN";
	private static final String[] LOG = {
			"Consulta Completa",		//0
			"Consulta Restrita",		//1
			"Cadastro Criado",			//2
			"Cadastro Atualizado",		//3
			"Cadastro Excluído",		//4
			"Erro na Operação"			//5+
			};
	
	
	//CADASTRAR UM ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@PostMapping
	@Transactional
	public ResponseEntity<?> salvar(@RequestBody @Valid DTO objDto, HttpServletRequest request, UriComponentsBuilder uriBuilder) throws Exception {
		//Convertendo DTO e Salvando
		final OBJ OBJ_MODEL = converter(objDto);
		final ID OBJ_MODEL_ID = OBJ_MODEL.getId();
		MASTER_SERVICE.salvar(OBJ_MODEL);
		
		//Montando URI de retorno
		final String URL = String.format("/%s/{id}", PATH);
		URI uri = uriBuilder
				.path(URL)
				.buildAndExpand(OBJ_MODEL_ID)
				.toUri();
		
		//Retornando HttpStatus, Url e Objeto 
		return ResponseEntity
				.created(uri)
				.body(objDto);
	}

	
	//BUSCA TODOS ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@GetMapping
	public ResponseEntity<List<?>> buscarTodos(HttpServletRequest request) {
		final Sort ORDENE = Sort.by("id").ascending();
		
		if( request.isUserInRole(ADM) || admSql ) {
			log(0);
			List<?> objetos = MASTER_SERVICE.findAll(ORDENE);
			return new ResponseEntity<>(objetos, HttpStatus.OK);
		}
		log(1);
		List<?> objetosReport = MASTER_SERVICE.findAllLimited();
		
		return new ResponseEntity<>(objetosReport, HttpStatus.OK);
	}
	
	
	//BUSCA POR ID - EXATA ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@GetMapping("/id/{id}")
	public ResponseEntity<?> buscarId(@PathVariable(name = "id")ID id, HttpServletRequest request)
	throws NumberFormatException, ParseException {
		final Sort ORDENE = Sort.by("id").ascending();
		
		if( request.isUserInRole(ADM) || admSql) {
			log(0);
			final Optional<?> objeto = MASTER_SERVICE.findById(id);
			return new ResponseEntity<>(objeto, HttpStatus.OK);
		}
		log(1);
		final Optional<?> objetoReport = MASTER_SERVICE.findByIdLimited(id);
		
		return new ResponseEntity<>(objetoReport, HttpStatus.OK);
	}
	
	
	/**BUSCA POR NOME - POSSUI ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	 * Dependendo do login/perfil de quem fez a solicitação serão retornados diferentes campos da Entidade.
	 * @param nome
	 * @param request
	 * @return a list with entities and a http response
	 * @throws NumberFormatException
	 */
	@GetMapping("/nome/{nome}")
	public ResponseEntity<?> buscarNomeCom(@PathVariable(name = "nome")String nome, HttpServletRequest request)
	throws NumberFormatException {
		final Sort ORDENE = Sort.by("id").ascending();
		
		if( request.isUserInRole(ADM) || admSql) {
			log(0);
			final List<?> objetos = MASTER_SERVICE.findByNomeContaining(nome);
			return new ResponseEntity<>(objetos, HttpStatus.OK);
		}
		log(1);
		final List<?> objetosReport = MASTER_SERVICE.findByNomeContainingLimited(nome);
		
		return new ResponseEntity<>(objetosReport, HttpStatus.OK);
	}
	
	
	//BUSCA POR NOME - EXATA ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@GetMapping("/nome_exato/{nome}")
	public ResponseEntity<?> buscarNome(@PathVariable(name = "nome")String nome, HttpServletRequest request)
	throws NumberFormatException {
		final Sort ORDENE = Sort.by("id").ascending();
		
		if( request.isUserInRole(ADM) || admSql) {
			log(0);
			final List<?> objetos = MASTER_SERVICE.findByNome(nome);
			return new ResponseEntity<>(objetos, HttpStatus.OK);
		}
		log(1);
		final List<?> objetosReport = MASTER_SERVICE.findByNomeContaining(nome);
		
		return new ResponseEntity<>(objetosReport, HttpStatus.OK);
	}
	
	
	//ATUALIZA UM CADASTRO ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@PutMapping
	public abstract ResponseEntity<?> atualizar(@RequestBody @Valid OBJ objeto, HttpServletRequest request) throws Exception;
	
	
	//ATUALIZA MUITOS CADASTROS ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@PutMapping("/remover-e-ajustar")
	public abstract ResponseEntity<?> atualizarTodos(@RequestBody @Valid List<OBJ> objeto, HttpServletRequest request) throws Exception;
	
	
	//DELETA UM CADASTRO ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@DeleteMapping
	public abstract ResponseEntity<?> deletar(@RequestBody @Valid OBJ objeto, HttpServletRequest request) throws Exception;
	
	
	//DELETA MUITOS CADASTROS ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@DeleteMapping("/remover-e-ajustar")
	public abstract ResponseEntity<?> deletarTodos(@RequestBody @Valid List<OBJ> objeto, HttpServletRequest request) throws Exception;	
	
	
	//CONVERSOR UNITÁRIO: MODELO -> DTO ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	protected DTO converter(OBJ objeto) throws IllegalArgumentException, ConfigurationException, MappingException {
		return modelMapper.map(objeto, classeDto);
	}
	
	
	//CONVERSOR UNITÁRIO: DTO -> MODELO ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	protected OBJ converter(DTO objetoDto) throws IllegalArgumentException, ConfigurationException, MappingException {
		return modelMapper.map(objetoDto, classeObj);
	}
	
	
	//CONVERSOR PLURAL: DTOS -> MODELOS ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	protected List<OBJ> converterMuitos(List<DTO> objetosDto) throws IllegalArgumentException, ConfigurationException, MappingException {
		List<OBJ> objetosModel = new ArrayList<OBJ>();
		for(DTO dto : objetosDto) {
			objetosModel.add( modelMapper.map(dto, classeObj) );
		}
		return objetosModel;
	}
	
	
	//MENSAGENS DAS OPERAÇÕES ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/*Mensagens LOG:
	 * 0  "Consulta Completa"
	 * 1  "Consulta Restrita"
	 * 2  "Cadastro Criado", //2
	 * 3  "Cadastro Atualizado"
	 * 4  "Cadastro Excluído"
	 * 5+ "Log indefinido"
	 */
	protected final void log(int num) {
		num = num <= 4? num : 5;  
		System.out.printf("LOG: %s \n", LOG[num]);
	}
	protected final void log(int num, String texto) {
		num = num <= 4? num : 5;  
		System.out.printf("LOG: %s. %s \n", LOG[num], texto);
	}

}
