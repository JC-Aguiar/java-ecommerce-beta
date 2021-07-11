package br.com.jcaguiar.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
@Entity(name = "pedido")
final public class Pedido implements Entidade<Long> {

	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	//INFORMAÇÕES DO PEDIDO
	private String numero;
	private short status;
	private short quantidadeProdutos;
	private BigDecimal total;
	private LocalDateTime data_pedido = LocalDateTime.now();
	
	//INFORMAÇÕES DO PRODUTO
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<PedidoItem> itens = new ArrayList<>();
	
	//INFORMAÇÕES DO COMPRADOR
	private String compradorNome;
	private String compradorDocumento;
	private String compradorEndereco;
	private String compradorCidade;
	private String compradorCep;
	private String compradorBairro;
	private String compradorPais;
	
	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private final List<Pagamento> pagamento = new ArrayList<>();
	
	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private final List<NotaFiscal> nf = new ArrayList<>();
	
}
