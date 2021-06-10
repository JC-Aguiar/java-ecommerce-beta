package br.com.jcaguiar.ecommerce.model;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

}
