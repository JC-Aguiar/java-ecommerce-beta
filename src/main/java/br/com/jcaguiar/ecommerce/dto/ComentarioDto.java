package br.com.jcaguiar.ecommerce.dto;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
final public class ComentarioDto extends MasterDto {
	
	String texto;
	long reply;
	LocalDateTime data_cadastro;
}
