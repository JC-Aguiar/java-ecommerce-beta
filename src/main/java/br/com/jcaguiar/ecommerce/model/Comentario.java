package br.com.jcaguiar.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
@Entity(name = "comentario")
final public class Comentario extends EntidadeData<Long> {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Produto produto;
	private String texto;
	private long reply;
	//private final LocalDateTime data_cadastro = LocalDateTime.now();

}
