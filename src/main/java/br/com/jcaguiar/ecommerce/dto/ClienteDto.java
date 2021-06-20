package br.com.jcaguiar.ecommerce.dto;

import lombok.Getter;

@Getter
final public class ClienteDto extends MasterDto {
	
	String email;
	String nome;
	String sobrenome;
	String phone;
	String pais;
	String estado;
}
