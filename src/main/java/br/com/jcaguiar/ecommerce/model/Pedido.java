package br.com.jcaguiar.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.jcaguiar.ecommerce.dto.PedidoProdutoDto;
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
	
	private List<String> produtoNome = new ArrayList<>();
	private List<String> produtoModelo = new ArrayList<>();
	private List<String[]> produtoMarca = new ArrayList<>();
	private List<BigDecimal> produtoValor = new ArrayList<>();
	private List<String> produtoTamanho = new ArrayList<>();
	private List<String> produtoMedidas = new ArrayList<>();
	private List<String> produtoMaterial = new ArrayList<>();
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private final List<Pagamento> pagamento = new ArrayList<>();
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private final List<NotaFiscal> nf = new ArrayList<>();
	private short status;
	private BigDecimal total;
	private final LocalDateTime data_pedido = LocalDateTime.now();
	
	
	public void produto (String produtoNome, String produtoModelo, List<String> produtoMarca, 
	BigDecimal produtoValor, String produtoTamanho, String produtoMedidas, String produtoMaterial) {
		this.produtoNome.add(produtoNome);
		this.produtoModelo.add(produtoModelo);
		this.produtoMarca.add( (String[]) produtoMarca.toArray() );
		this.produtoValor.add(produtoValor);
		this.produtoTamanho.add(produtoTamanho);
		this.produtoMedidas.add(produtoMedidas);
		this.produtoMaterial.add(produtoMaterial);
	}
	
	public PedidoProdutoDto getProduto(int index) {
		return PedidoProdutoDto.builder()
				.nome( getProdutoNome().get(index) )
				.modelo( getProdutoModelo().get(index) )
				.marca( Arrays.asList( getProdutoMarca().get(index) ))
				.valor( getProdutoValor().get(index) )
				.tamanho( getProdutoTamanho().get(index) )
				.medidas( getProdutoMedidas().get(index) )
				.material( getProdutoMaterial().get(index) )
				.build();
	}
	
	public List<PedidoProdutoDto> getProduto() {
		List<PedidoProdutoDto> produtos = new ArrayList<PedidoProdutoDto>();
		produtos.addAll( 
				PedidoProdutoDto.builder()
					.nome( getProdutoNome() )
					.modelo( getProdutoModelo() )
					.marca( getProdutoMarca() ))
					.valor( getProdutoValor() )
					.tamanho( getProdutoTamanho() )
					.medidas( getProdutoMedidas() )
					.material( getProdutoMaterial() )
					.build()
				);
		return 
	}
	
}
