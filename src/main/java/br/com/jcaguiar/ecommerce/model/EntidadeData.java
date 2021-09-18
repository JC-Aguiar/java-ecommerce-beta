package br.com.jcaguiar.ecommerce.model;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import br.com.jcaguiar.ecommerce.util.DataFormato;
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
	
	final protected boolean ativo = true;
	final protected LocalDateTime data_cadastro = DataFormato.now();
	final protected LocalDateTime data_ativo = DataFormato.now();
	protected LocalDateTime data_desativo;

}
