package br.com.jcaguiar.ecommerce.dao;

import javax.persistence.EntityManager;

import br.com.jcaguiar.ecommerce.model.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDao {
	
	private EntityManager gerente;
	
	public ProdutoDao(EntityManager em) {
		gerente = em;
	}
	
	public void cadastrar(Produto produto) {
		gerente.persist(produto);
	}

}
