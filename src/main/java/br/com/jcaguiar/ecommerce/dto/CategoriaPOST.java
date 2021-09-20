package br.com.jcaguiar.ecommerce.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;

@Getter
public final class CategoriaPOST extends MasterPOST {
	
	@NotNull @NotEmpty @Length(min = 1) String setor;
	@NotNull @NotEmpty @Length(min = 3) String nome;

}
