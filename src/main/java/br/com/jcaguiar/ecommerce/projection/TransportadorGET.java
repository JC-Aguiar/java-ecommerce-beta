package br.com.jcaguiar.ecommerce.projection;

import br.com.jcaguiar.ecommerce.model.Endereco;

public interface TransportadorGET extends MasterGET {
	
	String getNome();
	Endereco getEndereco();
}
