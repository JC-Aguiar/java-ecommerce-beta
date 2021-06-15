package br.com.jcaguiar.ecommerce.model;

import javax.persistence.Entity;
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
@Entity(name = "transportador")
final public class Transportador extends Empresa<Short> {
	
	@OneToOne
	private Endereco endereco;

}
