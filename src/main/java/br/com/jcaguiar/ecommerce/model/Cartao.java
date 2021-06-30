package br.com.jcaguiar.ecommerce.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
@Entity(name = "cartao")
final public class Cartao implements Entidade<Integer> {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "cartao", fetch = FetchType.LAZY)
	private final List<Pagamento> pagamento = new ArrayList<>();
	private String numero;
	private LocalDateTime data_validade;
	private String titular;
	private String cpf;	
	private String agencia;

}
