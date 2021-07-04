package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Cliente;
import br.com.jcaguiar.ecommerce.model.Comentario;
import br.com.jcaguiar.ecommerce.model.Produto;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
	
	List<Comentario> findClienteAndTextoAndReplyAndDataCadastroByProduto(Produto produto);
	
	List<Comentario> findClienteAndTextoAndReplyAndDataCadastroByProdutoId(int produtoId);
	
	List<Comentario> findProdutoAndTextoAndReplyAndDataCadastroByCliente(Cliente cliente);
	
	List<Comentario> findProdutoAndTextoAndReplyAndDataCadastroByClienteId(int clienteId);
}
