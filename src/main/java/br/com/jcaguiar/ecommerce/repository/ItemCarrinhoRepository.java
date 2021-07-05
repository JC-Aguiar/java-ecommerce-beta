package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.ItemCarrinho;
import br.com.jcaguiar.ecommerce.model.Usuario;
import br.com.jcaguiar.ecommerce.projection.ItemCarrinhoReport;

@Repository
public interface ItemCarrinhoRepository extends MasterRepository<ItemCarrinho, Long> {

	@Query("SELECT ic.produto.nome, ic FROM ItemCarrinho ic ")
	List<ItemCarrinhoReport> findTodosAdm();
	
	@Query("SELECT ic.produto.nome, ic.quantidade, ic.total, ic.data_carrinho "
			+ "FROM ItemCarrinho ic "
			+ "WHERE ic = ?1")
	ItemCarrinhoReport findItem(ItemCarrinho item);
	
	@Query("SELECT ic.produto.nome, ic.quantidade, ic.total, ic.data_carrinho "
			+ "FROM ItemCarrinho ic "
			+ "WHERE ic.id = ?1")
	ItemCarrinhoReport findItemId(long itemId);
	
	@Query("SELECT ic.produto.nome, ic.quantidade, ic.total, ic.data_carrinho "
			+ "FROM ItemCarrinho ic, usuario u "
			+ "WHERE ic.carrinho = u.carrinho "
			+ "AND u = ?1")
	List<ItemCarrinhoReport> findItensUsuario(Usuario usuario);
	
	@Query("SELECT ic.produto.nome, ic.quantidade, ic.total, ic.data_carrinho "
			+ "FROM ItemCarrinho ic, usuario u "
			+ "WHERE ic.carrinho = u.carrinho "
			+ "AND u.id = ?1")
	List<ItemCarrinhoReport> findItensUsuarioId(int usuarioId);
}
