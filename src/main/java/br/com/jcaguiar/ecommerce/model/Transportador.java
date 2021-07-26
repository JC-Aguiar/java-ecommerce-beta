package br.com.jcaguiar.ecommerce.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
	
	@OneToOne(fetch = FetchType.LAZY)
	private Endereco endereco;
	
	@OneToMany(mappedBy = "transportador", fetch = FetchType.LAZY)
	private List<NotaFiscal> nf;

}
