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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
@Entity(name = "produto")
public class Produto extends EntidadeData<Integer> {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	// ATRIBUTOS DIRETOS --------------------------------------------------------
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(	name = "produto_marca",
				joinColumns = { @JoinColumn(name = "produto_id") },
				inverseJoinColumns = { @JoinColumn(name = "marca_id") })
	final private List<Marca> marca = new ArrayList<>();
	private String nome;
	private String descricao;
	private String modelo;
	private BigDecimal valor;
	private short estoque;
	private String tamanho;
	private String medidas;
	private String material;
	private String codigo;

	// ATRIBUTOS INDIRETOS -----------------------------------------------------
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	final private List<Fornece> fornece = new ArrayList<>();

	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	final private List<ImagemProduto> imagem = new ArrayList<>();

	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	final private List<Comentario> comentario = new ArrayList<>();
	private int acessos;
	private int votos;
	private short nota;

	public void setImagem(ImagemProduto img) {
		this.imagem.add(img);
	}

	public void setImagem(List<ImagemProduto> img) {
		this.imagem.addAll(img);
	}

	public void setMarca(Marca marca) {
		this.marca.add(marca);
	}

	public void setMarca(List<Marca> marca) {
		this.marca.addAll(marca);
	}
}
