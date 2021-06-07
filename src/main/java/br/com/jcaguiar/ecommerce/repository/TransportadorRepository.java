package br.com.jcaguiar.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Transportador;

@Repository
public interface TransportadorRepository extends JpaRepository<Transportador, Short> {

}
