package br.com.jcaguiar.ecommerce.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Entity(name = "pedido")
final public class Pedido {

	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Cliente cliente;
	
	@OneToOne
	private Carrinho carrinho;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<Pagamento> pagamento = new ArrayList<>();
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<NotaFiscal> nf = new ArrayList<>();
	private short status;
	private BigDecimal total;
	private Timestamp data_pedido = new Timestamp( System.currentTimeMillis() );	
}
