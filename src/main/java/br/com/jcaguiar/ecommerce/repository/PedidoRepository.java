package br.com.jcaguiar.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jcaguiar.ecommerce.model.Acesso;

public interface PedidoRepository extends JpaRepository<Acesso, Long> {

}