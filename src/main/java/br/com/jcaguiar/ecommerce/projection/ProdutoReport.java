package br.com.jcaguiar.ecommerce.projection;

import java.util.List;

import br.com.jcaguiar.ecommerce.model.Categoria;
import br.com.jcaguiar.ecommerce.model.Fornece;
import br.com.jcaguiar.ecommerce.model.Marca;

public interface ProdutoReport {

	String getCategoria();
	List<String> getMarca();
	String getNome();
	String detDescricao();
	String getModelo();
	long getValor();
	int getEstoque();
	//int peso;
	//int altura;
	//int largura;
	//int cumprimento;
	//int acessos;
	//int votos;
	//int nota;
	String getImagem();
	
}
