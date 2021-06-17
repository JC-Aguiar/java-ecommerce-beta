package br.com.jcaguiar.ecommerce.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.jcaguiar.ecommerce.model.Categoria;
import br.com.jcaguiar.ecommerce.model.Fornecedor;
import br.com.jcaguiar.ecommerce.model.ImagemProduto;
import br.com.jcaguiar.ecommerce.model.Marca;

final public class CadastroProdutoDto {
	
	@NotNull Categoria categoria;
	@NotNull List<Marca> marca; //AJUSTAR MARCAS -> TRANSFORMAR EM OneToOne 1<->1
	@NotNull Fornecedor fornecedor;
	@NotNull @NotEmpty @Length(min = 2) String nome;
	@NotEmpty @Length(min = 10) String descricao;
	@NotNull @NotEmpty @Length(min = 2) String modelo;
	@NotNull @NotEmpty @Length(min = 1) BigDecimal valor;
	@NotNull @NotEmpty String tamanho;
	@NotNull @NotEmpty String medidas;
	@NotNull @NotEmpty List<ImagemProduto> imagem;

}
