package br.com.jcaguiar.ecommerce.dto;

import javax.validation.constraints.NotNull;

import br.com.jcaguiar.ecommerce.model.Empresa;
import br.com.jcaguiar.ecommerce.model.Endereco;
import br.com.jcaguiar.ecommerce.model.Usuario;
import lombok.Getter;

@Getter
final public class CadastroFornecedorDto extends MasterDto {
	
	@NotNull Empresa<Short> empresa;
	@NotNull Usuario usuario;
	@NotNull Endereco endereco;

}
