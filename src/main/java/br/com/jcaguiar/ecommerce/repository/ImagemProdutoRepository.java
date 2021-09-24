package br.com.jcaguiar.ecommerce.repository;

import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.ImagemProduto;

@Repository
public interface ImagemProdutoRepository extends MasterRepository<ImagemProduto, Long> {
	
//	@Query("SELECT ip.imagem FROM imagem_produto ip WHERE ip.id = :produto")
//	List<ImagemProduto> findByProduto(Produto produto);
}
