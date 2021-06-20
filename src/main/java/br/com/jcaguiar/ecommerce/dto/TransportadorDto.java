package br.com.jcaguiar.ecommerce.dto;

import br.com.jcaguiar.ecommerce.model.Endereco;
import lombok.Getter;

@Getter
final public class TransportadorDto extends MasterDto {
	
	String nome;
	Endereco endereco;
}
