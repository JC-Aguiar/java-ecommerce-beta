package br.com.jcaguiar.ecommerce.model;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.jcaguiar.ecommerce.util.DataFormato;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
@Entity(name = "acesso")
final public class Acesso implements Entidade<Long> {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Produto produto;
	private String url;
	final private LocalDateTime data_acesso = LocalDateTime.now();
	private Duration duracao;
	
	public String print() throws ParseException {
		return String.format(
				"INTERCEPTADOR DE ACESSO {\n"
				+ "\tACESSO:   %s\n"
				+ "\tUSER:     %s\n"
				+ "\tURL:      %s\n"
				+ "\tDURAÇÃO:  %d.%ds\n"
				+ "}\n", 
				DataFormato.formatar(data_acesso), usuario.getEmail(), url, duracao.getSeconds(), duracao.getNano());
	}

}
