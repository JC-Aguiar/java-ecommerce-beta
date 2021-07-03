package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Carrinho;
import br.com.jcaguiar.ecommerce.projection.ProdutoAdmReport;

@Repository
public interface CarrinhoRepository extends MasterRepository<Carrinho, Long> {

	@Query(nativeQuery = true,
			value = "SELECT c.id, u as usuario, i as itens, c.total, c.quantidade "
					+ "FROM carrinho c "
					+ "LEFT JOIN usuario u ON c.id = u.carrinho_id "
					+ "LEFT JOIN item_carrinho i ON c.id = i.carrinho_id ")
	List<ProdutoAdmReport> findTodosAdm();
	
	@Query(nativeQuery = true,
			value = "SELECT i as itens, c.total, c.quantidade, c.avisos "
					+ "FROM carrinho c "
					+ "LEFT JOIN usuario u ON c.id = u.carrinho_id "
					+ "LEFT JOIN item_carrinho i ON c.id = i.carrinho_id "
					+ "WHERE c.id = ?1")
	List<ProdutoAdmReport> findCarrinhoId(long id);
	
	List<ProdutoAdmReport> findTotalAndQuantidadeById(long id);	

	List<ProdutoAdmReport> findTotalById(long id);
	
}
