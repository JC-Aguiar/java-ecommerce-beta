package br.com.jcaguiar.ecommerce.model;

import java.math.BigDecimal;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.jcaguiar.ecommerce.util.JsonConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
@Entity(name = "pedido_produto")
final public class PedidoProduto extends EntidadeData<Integer> {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	//ATRIBUTOS DIRETOS --------------------------------------------------------
	@Convert(converter = JsonConverter.class) private Categoria categoria;
	@Convert(converter = JsonConverter.class) private Marca marca;
	private String nome;
	private String descricao; 
	private String modelo;
	private BigDecimal valor;
	private short estoque;
	private String tamanho;
	private String medidas;
	private String material;
	private String codigo;
	
	//ATRIBUTOS INDIRETOS  -----------------------------------------------------
	@Convert(converter = JsonConverter.class) private Fornecedor fornece;
	@Convert(converter = JsonConverter.class) private ImagemProduto imagem;
}
