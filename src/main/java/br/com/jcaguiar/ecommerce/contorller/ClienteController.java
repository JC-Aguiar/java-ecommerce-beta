package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.Cliente;
import br.com.jcaguiar.ecommerce.model.Usuario;
import br.com.jcaguiar.ecommerce.repository.ClienteRepository;
import br.com.jcaguiar.ecommerce.repository.UsuarioRepository;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	/** FINALIDADES
	 * 1) BUSCANDO POR USUÁRIOS
	 * 2) ACESSANDO DADOS DE UM USUÁRIO
	 * 3) ATUALIZANDO DADOS DE UM USUÁRIO
	 */
	
	@Autowired
	private UsuarioRepository usuarioRep;
	@Autowired
	private ClienteRepository clienteRep;
	
	//BUSCA GERAL
	@GetMapping
	public List<Cliente> findAll(HttpServletRequest request) {
		List<Cliente> clientes;
		final Sort ORDENE = Sort.by("id").ascending();		
		if( request.isUserInRole("TESTE") ) {
			System.out.printf("Consulta ADMIN\n");
			clientes = clienteRep.findAll(ORDENE);
		}
		else {
			System.out.printf("Consulta USER\n");
			clientes = clienteRep.findAllLimited();
		}
		return clientes;
	}
	
	//INSERE JOÃO
	@GetMapping("/add-nunca-mais-use-esse-metodo-louco")
	public List<Cliente> addCrazyNotUse() {
		Optional<Usuario> usuario = usuarioRep.findById(1);
		System.out.printf("Usuario email: %s\n", usuario.get().getEmail());
		Cliente cliente = Cliente.builder()
				.nome("João")
				.sobrenome("Costal Aguiar")
				.cpf("31746653884")
				.usuario(usuario.get())
				.sexo('M')
				.phone("51989087424")
				.build();
		System.out.println(cliente.toString());
		clienteRep.save(cliente);
		return clienteRep.findAll();
	}
	
	
}
