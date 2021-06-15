package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.model.NotaFiscal;
import br.com.jcaguiar.ecommerce.service.NotaFiscalService;

@RestController
@RequestMapping("/nf")
public class NotaFiscalController extends MasterController<NotaFiscal, Long, NotaFiscalDto> {

	public NotaFiscalController(NotaFiscalService nfService) {
		super(nfService);
	}

	@Override
	public ResponseEntity<?> salvarTodos(List<NotaFiscalDto> objetos, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizar(NotaFiscal objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarTodos(List<NotaFiscal> objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletar(NotaFiscal objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletarTodos(List<NotaFiscal> objeto, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
