package br.com.jcaguiar.ecommerce.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

final public class CadastroUsuarioDto implements MasterDto {
	
	@NotNull @NotEmpty @Length(min = 7) String email;
	@NotNull @NotEmpty @Length(min = 6) String senha;

	@Override
	public boolean validar() {
		if ( email.isBlank() ) {
			return false;
		}
		return true;
	}

}
