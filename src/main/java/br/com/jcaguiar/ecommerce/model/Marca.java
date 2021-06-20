package br.com.jcaguiar.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
final public class Marca implements Entidade<Short> {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	private String nome;
	
	@ManyToMany(mappedBy = "marca")
	@JsonIgnore
	private final List<Produto> produto = new ArrayList<>();
}
