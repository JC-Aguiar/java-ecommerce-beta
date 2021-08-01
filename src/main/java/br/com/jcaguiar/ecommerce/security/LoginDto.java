package br.com.jcaguiar.ecommerce.security;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.jcaguiar.ecommerce.dto.MasterDto;
import lombok.Getter;

@Getter
public final class LoginDto extends MasterDto {
	
	@NotNull @NotEmpty @Length(min = 7) public String email;
	@NotNull @NotEmpty @Length(min = 7) public String senha;
	
	public UsernamePasswordAuthenticationToken autenticar() {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}
	
	

}
