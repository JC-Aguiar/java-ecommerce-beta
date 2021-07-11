package br.com.jcaguiar.ecommerce.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.jcaguiar.ecommerce.model.CarrinhoItem;

final public class CarrinhoDto extends MasterDto {
	
	List<CarrinhoItem> item;
	BigDecimal total;

}
