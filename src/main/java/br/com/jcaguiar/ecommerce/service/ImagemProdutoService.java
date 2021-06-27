package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.ImagemProduto;
import br.com.jcaguiar.ecommerce.model.Produto;
import br.com.jcaguiar.ecommerce.repository.ImagemProdutoRepository;

@Service
public final class ImagemProdutoService extends MasterService<ImagemProduto, Long> {

	public ImagemProdutoService(ImagemProdutoRepository jpaRepo) {
		super(jpaRepo);
	}
	
	public List<ImagemProduto> findByProduto(Produto produto) {
		System.out.printf("CONSULTANDO IMAGENS\n");
		return ((ImagemProdutoRepository) JPA_REPO).findByProduto(produto);
	}

	@Override
	public Optional<?> findByIdUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> findAllBasic() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> findByNomeContaining(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> findByNomeContainingBasic(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
