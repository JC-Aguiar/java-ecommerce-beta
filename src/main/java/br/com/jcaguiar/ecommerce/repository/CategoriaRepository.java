package br.com.jcaguiar.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Categoria;
import br.com.jcaguiar.ecommerce.model.Setor;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Short> {
	
	Setor findByNome(String nome);
}
