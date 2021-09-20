package br.com.jcaguiar.ecommerce.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.jcaguiar.ecommerce.model.Produto;
import br.com.jcaguiar.ecommerce.model.Usuario;
import lombok.Getter;

@Getter
final public class ComentarioPOST extends MasterPOST {
	
	@NotNull Usuario usuario;
	@NotNull Produto produto;
	@NotNull @NotEmpty @Length(min = 2) String texto;
	long reply;
}
