package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Categoria;
import br.com.jcaguiar.ecommerce.model.Produto;
import br.com.jcaguiar.ecommerce.projection.ProdutoAdmGET;
import br.com.jcaguiar.ecommerce.projection.ProdutoUserGET;

@Repository
public interface ProdutoRepository extends MasterRepository<Produto, Integer> {
	
	@Query(nativeQuery = true,
			value = "SELECT p.id, c.nome as categoria, p.nome, p.descricao, p.modelo, p.valor, m.nome as marca, f.nome as fornacedor, "
					+ "p.tamanho, p.medidas, p.estoque, p.acessos, p.votos, p.nota, ip.imagem as imagem "
					+ "FROM produto_marca pm "
					+ "INNER JOIN marca m ON pm.marca_id = m.id "
					+ "INNER JOIN produto p ON p.id = pm.produto_id "
					+ "LEFT JOIN fornece fr ON p.id = fr.produto_id "
					+ "LEFT JOIN fornecedor f ON fr.fornecedor_id = f.id "
					+ "LEFT JOIN categoria c ON p.categoria_id = c.id "
					+ "LEFT JOIN imagem_produto ip ON p.id = ip.produto_id ")
	List<ProdutoAdmGET> findTodosAdm();
	
	@Query(nativeQuery = true,
			value = "SELECT c.nome as categoria, p.nome, p.descricao, p.modelo, p.valor, m.nome as marca, "
					+ "p.tamanho, p.medidas, p.votos, p.nota, ip.imagem as imagem "
					+ "FROM produto_marca pm "
					+ "INNER JOIN marca m ON m.id = pm.marca_id "
					+ "INNER JOIN produto p ON p.id = pm.produto_id "
					+ "LEFT JOIN imagem_produto ip ON p.id = ip.produto_id "
					+ "LEFT JOIN categoria c ON c.id = p.categoria_id")
	List<ProdutoUserGET> findTodos();
	
	List<Produto> findByNomeContaining(String nome, Sort ordene);

	List<Produto> findByDescricaoContaining(String descricao, Sort ordene);

	List<Produto> findByModeloContaining(String modelo, Sort ordene);

	List<Produto> findByCategoriaContaining(Categoria categoria, Sort ordene);
	

	@Query(nativeQuery = true,
			value = "SELECT p.nome, p.valor, m.nome as marca, p.modelo, p.descricao, p.estoque, c.nome as categoria, ip.imagem as imagem "
					+ "FROM produto_marca pm "
					+ "INNER JOIN marca m ON m.id = pm.marca_id "
					+ "INNER JOIN produto p ON p.id = pm.produto_id "
					+ "LEFT JOIN imagem_produto ip ON p.id = ip.produto_id "
					+ "LEFT JOIN categoria c ON c.id = p.categoria_id "
					+ "WHERE p.id = ?1")
	ProdutoUserGET findByIdLimited(int id);

	@Query(nativeQuery = true,
			value = "SELECT p.nome, p.valor, m.nome as marca, p.modelo, p.descricao, p.estoque, c.nome as categoria, ip.imagem as imagem "
					+ "FROM produto_marca pm "
					+ "INNER JOIN marca m ON m.id = pm.marca_id "
					+ "INNER JOIN produto p ON p.id = pm.produto_id "
					+ "LEFT JOIN imagem_produto ip ON p.id = ip.produto_id "
					+ "LEFT JOIN categoria c ON c.id = p.categoria_id "
					+ "WHERE p.nome like %?1%")
	List<ProdutoUserGET> findByNomeContainingLimited(String nome);

}
