package br.com.jcaguiar.ecommerce.dto;

import br.com.jcaguiar.ecommerce.model.Categoria;

public final class CategoriaDto extends MasterDto {

	String setor;
	String nome;
	
	public CategoriaDto(Categoria categoria) {
		this.setor = categoria.getSetor().getNome(); 
		this.nome = categoria.getNome();
	}
	
}
