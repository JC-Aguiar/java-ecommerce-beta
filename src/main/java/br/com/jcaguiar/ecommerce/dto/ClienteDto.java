package br.com.jcaguiar.ecommerce.dto;

import br.com.jcaguiar.ecommerce.model.Usuario;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteDto {

	private Usuario usuario;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String phone;
	
}
