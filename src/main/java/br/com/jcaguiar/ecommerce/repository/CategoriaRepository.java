package br.com.jcaguiar.ecommerce.repository;

import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Categoria;

@Repository
public interface CategoriaRepository extends MasterRepository<Categoria, Short> {
	
//	List<Categoria> findAllBySetorAndNome();
//	
//	List<Categoria> findAllByNomeContaining();
	
	Categoria findSetorAndNomeById(short id);;
	
	Categoria findSetorById(short id);
	
	Categoria findNomeById(short id);

}
