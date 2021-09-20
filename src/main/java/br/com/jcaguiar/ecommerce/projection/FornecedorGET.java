package br.com.jcaguiar.ecommerce.projection;

import lombok.Value;

@Value
final public class FornecedorGET implements MasterGET {
	
	String nome;
	String doc;
	
}
