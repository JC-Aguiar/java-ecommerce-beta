package br.com.jcaguiar.ecommerce.projection;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ComentarioGET implements MasterGET {

	private LocalDateTime data_cadastro;
	private ClientesGET cliente;
	private String texto;
	private long reply;
}
