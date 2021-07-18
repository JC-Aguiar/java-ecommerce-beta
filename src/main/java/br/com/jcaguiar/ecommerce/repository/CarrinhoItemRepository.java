package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.CarrinhoItem;
import br.com.jcaguiar.ecommerce.model.Usuario;
import br.com.jcaguiar.ecommerce.projection.CarrinhoItemReport;

@Repository
public interface CarrinhoItemRepository extends MasterRepository<CarrinhoItem, Long> {

//    @Query("SELECT ci.produto.nome, ci FROM CarrinhoItem ci ")
//    List<CarrinhoItemReport> findTodosAdm();
//    
//    @Query("SELECT ci.produto.nome, ci.quantidade, ci.total, ci.data_carrinho "
//            + "FROM CarrinhoItem ci "
//            + "WHERE ci = ?1")
//    CarrinhoItemReport findItem(CarrinhoItem item);
//    
//    @Query("SELECT ci.produto.nome, ci.quantidade, ci.total, ci.data_carrinho "
//            + "FROM CarrinhoItem ci "
//            + "WHERE ci.id = ?1")
//    CarrinhoItemReport findItemId(long itemId);
//    
//    @Query("SELECT ci.produto.nome, ci.quantidade, ci.total, ci.data_carrinho "
//            + "FROM CarrinhoItem ci, usuario u "
//            + "WHERE ci.carrinho = u.carrinho "
//            + "AND u = ?1")
//    List<CarrinhoItemReport> findItensUsuario(Usuario usuario);
//    
//    @Query("SELECT ci.produto.nome, ci.quantidade, ci.total, ci.data_carrinho "
//            + "FROM CarrinhoItem ci, usuario u "
//            + "WHERE ci.carrinho = u.carrinho "
//            + "AND u.id = ?1")
//    List<CarrinhoItemReport> findItensUsuarioId(int usuarioId);
}
