package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.Transportador;
import br.com.jcaguiar.ecommerce.projection.TransportadorGET;
import br.com.jcaguiar.ecommerce.service.TransportadorService;

@RestController
@RequestMapping("/transp")
public class TransportadorController extends MasterController<Transportador, Short, TransportadorGET> {

	public TransportadorController(TransportadorService transpService) {
		super(Transportador.class, TransportadorGET.class, "transp", transpService);
	}

	@Override
	public ResponseEntity<?> atualizar(@Valid Transportador objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarTodos(@Valid List<Transportador> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletar(@Valid Transportador objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletarTodos(@Valid List<Transportador> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
