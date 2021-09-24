package br.com.jcaguiar.ecommerce.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.dto.ImagemProdutoPOST;
import br.com.jcaguiar.ecommerce.model.ImagemProduto;
import br.com.jcaguiar.ecommerce.service.ImagemProdutoService;

@RestController
@RequestMapping("**/imagem_produto")
public class ImagemProdutoController extends MasterController<ImagemProduto, Long, ImagemProdutoPOST> {

	public ImagemProdutoController(ImagemProdutoService imgService) {
		super(
			ImagemProduto.class,
			ImagemProdutoPOST.class,
			"imagem_produto",
			imgService
		);
	}
	
	@Override
	public ResponseEntity<List<?>> buscarTodos(HttpServletRequest request) {
		return new ResponseEntity<List<?>>(
			((ImagemProdutoService) MASTER_SERVICE).findAll(),
			HttpStatus.OK			
		);
	}

	@Override
	public ResponseEntity<?> atualizar(@Valid ImagemProduto objeto,
		HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarTodos(@Valid List<ImagemProduto> objeto,
		HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletar(@Valid ImagemProduto objeto,
		HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletarTodos(@Valid List<ImagemProduto> objeto,
		HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
