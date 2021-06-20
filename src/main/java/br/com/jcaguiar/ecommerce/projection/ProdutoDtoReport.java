package br.com.jcaguiar.ecommerce.projection;

import java.util.List;

public interface ProdutoDtoReport {

	String getCategoria();
	List<String> getMarca();
	String getNome();
	String detDescricao();
	String getModelo();
	long getValor();
	int getEstoque();
	//String getTamanho();
	//String getMedidas();
	//int getAcessos();
	//int getVotos();
	//int getNota();
	List<String> getImagem();
	
}
