package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.dto.CadastroCategoriaDto;
import br.com.jcaguiar.ecommerce.model.Categoria;
import br.com.jcaguiar.ecommerce.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController extends MasterController<Categoria, Short, CadastroCategoriaDto> {

	public CategoriaController(CategoriaService categoriaService) {
		super(Categoria.class, CadastroCategoriaDto.class, "categoria", categoriaService);
	}

	@Override
	public ResponseEntity<?> atualizar(@Valid Categoria objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarTodos(@Valid List<Categoria> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletar(@Valid Categoria objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletarTodos(@Valid List<Categoria> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
