package br.com.jcaguiar.ecommerce.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
@Entity(name = "cliente")
final public class Cliente {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(mappedBy = "cliente")
	private Usuario usuario;
	
	@OneToOne
	private Endereco endereco;
	
	@OneToMany(fetch = FetchType.LAZY) @JoinColumn(name = "id")	//?
	private final List<Endereco> outrosEnderecos = new ArrayList<>();
	
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedido;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private final List<Cartao> cartao = new ArrayList<>();
	private String nome;
	private String sobrenome;
	private String cpf;
	private String phone;
	private LocalDateTime data_nascimento;
	private short idade;
	private char sexo;
	private short votos;

}
