package br.com.jcaguiar.ecommerce.dto;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public final class PedidoProdutoDto extends MasterDto {
	
	private String nome;
	private String modelo;
	private String[] marca;
	private BigDecimal valor;
	private String tamanho;
	private String medidas;
	private String material;
	
	public final void setListaDeMarcas(String marcas) {
		this.marca = marcas.split(",");
	}

}
