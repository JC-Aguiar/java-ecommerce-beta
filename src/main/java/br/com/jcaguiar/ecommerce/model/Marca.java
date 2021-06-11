package br.com.jcaguiar.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity(name = "marca")
final public class Marca extends Cadastro {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	private String nome;
	
	@ManyToMany(mappedBy = "marca")
	private final List<Produto> produto = new ArrayList<>();
}
