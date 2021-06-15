package br.com.jcaguiar.ecommerce.model;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class EntidadeData<ID> implements Entidade<ID> {
	
	private boolean ativo = true;
	private LocalDateTime data_cadastro = LocalDateTime.now();
	private LocalDateTime data_ativo;
	private LocalDateTime data_desativo;

}
