package br.com.jcaguiar.ecommerce.dto;

import br.com.jcaguiar.ecommerce.model.Usuario;
import lombok.Value;

@Value
public class ClienteLimitadoDto {
	
	Usuario usuario;
	String nome;
	String sobrenome;
	String cpf;
	String phone;

}
