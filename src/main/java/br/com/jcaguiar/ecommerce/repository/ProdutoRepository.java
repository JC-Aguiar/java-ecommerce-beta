package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Categoria;
import br.com.jcaguiar.ecommerce.model.Produto;
import br.com.jcaguiar.ecommerce.projection.ProdutoReport;

@Cacheable("Produto")
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	List<Produto> findByNomeContaining(String nome, Sort ordene);

	List<Produto> findByDescricaoContaining(String descricao, Sort ordene);

	List<Produto> findByModeloContaining(String modelo, Sort ordene);

	List<Produto> findByCategoriaContaining(Categoria categoria, Sort ordene);
	
	//ProdutoReport ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	
//	value = "SELECT  p.nome, p.valor, m.nome as marca, p.modelo, p.descricao, p.estoque, p.imagem, c.nome as categoria "
//			+ "FROM produto p, marca m, categoria c, produto_marca x "
//			+ "WHERE p.id = x.produto_id AND m.id = x.marca_id AND p.categoria_id = c.id")
	
	@Query(nativeQuery = true,
			value = "SELECT p.nome, p.valor, m.nome as marca, p.modelo, p.descricao, p.estoque, p.imagem, c.nome as categoria "
					+ "FROM produto_marca pm "
					+ "INNER JOIN marca m ON m.id = pm.marca_id "
					+ "INNER JOIN produto p ON p.id = pm.produto_id "
					+ "LEFT JOIN categoria c ON c.id = p.categoria_id")
	List<ProdutoReport> findAllLimited();

	@Query(nativeQuery = true,
			value = "SELECT p.nome, p.valor, m.nome as marca, p.modelo, p.descricao, p.estoque, p.imagem, c.nome as categoria "
					+ "FROM produto_marca pm "
					+ "INNER JOIN marca m ON m.id = pm.marca_id "
					+ "INNER JOIN produto p ON p.id = pm.produto_id "
					+ "LEFT JOIN categoria c ON c.id = p.categoria_id "
					+ "WHERE p.id = ?1")
	ProdutoReport findByIdLimited(int id);

	@Query(nativeQuery = true,
			value = "SELECT p.nome, p.valor, m.nome as marca, p.modelo, p.descricao, p.estoque, p.imagem, c.nome as categoria "
					+ "FROM produto_marca pm "
					+ "INNER JOIN marca m ON m.id = pm.marca_id "
					+ "INNER JOIN produto p ON p.id = pm.produto_id "
					+ "LEFT JOIN categoria c ON c.id = p.categoria_id "
					+ "WHERE p.nome like %?1%")
	List<ProdutoReport> findByNomeContainingLimited(String nome);

}
