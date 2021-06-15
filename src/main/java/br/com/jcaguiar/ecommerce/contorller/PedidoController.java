package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.Acesso;
import br.com.jcaguiar.ecommerce.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController extends MasterController<Acesso, Long, PedidoDto> {

	public PedidoController(PedidoService pedidoService) {
		super(pedidoService);
	}

	@Override
	public ResponseEntity<?> salvarTodos(List<PedidoDto> objetos, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizar(Acesso objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarTodos(List<Acesso> objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletar(Acesso objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletarTodos(List<Acesso> objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
