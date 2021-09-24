package br.com.jcaguiar.ecommerce.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter @NoArgsConstructor @AllArgsConstructor @FieldDefaults(level = AccessLevel.PRIVATE)
final public class ProdutoPOST extends MasterPOST {
	
	String categoria;
	List<String> marca;
	@Size(min = 3) String nome;									//@NotEmpty @NotNull @Size(min = 2) 
	@Size(min = 3) String descricao;
	@Min(value = 1) BigDecimal valor; 								//@NotEmpty @NotNull @Min(value = 1) @Max(value = 999999999) 
	@Size(min = 1, max = 1) String tamanho;									//@NotEmpty @NotNull @Size(min = 1, max = 1) 
	String medidas;
	String material;
	List<String> imagem;
	
	@Override 
	public String toString() {
		String stringMarcas = (marca == null) ? null : marca.toArray().toString();
		String stringImagens = (imagem == null) ? null : imagem.toArray().toString();
		
		return String.format(
			"Nome: %s\n"
			+ "Descrição: %s\n"
			+ "Marcas: %s\n"
			+ "Categoria: %s\n"
			+ "Valor: %d\n"
			+ "Tamanho: %s\n"
			+ "Medidas: %s\n"
			+ "Materiais: %s\n"
			+ "Imagens: %s\n", 
			nome, 
			descricao,
			stringMarcas,
			categoria,
			valor,
			tamanho,
			medidas,
			material,
			stringImagens
		);
	}
	
//	public ProdutoPOST(Produto produto) {
//		System.out.printf("CRIANDO DTO\n");
//		this.id = produto.getId();
//		this.categoria = produto.getCategoria().getNome();
//		this.nome = produto.getNome();
//		this.descricao = produto.getDescricao();
//		this.modelo = produto.getModelo();
//		this.valor = produto.getValor();
//		produto.getMarca().forEach(m->{
//			this.marca.add( m.getNome() );
//		});
//		produto.getFornece().forEach(f->{
//			this.fornacedor.add( f.getFornecedor().getNome() );
//		});
//		this.tamanho = produto.getTamanho();
//		this.medidas = produto.getMedidas();
//		this.estoque = produto.getEstoque();
//		this.acessos = produto.getAcessos();
//		this.votos = produto.getVotos();
//		this.nota = produto.getNota();
//		produto.getImagem().forEach(img->{
//			this.imagem.add( img.getImagem() );
//		});
//	}
	
}
