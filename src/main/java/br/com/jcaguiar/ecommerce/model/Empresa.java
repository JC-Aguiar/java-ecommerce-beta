package br.com.jcaguiar.ecommerce.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

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
@MappedSuperclass
public abstract class Empresa<ID> extends EntidadeData<ID> {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id;
	
	private String doc;
	private String razao_social;
	private String nome;
	private String ie;
	private boolean matriz;

	public ID getId() {
		return this.id;
	}

}
