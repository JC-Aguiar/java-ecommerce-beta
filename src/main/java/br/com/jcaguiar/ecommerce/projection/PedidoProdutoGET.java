package br.com.jcaguiar.ecommerce.projection;

import java.math.BigDecimal;
import java.util.List;

public interface PedidoProdutoGET extends MasterGET {
	
	String getNome();
	String getModelo();
	List<String> getMarca();
	BigDecimal getValor();
	String getTamanho();
	String getMedidas();
	String getMaterial();

}
