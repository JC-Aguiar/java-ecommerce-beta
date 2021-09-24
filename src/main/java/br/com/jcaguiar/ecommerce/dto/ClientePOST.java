package br.com.jcaguiar.ecommerce.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.jcaguiar.ecommerce.model.Endereco;
import br.com.jcaguiar.ecommerce.model.Usuario;
import lombok.Getter;

@Getter
final public class ClientePOST extends MasterPOST {
	
	@NotNull Usuario usuario;
	@NotNull @NotEmpty @Length(min = 2) String nome;
	@NotNull @NotEmpty @Length(min = 2) String sobrenome;
	@NotNull @NotEmpty @Length(min = 11, max = 11) String cpf;
	@Length(min = 8, max = 13) String phone;
	@NotNull Endereco endereco;
//	String email;
//	String nome;
//	String sobrenome;
//	String phone;
//	String pais;
//	String estado;
}
