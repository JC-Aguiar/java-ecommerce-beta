package br.com.jcaguiar.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
@Entity(name = "usuario")
public class Usuario extends EntidadeData<Integer> {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Carrinho carrinho;
	
	@Column(unique=true, nullable=false) //se tiver com problemas na persistência, remover/pesquisar
	private String email;
	private String senha;
	private boolean empresa;
	private String foto;

}
