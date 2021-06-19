package br.com.jcaguiar.ecommerce.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class ErroCadastroDto extends MasterDto {

	private final String campo;
	private final String mensagem;
	
}
