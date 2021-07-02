package br.com.jcaguiar.ecommerce.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;

@Builder
public final class PedidoProdutoDto extends MasterDto {
	
	private String nome;
	private String modelo;
	private List<String> marca = new ArrayList<>();
	private BigDecimal valor;
	private String tamanho;
	private String medidas;
	private String material;

}
