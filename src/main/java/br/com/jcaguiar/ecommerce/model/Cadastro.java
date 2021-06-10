package br.com.jcaguiar.ecommerce.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
public abstract class Cadastro {
	
	private boolean ativo = true;
	private LocalDateTime data_cadastro = LocalDateTime.now();
	private LocalDateTime data_ativo;
	private LocalDateTime data_desativo;

}
