package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.ImagemProduto;
import br.com.jcaguiar.ecommerce.model.Produto;

@Repository
public interface ImagemProdutoRepository extends MasterRepository<ImagemProduto, Long> {
	
	@Query("SELECT ip.imagem FROM imagem_produto ip WHERE ip.produto = :produto")
	List<ImagemProduto> findByProduto(Produto produto);
}
