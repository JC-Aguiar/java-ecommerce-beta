package br.com.jcaguiar.ecommerce.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public final class CadastroCategoriaDto extends MasterDto {
	
	@NotNull @NotEmpty @Length(min = 1) String setor;
	@NotNull @NotEmpty @Length(min = 3) String nome;

}
