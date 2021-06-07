package br.com.jcaguiar.ecommerce.service;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jcaguiar.ecommerce.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Short> {

}
