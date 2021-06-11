package br.com.jcaguiar.ecommerce.model;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Empresa extends Cadastro {
	
	private String doc;
	private String razao_social;
	private String nome;
	private String ie;
	private String matriz;

}
