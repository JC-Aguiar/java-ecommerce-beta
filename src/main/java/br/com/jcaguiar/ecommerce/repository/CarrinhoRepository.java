package br.com.jcaguiar.ecommerce.repository;

import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Carrinho;

@Repository
public interface CarrinhoRepository extends MasterRepository<Carrinho, Long> {

}
