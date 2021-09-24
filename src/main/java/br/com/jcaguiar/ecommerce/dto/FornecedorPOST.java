package br.com.jcaguiar.ecommerce.dto;

import java.util.List;

import br.com.jcaguiar.ecommerce.model.Endereco;
import br.com.jcaguiar.ecommerce.model.Fornece;
import lombok.Getter;

@Getter
final public class FornecedorPOST extends MasterPOST {
	
	String nome;
	List<Fornece> fornece;
	Endereco endereco;
}
