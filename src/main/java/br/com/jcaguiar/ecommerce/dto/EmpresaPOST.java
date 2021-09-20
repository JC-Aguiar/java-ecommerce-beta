package br.com.jcaguiar.ecommerce.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

final public class EmpresaPOST extends MasterPOST {
	
	@NotNull @NotEmpty @Length(min = 2) String nome;
	@NotNull @NotEmpty @Length(min = 4) String razao_social;
	@NotNull @NotEmpty @Length(min = 9, max = 14) String doc;
	@Length(min = 9, max = 14) String ie;
	boolean matriz;

}
