package br.com.jcaguiar.ecommerce.projection;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutoAdmReport {

	Integer getId();
	String getCategoria();
	String getNome();
	String detDescricao();
	String getModelo();
	BigDecimal getValor();
	List<String> getMarca();
	List<String> getFornece();
	String getTamanho();
	String getMedidas();
	int getEstoque();
	int getAcessos();
	int getVotos();
	int getNota();
	List<String> getImagem();
	
}
