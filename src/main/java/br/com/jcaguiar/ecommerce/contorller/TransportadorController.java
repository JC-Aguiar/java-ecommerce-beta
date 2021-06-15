package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.Transportador;
import br.com.jcaguiar.ecommerce.service.TransportadorService;

@RestController
@RequestMapping("/transportador")
public class TransportadorController extends MasterController<Transportador, Short, TransportadorDto> {

	public TransportadorController(TransportadorService transpService) {
		super(transpService);
	}

	@Override
	public ResponseEntity<?> salvarTodos(List<TransportadorDto> objetos, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizar(Transportador objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarTodos(List<Transportador> objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletar(Transportador objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletarTodos(List<Transportador> objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
