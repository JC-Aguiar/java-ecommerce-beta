package br.com.jcaguiar.ecommerce.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@Entity(name = "pedido_produto")
@ToString
final public class PedidoProduto extends EntidadeData<Integer> {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	//ATRIBUTOS DIRETOS --------------------------------------------------------
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "pedido_produto_marca", 
		joinColumns = { @JoinColumn(name = "pedido_produto_id") },
		inverseJoinColumns = { @JoinColumn(name = "marca_id") })
	private List<Marca> marca = new ArrayList<>();
	private String nome;
	private String descricao; 
	private String modelo;
	private BigDecimal valor;
	private short estoque;
	private char tamanho;
	private String medidas;
	private String material;
	private String codigo;
	
	//ATRIBUTOS INDIRETOS  -----------------------------------------------------
	@OneToMany(fetch = FetchType.LAZY)
	private List<Fornece> fornece = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<ImagemProduto> imagem = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Comentario> comentario = new ArrayList<>();
	
	private int acessos;
	
	private int votos;
	
	private short nota;
}
