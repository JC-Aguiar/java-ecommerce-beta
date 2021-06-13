package br.com.jcaguiar.ecommerce.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
@Entity(name = "produto")
final public class Produto extends EntidadeData<Integer> {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToMany
	private final List<Marca> marca = new ArrayList<>(); //AJUSTAR MARCAS -> TRANSFORMAR EM OneToOne 1<->1
	
	@OneToMany(mappedBy = "produto")
	private final List<Fornece> fornece = new ArrayList<>();
	private String nome;
	private String descricao;
	private String modelo;
	private BigDecimal valor;
	private int estoque;
	private String tamanho;
	private String medidas;
	private int acessos;
	private int votos;
	private int nota;
	
	@OneToMany(mappedBy = "produto")
	private List<ImagemProduto> imagem;
	
}
