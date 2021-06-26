package br.com.jcaguiar.ecommerce.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.jcaguiar.ecommerce.model.Produto;
import lombok.Getter;

@Getter
final public class ProdutoDto extends MasterDto {
	
	int id;
	String categoria;
	String nome;
	String descricao;
	String modelo;
	BigDecimal valor;
	List<String> marca = new ArrayList<String>();
	List<String> fornacedor = new ArrayList<String>();
	String tamanho;
	String medidas;
	int estoque;
	int acessos;
	int votos;
	int nota;
	List<String> imagem = new ArrayList<String>();
	
	public ProdutoDto(Produto produto) {
		System.out.printf("CRIANDO DTO\n");
		this.id = produto.getId();
		this.categoria = produto.getCategoria().getNome();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.modelo = produto.getModelo();
		this.valor = produto.getValor();
		produto.getMarca().forEach(m->{
			this.marca.add( m.getNome() );
		});
		produto.getFornece().forEach(f->{
			this.fornacedor.add( f.getFornecedor().getNome() );
		});
		this.tamanho = produto.getTamanho();
		this.medidas = produto.getMedidas();
		this.estoque = produto.getEstoque();
		this.acessos = produto.getAcessos();
		this.votos = produto.getVotos();
		this.nota = produto.getNota();
		produto.getImagem().forEach(img->{
			this.imagem.add( img.getImagem() );
		});
	}
	
}
