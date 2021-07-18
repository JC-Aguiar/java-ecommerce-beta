package br.com.jcaguiar.ecommerce.repository;

import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Pagamento;

@Repository
public interface PagamentoRepository extends MasterRepository<Pagamento, Long> {

}
