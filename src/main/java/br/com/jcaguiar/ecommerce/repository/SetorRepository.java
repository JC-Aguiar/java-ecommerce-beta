package br.com.jcaguiar.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer> {
	
	Setor findByNome(String nome);
	
}
