package br.com.jcaguiar.ecommerce.model;

import java.math.BigDecimal;
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
	
	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY) //PRECISA DE CASCATE?
	private final List<Pagamento> pagamento = new ArrayList<>();
	
	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY) //PRECISA DE CASCATE?
	private final List<NotaFiscal> nf = new ArrayList<>();
	
	//INFORMAÇÕES DO PEDIDO
	private String numero;
	private short status;
	private short quantidadeProdutos;
	private BigDecimal total;
	private LocalDateTime data_pedido = LocalDateTime.now();
	
	//INFORMAÇÕES DO PRODUTO
	private List<String> produtoNome = new ArrayList<>();
	private List<String> produtoModelo = new ArrayList<>();
	private List<String> produtoMarca = new ArrayList<>();
	private List<BigDecimal> produtoValor = new ArrayList<>();
	private List<String> produtoTamanho = new ArrayList<>();
	private List<String> produtoMedidas = new ArrayList<>();
	private List<String> produtoMaterial = new ArrayList<>();
	
	//INFORMAÇÕES DO COMPRADOR
	private String compradorNome;
	private String compradorDocumento;
	private String compradorEndereco;
	private String compradorCidade;
	private String compradorCep;
	private String compradorBairro;
	private String compradorPais;
	
	public void addProduto(String produtoNome, String produtoModelo, String produtoMarca, 
	BigDecimal produtoValor, String produtoTamanho, String produtoMedidas, String produtoMaterial) {
		this.produtoNome.add(produtoNome);
		this.produtoModelo.add(produtoModelo);
		this.produtoMarca.add( produtoMarca );
		this.produtoValor.add(produtoValor);
		this.produtoTamanho.add(produtoTamanho);
		this.produtoMedidas.add(produtoMedidas);
		this.produtoMaterial.add(produtoMaterial);
		quantidadeProdutos++;
	}
	
	public PedidoProdutoDto getProdutoDto(int index) {
		PedidoProdutoDto produto = PedidoProdutoDto.builder()
				.nome( getProdutoNome().get(index) )
				.modelo( getProdutoModelo().get(index) )
				.valor( getProdutoValor().get(index) )
				.tamanho( getProdutoTamanho().get(index) )
				.medidas( getProdutoMedidas().get(index) )
				.material( getProdutoMaterial().get(index) )
				.build();
		produto.setListaDeMarcas( getProdutoMarca().get(index) );
		return produto;
	}
	
	public List<PedidoProdutoDto> getAllProdutosDto() {
		List<PedidoProdutoDto> produtos = new ArrayList<PedidoProdutoDto>();
		for(int i = 0; i < quantidadeProdutos; i++) {
			PedidoProdutoDto prod = PedidoProdutoDto.builder()
						.nome( getProdutoNome().get(i) )
						.modelo( getProdutoModelo().get(i) )
						.valor( getProdutoValor().get(i) )
						.tamanho( getProdutoTamanho().get(i) )
						.medidas( getProdutoMedidas().get(i) )
						.material( getProdutoMaterial().get(i) )
						.build();
			prod.setListaDeMarcas( getProdutoMarca().get(i) );
			produtos.add(prod);
		}
		return produtos;
	}
	
}
