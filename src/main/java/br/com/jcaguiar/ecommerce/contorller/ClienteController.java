package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.Cliente;
import br.com.jcaguiar.ecommerce.projection.ClientesInfoLimitada;
import br.com.jcaguiar.ecommerce.service.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	/** FINALIDADES
	 * 1) BUSCANDO POR USUÁRIOS
	 * 2) ACESSANDO DADOS DE UM USUÁRIO
	 * 3) ATUALIZANDO DADOS DE UM USUÁRIO
	 */
	
	@Autowired
	private ClienteService CLIENTE_SERVICE;
	
	//BUSCA GERAL
	@GetMapping
	public ResponseEntity<List<?>> findAll(HttpServletRequest request) {
		final Sort ORDENE = Sort.by("id").ascending();		
		if( request.isUserInRole("TESTE") ) {
			System.out.printf("Consulta ADMIN\n");
			List<Cliente> clientes = CLIENTE_SERVICE.findAll(ORDENE);
			return new ResponseEntity<>(clientes, HttpStatus.FOUND);
		}
		System.out.printf("Consulta USER\n");
		List<ClientesInfoLimitada> clientesLimit = CLIENTE_SERVICE.findAllLimited(ORDENE);
		return new ResponseEntity<>(clientesLimit, HttpStatus.FOUND);
		
				//		List<Cliente> clientes;
				//		for(ClientesInfoLimitada cl : clientesLimit) {
				//			clientes.add(
				//					Cliente.builder()
				//						.nome(cl.getNome())
				//						.sobrenome(cl.getSobrenome())
				//						.usuario(usuario)
				//			);
				//			
				//		}
	}
	

	
	
}
