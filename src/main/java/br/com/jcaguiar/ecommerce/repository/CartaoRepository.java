package br.com.jcaguiar.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Cartao;
import br.com.jcaguiar.ecommerce.projection.ProdutoAdmGET;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Integer> {
	
//	@Query(nativeQuery = true,
//			value = "SELECT cr.numero, cr.agencia, cr.data_validade "
//					+ "FROM cartao cr "
//					+ "WHERE cr.id = ?1")
//	ProdutoAdmGET findCartaoId(long id);
//	
//	ProdutoAdmGET findPagamentoById(long id);	//REVISAR! Talvez seja mais adequado na classe Pagamento

}
