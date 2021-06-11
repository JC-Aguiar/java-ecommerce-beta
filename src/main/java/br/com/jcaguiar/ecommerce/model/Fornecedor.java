package br.com.jcaguiar.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
@Entity(name = "fornecedor")
final public class Fornecedor extends Empresa {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
	private final List<Fornece> fornece = new ArrayList<>();
	
	@OneToOne
	private Endereco endereco;


}
