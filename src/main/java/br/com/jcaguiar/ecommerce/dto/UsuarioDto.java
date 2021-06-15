package br.com.jcaguiar.ecommerce.dto;

final public class UsuarioDto implements MasterDto {
	
	String email;

	@Override
	public boolean validar() {
		if ( email.isBlank() ) {
			return false;
		}
		return true;
	}

}
