package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Categoria;
import br.com.jcaguiar.ecommerce.model.Setor;

@Repository
public interface CategoriaRepository extends MasterRepository<Categoria, Short> {
	
	List<Categoria> findAllBySetorAndNomeContaining(Setor setor, String nome);
	
//	List<Categoria> findAllByNomeContaining();
	
	Categoria findSetorAndNomeById(short id);;
	
	Categoria findSetorById(short id);
	
	Categoria findNomeById(short id);

}
