package br.com.jcaguiar.ecommerce.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.jcaguiar.ecommerce.model.ItemCarrinho;

final public class CarrinhoDto implements MasterDto {
	
	List<ItemCarrinho> item;
	BigDecimal total;

	@Override
	public boolean validar() {
		// TODO Auto-generated method stub
		return false;
	}

}
