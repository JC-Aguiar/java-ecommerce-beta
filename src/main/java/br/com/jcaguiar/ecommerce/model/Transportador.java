package br.com.jcaguiar.ecommerce.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity(name = "transportador")
final public class Transportador {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@OneToOne
	private Endereco endereco;
	private String doc;
	private String razao_social;
	private String nome;
	private String ie;
	private String matriz;
	private boolean ativo;
	final private LocalDateTime data_cadastro = LocalDateTime.now();

}
