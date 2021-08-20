package br.com.jcaguiar.ecommerce.security;

import br.com.jcaguiar.ecommerce.dto.MasterDto;
import lombok.Getter;

@Getter
public final class TokenDto extends MasterDto {

	public String token;
	public String tipo;
	
	public TokenDto(String token, String tipo) {
		this.token = token;
		this.tipo = tipo;
	}
}
