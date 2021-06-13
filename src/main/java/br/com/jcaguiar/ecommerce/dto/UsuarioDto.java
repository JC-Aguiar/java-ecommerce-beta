package br.com.jcaguiar.ecommerce.dto;

public class UsuarioDto extends MasterDto {
	
	String email;

	@Override
	public boolean validar() {
		if ( email.isBlank() ) {
			return false;
		}
		return true;
	}

}
