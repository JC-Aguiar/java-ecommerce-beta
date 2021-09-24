package br.com.jcaguiar.ecommerce.projection;

import lombok.Value;

@Value
final public class ForneceGET implements MasterGET {

	FornecedorGET fornecedor;
	
}
