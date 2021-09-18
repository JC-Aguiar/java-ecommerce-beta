package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.Marca;
import br.com.jcaguiar.ecommerce.model.Produto;

@Repository
public interface MarcaRepository extends MasterRepository<Marca, Short> {
	
	@Query("SELECT m.nome FROM marca m WHERE m.id = 1")
	List<String> findMarcasDoProduto(Produto produto);
}
