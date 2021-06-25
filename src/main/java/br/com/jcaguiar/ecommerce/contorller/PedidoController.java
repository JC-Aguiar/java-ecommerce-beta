package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.dto.PedidoDto;
import br.com.jcaguiar.ecommerce.model.Pedido;
import br.com.jcaguiar.ecommerce.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController extends MasterController<Pedido, Long, PedidoDto> {

	public PedidoController(PedidoService pedidoService) {
		super(Pedido.class, PedidoDto.class, "pedido", pedidoService);
	}

	@Override
	public ResponseEntity<?> atualizar(@Valid Pedido objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarTodos(@Valid List<Pedido> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletar(@Valid Pedido objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletarTodos(@Valid List<Pedido> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
