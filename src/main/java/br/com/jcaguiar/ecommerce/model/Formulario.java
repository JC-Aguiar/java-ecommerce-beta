package br.com.jcaguiar.ecommerce.model;

import java.util.List;

final public class Formulario {
	
	private String[] nome;
	private String[] valor;
	
	public Formulario(int quant) {
		super();
		nome = new String[quant];
		valor = new String[quant];
	}

	public String[] getNome() {
		return nome;
	}

	public void setNome(String[] nome) {
		this.nome = nome;
	}

	public String[] getValor() {
		return valor;
	}

	public void setValor(String[] valor) {
		this.valor = valor;
	}
	
	

}
