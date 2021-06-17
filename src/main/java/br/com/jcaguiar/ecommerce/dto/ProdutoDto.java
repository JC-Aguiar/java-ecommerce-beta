package br.com.jcaguiar.ecommerce.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.jcaguiar.ecommerce.model.Categoria;
import br.com.jcaguiar.ecommerce.model.Fornecedor;
import br.com.jcaguiar.ecommerce.model.ImagemProduto;
import br.com.jcaguiar.ecommerce.model.Marca;
import lombok.Getter;

@Getter
final public class ProdutoDto {
	
	Categoria categoria;
	List<Marca> marca; //AJUSTAR MARCAS -> TRANSFORMAR EM OneToOne 1<->1
	Fornecedor fornecedor;
	String nome;
	String descricao;
	String modelo;
	BigDecimal valor;
	String tamanho;
	String medidas;
	int votos;
	int nota;
	List<ImagemProduto> imagem;
	
	public boolean disponivel(int estoque) {
		return estoque>0;
	}
	
}
