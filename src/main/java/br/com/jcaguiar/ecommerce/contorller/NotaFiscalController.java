package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.dto.NotaFiscalDto;
import br.com.jcaguiar.ecommerce.model.NotaFiscal;
import br.com.jcaguiar.ecommerce.service.NotaFiscalService;

@RestController
@RequestMapping("/nf")
public class NotaFiscalController extends MasterController<NotaFiscal, Long, NotaFiscalDto> {

	public NotaFiscalController(NotaFiscalService nfService) {
		super(NotaFiscal.class, NotaFiscalDto.class, "nf", nfService);
	}

	@Override
	public ResponseEntity<?> atualizar(@Valid NotaFiscal objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarTodos(@Valid List<NotaFiscal> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletar(@Valid NotaFiscal objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletarTodos(@Valid List<NotaFiscal> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
