package br.com.jcaguiar.ecommerce.dto;

import br.com.jcaguiar.ecommerce.model.Endereco;
import lombok.Getter;

@Getter
final public class TransportadorDto {
	
	String nome;
	Endereco endereco;
}
