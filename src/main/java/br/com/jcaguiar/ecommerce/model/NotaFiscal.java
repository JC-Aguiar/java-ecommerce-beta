package br.com.jcaguiar.ecommerce.model;

import java.math.BigDecimal;
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

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity(name = "nota_fiscal")
final public class NotaFiscal implements Entidade<Long> {

	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Pedido pedido;
	
	@ManyToOne
	private Endereco endereco;
	
	@ManyToOne
	private Transportador transportador;
	
	private String numero;
	private String serie;
	//private BigDecimal valor;
	private final LocalDateTime data_emissao = LocalDateTime.now();
	private String nop;
	private BigDecimal total;
	
}
