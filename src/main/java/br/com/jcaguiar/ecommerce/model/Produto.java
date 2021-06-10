package br.com.jcaguiar.ecommerce.model;

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
final public class Produto extends Cadastro {

	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToMany
	final private List<Marca> marca = new ArrayList<>();
	
	@OneToMany(mappedBy = "produto")
	final private List<Fornece> fornece = new ArrayList<>();
	private String nome;
	private String descricao;
	private String modelo;
	private long valor;
	private int estoque;
	private int peso;
	private int altura;
	private int largura;
	private int cumprimento;
	private int acessos;
	private int votos;
	private int nota;
	private String imagem;
	
}
