package br.com.jcaguiar.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "fornecedor")
final public class Fornecedor extends Empresa<Short> {
	
	@OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
	private final List<Fornece> fornece = new ArrayList<>();
	
	@OneToOne
	private Endereco endereco;

}
