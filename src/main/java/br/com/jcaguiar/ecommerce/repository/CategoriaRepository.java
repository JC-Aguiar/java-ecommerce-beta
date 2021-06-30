package br.com.jcaguiar.ecommerce.repository;

import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Categoria;

@Repository
public interface CategoriaRepository extends MasterRepository<Categoria, Short> {

}
