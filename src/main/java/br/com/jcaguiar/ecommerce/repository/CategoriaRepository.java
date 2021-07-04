package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Categoria;

@Repository
public interface CategoriaRepository extends MasterRepository<Categoria, Short> {
	
	List<Categoria> findSetorAndNome();
	
	List<Categoria> findNome();
	
	Categoria findSetorAndNomeById(short id);
	
	Categoria findSetorById(short id);
	
	Categoria findNomeById(short id);

}
