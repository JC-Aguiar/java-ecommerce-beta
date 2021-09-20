package br.com.jcaguiar.ecommerce.projection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
final public class CategoriaGET implements MasterGET {

	private SetorGET setor;
	private String nome;
	
}
