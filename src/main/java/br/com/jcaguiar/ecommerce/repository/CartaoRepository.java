package br.com.jcaguiar.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Integer> {

}
