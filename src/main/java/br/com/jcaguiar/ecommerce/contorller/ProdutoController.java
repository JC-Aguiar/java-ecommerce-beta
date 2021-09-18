package br.com.jcaguiar.ecommerce.contorller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcaguiar.ecommerce.Console;
import br.com.jcaguiar.ecommerce.dto.ProdutoAdmDTO;
import br.com.jcaguiar.ecommerce.model.Categoria;
import br.com.jcaguiar.ecommerce.model.ImagemProduto;
import br.com.jcaguiar.ecommerce.model.Marca;
import br.com.jcaguiar.ecommerce.model.Produto;
import br.com.jcaguiar.ecommerce.model.Setor;
import br.com.jcaguiar.ecommerce.projection.ProdutoAdmReport;
import br.com.jcaguiar.ecommerce.projection.ProdutoUserReport;
import br.com.jcaguiar.ecommerce.service.CategoriaService;
import br.com.jcaguiar.ecommerce.service.ImagemProdutoService;
import br.com.jcaguiar.ecommerce.service.MarcaService;
import br.com.jcaguiar.ecommerce.service.ProdutoService;
import br.com.jcaguiar.ecommerce.service.SetorService;
import br.com.jcaguiar.ecommerce.util.LeitorCsv;
import br.com.jcaguiar.ecommerce.util.TratarString;

@RestController
@RequestMapping("**/produto")
public class ProdutoController extends MasterController<Produto, Integer, ProdutoAdmDTO>{
	
	@Autowired SetorService setorService;
	@Autowired CategoriaService categoriaService;
	@Autowired MarcaService marcaService;
	@Autowired ImagemProdutoService imgService;
	
	public ProdutoController(ProdutoService produtoService) {
		super(
				Produto.class,
				ProdutoAdmDTO.class,
				"produto",
				produtoService
		);
	}
	
	@Override
	@GetMapping
	@Transactional
	public ResponseEntity<List<?>> buscarTodos(HttpServletRequest request) {
		//Preparando ordenação
		final Sort ORDENE = Sort.by("id").ascending();
		
		//Usuário da consulta ADMIN?
		if( request.isUserInRole(ADM	) || admSql ) {
			log(0);//Consulta ADMIN
			List<ProdutoAdmReport> produtos =  ((ProdutoService) MASTER_SERVICE).findTodosAdm();			
			return new ResponseEntity<>(produtos, HttpStatus.OK);
		}
		log(1);//Consulta USER
		List<ProdutoUserReport> produtos = ((ProdutoService) MASTER_SERVICE).findTodos();
		return new ResponseEntity<>(produtos, HttpStatus.OK);
	}
	
	/** INSERIR PRODUTO VIA PLANILHA CSV
	 *
	 *
	 * SETOR
	 * 		Já existe Setor com mesmo nome?
	 * 		S: colete esse Setor
	 * 		N: crie essa Categoria
	 * 
	 * CATEGORIA
	 * 		Já existe Categoria com mesmo nome?
	 * 		S: colete essa Categoria
	 * 		N: crie essa Categoria
	 * 
	 * MARCA
	 * 		Já existe Marca com mesmo nome?
	 * 		S: colete essa Marca
	 * 		N: crie essa Marca
	 * 
	 * PRECO
	 * 		Apura se Preço é válido
	 * 
	 * ESTOQUE
	 * 		Apura se Estoque é válido
	 * 
	 * CODIGO EAN
	 * 		Apurar se o Código é válido
	 * 		Já existe EAN com mesmo número?
	 * 		S: Substitua os dados do produto
	 * 		N: Crie um novo produto
	 * 
	 * Classe TratarString
	 * 		getDepois:
	 * 		método estático que elimina todos os caracteres
	 * 		até a posição da string informada no parâmetro
	 * 		<targetCharSequence>
	 * 
	 * MARCA:
	 * 		TratarString.getDepois(":")
	 * 
	 * MATERIAIS:
	 * 		Divida a string em array por ","	
	 * 		TratarString.getDepois(":")
	 * 
	 * IMAGENS
	 * 		Dividir string em array por ","
	 * 		Adicionar os links aos já existentes
	 * 
	 */
	@PostMapping("/file")
	@Transactional
	public ResponseEntity<?> addCsv(@RequestBody String fileName) {
		Console.log("<IMPORTANDO-CSV>", +1);
		final LeitorCsv csv = new LeitorCsv(fileName);
		final List<String[]> arquivo = csv.getArquivo();		
		final List<Produto> produtos = new ArrayList<>();
		Console.log("Coletando planilha. Total de: " + arquivo.size() + " linhas");
		
		//Iterando linhas da planilha csv
		for(String[] linha : arquivo) {
			Console.log( Arrays.toString(linha) );
			//Iniciando variáveis
			final List<Marca> marcasFinal = new ArrayList<>();
			final List<ImagemProduto> imagensFinais = new ArrayList<>();
			final String setor = 		linha[0];		//Coluna A
			final String categoria = 	linha[1];		//Coluna B
			final String nome = 		linha[2];		//Coluna C
			final String descricao = 	linha[3];		//Coluna D
			final String marcas = 		linha[4];		//Coluna E
			final String modelo = 		linha[5];		//Coluna F
			final String preco = 		linha[6];		//Coluna G
			final String estoque = 		linha[7];		//Coluna H
			final String materiais = 	linha[8];		//Coluna I
			final String medidas = 		linha[9];		//Coluna J
			final String tamanho = 		linha[10];		//Coluna K
			final String ean = 			linha[11];		//Coluna L
			final String imagens = 		linha[12];		//Coluna M
			//Tratando campos numéricos
			final BigDecimal precoFinal = TratarString.paraBigDecimal(preco);
			final short estoqueFinal = Short.parseShort(estoque);
			final char tamanhoFinal = TratarString.sigla(tamanho);	
			//Criando Setor
			final Setor setorFinal = setorService.validarByNome(setor);
			//Criando Categoria
			final Categoria categoriaFinal = categoriaService
					.validarByNome(setorFinal, categoria);	
			//Criando Marcas
			final List<String> marcasArray = Arrays.asList(
					TratarString.getDepois(marcas,":")
					.split(",")
			);
			for(String mc : marcasArray) {
				marcasFinal.add( marcaService.validarByNome(mc) );
			}
			//marcasArray.forEach(mc -> marcasFinal.add( marcaService.validarByNome(mc) ));
			//Criando Imagens
			final List<String> imagensArray = Arrays.asList(imagens.split(","));
			for(String img : imagensArray) {
				imagensFinais.add( ImagemProduto.builder()
						.imagem(img)
						.build()
				);
			}
			//Criando Produtos
			Produto produto = Produto.builder()
					.categoria(categoriaFinal)
					.nome(nome)
					.descricao(descricao)
					.marca( marcaService.saveAll(marcasFinal) )
					.modelo(modelo)
					.valor(precoFinal)
					.estoque(estoqueFinal)
					.material(materiais)
					.medidas(medidas)
					.tamanho( String.valueOf(tamanhoFinal) )
					.codigo(ean)
					.imagem(imagensFinais)
					.build();
			//Populando na lista final de Produtos
			Console.log("Salvando produto");
			produtos.add( ((ProdutoService) MASTER_SERVICE).salvar(produto) );
			Console.log("Produto salvo com sucesso!");
			
		}
		
		//Terminando processo
		Console.log("</IMPORTANDO-CSV>", -1);
		Console.log("Retornando resposta ao cliente");
		//Console.log("TESTE MARCAS NO PRODUTO 1: " + produtos.get(0).getMarca().size() );
		return new ResponseEntity<>(produtos, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> atualizar(@Valid Produto objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarTodos(@Valid List<Produto> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletar(@Valid Produto objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}


	@DeleteMapping("/all")
	@Transactional
	public ResponseEntity<?> deletAll() {
		((ProdutoService) MASTER_SERVICE).removeAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deletarTodos(@Valid List<Produto> objeto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}


}
