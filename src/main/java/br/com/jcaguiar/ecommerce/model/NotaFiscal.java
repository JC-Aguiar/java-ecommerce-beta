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

import br.com.jcaguiar.ecommerce.Proprietario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "nota_fiscal")
final public class NotaFiscal implements Entidade<Long> {

	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;
	
	//INFORMAÇÕES DA NOTA
	private String numero;
	private String serie;
	private boolean nf_saida = true;	//false = ENTRADA[0]; true = SAÍDA[1]
	private LocalDateTime data_emissao = LocalDateTime.now();
	private LocalDateTime data_vencimento;
	private String nop;
	private BigDecimal total;
	
	//INFORMAÇÕES DO EMISSOR
	private String emissorNome = Proprietario.NOME;
	private String emissorDocumento = Proprietario.DOCUMENTO;
	private String emissorInscEstadual = Proprietario.INSCRICAO_ESTADUAL;
	private String emissorEndereco = Proprietario.ENDERECO;
	private String emissorBairro = Proprietario.BAIRRO;
	private String emissorCep = Proprietario.CEP;
	private String emissorCidade = Proprietario.CIDADE;
	private String emissorUf = Proprietario.UF;
	private String emissorContato = Proprietario.TELEFONE;
	
	//INFORMAÇÕES DO DESTINATÁRIO
	private String destinatarioNome;
	private String destinatarioDocumento;
	private String destinatarioEndereco;
	private String destinatarioBairro;
	private String destinatarioCep;
	private String destinatarioCidade;
	private String destinatarioUf;
	private String destinatarioComplemento;
	private String destinatarioInscEstadual;
	
	//INFORMAÇÕES DO TRANSPORTADOR
	private String transportadorNome;
	private String transportadorFrete;
	private String transportadorPlaca;
	private String transportadorDocumento;
	private String transportadorEndereco;
	private String transportadorCidade;
	private String transportadorUf;
	private String transportadorInscEstadual;
	
	//INFORMAÇÕES GERAIS DA MERCADORIA
	private short mercadoriaQuantidade;
	private String mercadoriaEspecie;
	private String mercadoriaMarca;
	private String mercadoriaNumeracao;
	private double mercadoriaPesoBruto;
	private double mercadoriaPesoLiquido;
	
	//INFORMAÇÕES DE CADA MERCADORIA
	private List<String> mercadoriaCodigo = new ArrayList<>();
	private List<String> mercadoriaDescricao = new ArrayList<>();
	private List<String> mercadoriaNcm = new ArrayList<>();
	private List<String> mercadoriaCst = new ArrayList<>();
	private List<String> mercadoriaCfop = new ArrayList<>();
	private List<String> mercadoriaUn = new ArrayList<>();
	private List<Short> mercadoriaQunantidade = new ArrayList<>();
	private List<BigDecimal> mercadoriaValorUnitario = new ArrayList<>();
	private List<BigDecimal> mercadoriaValorTotal = new ArrayList<>();
	private List<BigDecimal> mercadoriaIcmsBase = new ArrayList<>();
	private List<BigDecimal> mercadoriaIcmsTotal = new ArrayList<>();
	private List<BigDecimal> mercadoriaIcmsAliquota = new ArrayList<>();
	private List<BigDecimal> mercadoriaIpi = new ArrayList<>();
	private List<BigDecimal> mercadoriaIpiAliquota = new ArrayList<>();
}
