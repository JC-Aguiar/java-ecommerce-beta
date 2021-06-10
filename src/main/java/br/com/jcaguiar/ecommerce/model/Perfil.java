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
@Entity(name = "perfil")
final public class Perfil {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private Usuario usuario;
	private String nome;
	final private LocalDateTime data_cadastro = LocalDateTime.now();
	private LocalDateTime data_removido;

}
