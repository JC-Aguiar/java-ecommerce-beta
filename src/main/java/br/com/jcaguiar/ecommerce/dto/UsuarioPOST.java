package br.com.jcaguiar.ecommerce.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

final public class UsuarioPOST extends MasterPOST {
	
	@NotNull @NotEmpty @Length(min = 7) String email;
	@NotNull @NotEmpty @Length(min = 6) String senha;

}
