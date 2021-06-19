package br.com.jcaguiar.ecommerce.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.jcaguiar.ecommerce.model.ItemCarrinho;

final public class CarrinhoDto extends MasterDto {
	
	List<ItemCarrinho> item;
	BigDecimal total;

}
