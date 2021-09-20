package br.com.jcaguiar.ecommerce.contorller;

import java.net.URI;
import java.util.ArrayList;
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

import br.com.jcaguiar.ecommerce.Console;
import br.com.jcaguiar.ecommerce.model.Entidade;
import br.com.jcaguiar.ecommerce.projection.MasterGET;
import br.com.jcaguiar.ecommerce.projection.ProdutoAdmGET;
import br.com.jcaguiar.ecommerce.projection.ProdutoUserGET;
import br.com.jcaguiar.ecommerce.service.MasterService;
import lombok.RequiredArgsConstructor;

/**CONTROLADOR MODELO PADRÃO
 * Classe mãe que define o básico de todos os demais crontrollers
 * No construtor das classes herdeiras é necessário preencher
 * as seguintes variáveis (respectivamente):
 * 		<classeModelo> = Classe da Entidade que o controller gerencia 
 * 		
 * 		<classeDto> = Classe DTO da Entidade, usado para envio de requisições
 * 		
 * 		<URL> = Url (caminho relativo) em que este controller atua
 * 		
 * 		<MasterService> = Classe Service da Entidade, no qual o controller irá
 * 		solicitar para obter dados do Banco de Dados
 * 
 * Métodos:
 * 		>Retornar todos os cadastros
 * 		>Retornar cadastro por id
 * 		>Retornar cadastro(s) por nome
 * 		>Retornar cadastro(s) com nome
 * 		>Salvar um ou mais cadastros
 *  	>Atualizar um ou mais cadastros
 *   	>Deletar um ou mais cadasrtros
 *    	>Converter uma ou mais Entidades para DTO
 *     	>Converter um ou mais DTOs para Entidade
 * 
 * @author JM Costal Aguiar
 *
 * @param <OBJ> Genérico que representa a Entidade
 * @param <ID> Genérico que representa a Entidade
 * @param <DTO> Genérico que representa a Entidade
 */
@RestController
@RequiredArgsConstructor 
public abstract class MasterController<OBJ extends Entidade<ID>, ID, DTO> {

	protected boolean admSql = false;
	
	@Autowired protected ModelMapper modelMapper;
	protected final Class<OBJ> classeModelo;
	protected final Class<DTO> classeDto;
	private final String URL;
	protected final MasterService<OBJ, ID> MASTER_SERVICE;
	protected static final String ADM = "ROLE_ADM";
	private static final String[] LOG = {
										"Consulta Completa",		//0
										"Consulta Restrita",		//1
										"Cadastro Criado",			//2
										"Cadastro Atualizado",		//3
										"Cadastro Excluído",		//4
										"Erro na Operação"			//5+
										};
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**CADASTRAR UM 
	 * 
	 * @param dto
	 * @param request
	 * @param uriBuilder
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	@Transactional
	public ResponseEntity<?> salvar(@RequestBody @Valid DTO dto, HttpServletRequest request, UriComponentsBuilder uriBuilder)
	throws Exception {		
	//Convertendo DTO e Salvando
		final OBJ OBJ_MODEL = conversorEntidade(dto);
		final ID OBJ_MODEL_ID = (ID) OBJ_MODEL.getId();
		MASTER_SERVICE.salvar(OBJ_MODEL);
		
	//Montando URI de retorno
		final String PATH = String.format("/%s/{id}", URL);
		URI uri = uriBuilder
				.path(PATH)
				.buildAndExpand(OBJ_MODEL_ID)
				.toUri();
		
	//Retornando HttpStatus, URL e DTO 
		return ResponseEntity
				.created(uri)
				.body(dto);
	}

	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**BUSCA TODOS 
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping
	@Transactional
	public ResponseEntity<List<?>> buscarTodos(HttpServletRequest request) {
		//Preparando ordenação
		final Sort ORDENE = Sort.by("id").ascending();
		List<OBJ> entity;
		List<? extends MasterGET> dto;
		//Validando perfil do usuário
		if( request.isUserInRole(ADM) || admSql ) {
			//Consulta ADMIN
			log(0);
			Console.log("Coletando dados");
			entity = MASTER_SERVICE.findAll();
			Console.log("Convertendo dados");
			dto = conversorDto(entity, ProdutoAdmGET.class);
		}
		else {
			//Consulta USER
			log(1);
			Console.log("Coletando dados");
			entity = MASTER_SERVICE.findAll();
			Console.log("Convertendo dados");
			dto = conversorDto(entity, ProdutoUserGET.class);
		}
		Console.log("Reportando resposta");
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**BUSCA POR ID - EXATA 
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@GetMapping("/id/{id}")
	public ResponseEntity<?> buscarId(@PathVariable(name = "id")ID id, HttpServletRequest request) {
		//Preparando ordenação
		final Sort ORDENE = Sort.by("id").ascending();
		
		//Usuário da consulta ADMIN?
		if( request.isUserInRole(ADM) || admSql) {
			log(0);//Consulta ADMIN
			final Optional<?> OBJ_VO = MASTER_SERVICE.findById(id);
			return new ResponseEntity<>(OBJ_VO, HttpStatus.OK);
		}
		log(1);//Consulta USER
		final MasterGET OBJ_VO = MASTER_SERVICE.findId(id);
		
		return new ResponseEntity<>(OBJ_VO, HttpStatus.OK);
	}
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**BUSCA POR NOME - POSSUI
	 * Dependendo do login/perfil de quem fez a solicitação serão retornados diferentes campos da Entidade.
	 * @param nome
	 * @param request
	 * @return a list with entities and a http response
	 * @throws NumberFormatException
	 */
	@GetMapping("/nome/{nome}")
	public ResponseEntity<?> buscarNomeCom(@PathVariable(name = "nome")String nome, HttpServletRequest request) {
		final Sort ORDENE = Sort.by("id").ascending();
		
		if( request.isUserInRole(ADM) || admSql) {
			log(0);
			final List<?> objetos = MASTER_SERVICE.findByNomeContainingAdm(nome);
			return new ResponseEntity<>(objetos, HttpStatus.OK);
		}
		log(1);
		final List<?> objetosReport = MASTER_SERVICE.findByNomeContaining(nome);
		
		return new ResponseEntity<>(objetosReport, HttpStatus.OK);
	}
	
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**BUSCA POR NOME - EXATA 
	 * 
	 * @param nome
	 * @param request
	 * @return
	 * @throws NumberFormatException
	 */
	@GetMapping("/nome_exato/{nome}")
	public ResponseEntity<?> buscarNome(@PathVariable(name = "nome")String nome, HttpServletRequest request)
	throws NumberFormatException {
		final Sort ORDENE = Sort.by("id").ascending();
		
		if( request.isUserInRole(ADM) || admSql) {
			log(0);
			final List<?> objetos = MASTER_SERVICE.findByNomeAdm(nome);
			return new ResponseEntity<>(objetos, HttpStatus.OK);
		}
		log(1);
		final List<?> objetosReport = MASTER_SERVICE.findByNomeContainingAdm(nome);
		
		return new ResponseEntity<>(objetosReport, HttpStatus.OK);
	}
	
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**ATUALIZA UM CADASTRO 
	 * 
	 * @param objeto
	 * @param request
	 * @return
	 */
	@PutMapping
	public abstract ResponseEntity<?> atualizar(@RequestBody @Valid OBJ objeto, HttpServletRequest request);
	
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**ATUALIZA MUITOS CADASTROS 
	 * 
	 * @param objeto
	 * @param request
	 * @return
	 */
	@PutMapping("/remover-e-ajustar")
	public abstract ResponseEntity<?> atualizarTodos(@RequestBody @Valid List<OBJ> objeto, HttpServletRequest request);
	
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**DELETA UM CADASTRO 
	 * 
	 * @param objeto
	 * @param request
	 * @return
	 */
	@DeleteMapping
	public abstract ResponseEntity<?> deletar(@RequestBody @Valid OBJ objeto, HttpServletRequest request);
	
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**DELETA MUITOS CADASTROS 
	 * 
	 * @param objeto
	 * @param request
	 * @return
	 */
	@DeleteMapping("/remover-e-ajustar")
	public abstract ResponseEntity<?> deletarTodos(@RequestBody @Valid List<OBJ> objeto, HttpServletRequest request);	
	
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**CONVERSOR: ENTIDADE >>> DTO
	 * 
	 * @param object
	 * @param classGET
	 * @return
	 * @throws IllegalArgumentException
	 * @throws ConfigurationException
	 * @throws MappingException
	 */
	protected MasterGET conversorDto(OBJ object, Class<? extends MasterGET> classGET)
	throws IllegalArgumentException, ConfigurationException, MappingException {
		return modelMapper.map(object, classGET);
	}
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**CONVERSOR (LISTA): ENTIDADE >>> DTO 
	 * 
	 * @param object
	 * @param classGET
	 * @return
	 * @throws IllegalArgumentException
	 * @throws ConfigurationException
	 * @throws MappingException
	 */
	protected List<? extends MasterGET> conversorDto(List<OBJ> object, Class<? extends MasterGET> classGET)
	throws IllegalArgumentException, ConfigurationException, MappingException {
		List<MasterGET> dto = new ArrayList<>();
		for(OBJ obj : object) {
			dto.add(conversorDto(obj, classGET));
		}
		return dto;
	}
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**CONVERSOR: DTO >>> ENTIDADE
	 * 
	 * @param dto
	 * @return
	 * @throws IllegalArgumentException
	 * @throws ConfigurationException
	 * @throws MappingException
	 */
	protected OBJ conversorEntidade(DTO dto)
	throws IllegalArgumentException, ConfigurationException, MappingException {
		return modelMapper.map(dto, classeModelo);
	}
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/**CONVERSOR (LISTA): DTO >>> ENTIDADE
	 * 
	 * @param listaDto
	 * @return
	 * @throws IllegalArgumentException
	 * @throws ConfigurationException
	 * @throws MappingException
	 */
	protected List<OBJ> conversorEntidade(List<DTO> listaDto)
	throws IllegalArgumentException, ConfigurationException, MappingException {
		List<OBJ> listaObjects = new ArrayList<>();
		for(DTO dto : listaDto) {
			listaObjects.add(conversorEntidade(dto));
		}
		return listaObjects;
	}
	
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	/*MENSAGENS DAS OPERAÇÕES 
	 * Mensagens LOG:
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
