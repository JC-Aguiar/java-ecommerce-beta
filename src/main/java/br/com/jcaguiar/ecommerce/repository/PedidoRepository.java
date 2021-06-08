package br.com.jcaguiar.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jcaguiar.ecommerce.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
