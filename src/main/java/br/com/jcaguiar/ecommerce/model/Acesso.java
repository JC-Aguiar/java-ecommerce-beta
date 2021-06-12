package br.com.jcaguiar.ecommerce.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

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
final public class Acesso {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Produto produto;
	private String url;
	final private LocalDateTime data_acesso = LocalDateTime.now();
	private Duration duracao;
	
	public String print() throws ParseException {
		DateTimeFormatter dataFormato = DateTimeFormatter.ofPattern("dd/MM/yy - HH:mm:ss (EEE)");
		return String.format(
				"Acesso: %s\n"
				+ "URL: %s\n"
				+ "Duração: %d.%d\n", data_acesso.format(dataFormato) , url, duracao.getSeconds(), duracao.getNano());
	}

}
