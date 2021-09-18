package br.com.jcaguiar.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.Console;
import br.com.jcaguiar.ecommerce.model.Marca;
import br.com.jcaguiar.ecommerce.model.Produto;
import br.com.jcaguiar.ecommerce.projection.MasterVO;
import br.com.jcaguiar.ecommerce.repository.MarcaRepository;

@Service
public class MarcaService extends MasterService<Marca, Short> {

	public MarcaService(MarcaRepository jpaRepo) {
		super(jpaRepo);
	}
	
	public List<Marca> findByProduto(Produto produto){
		System.out.printf("CONSULTANDO MARCA\n");
		List<Marca> marcas = new ArrayList<Marca>();
		List<String> nomes = ((MarcaRepository) JPA_REPO).findMarcasDoProduto( produto );
		nomes.forEach(n->{
			marcas.add( Marca.builder().nome(n).build() );
		});
		return marcas;
	}

	@Override
	public List<? extends MasterVO> findTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterVO> findTodos(Sort ordene) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterVO> findTodosAdm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterVO> findTodosAdm(Sort ordene) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findId(Short id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findIdAdm(Short id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findEntidade(Marca entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findEntidadeAdm(Marca entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterVO> findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterVO> findByNomeAdm(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterVO> findByNomeContaining(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MasterVO> findByNomeContainingAdm(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	public Marca validarByNome(String nome) {
		Console.log("<MARCA-SERVICE>", +1);
		List<Marca> marcas = findEntentyByNome(nome);
		Marca marca;
		if( marcas.size() == 0 ) {
			marca = Marca.builder()
					.nome(nome)
					.build();
			Console.log(String.format("Criada nova Marca: %s", nome));
		}
		else {
			marca = marcas.get(0);
			Console.log(String.format("Marca %s identificada", nome));
		}
		Console.log("</MARCA-SERVICE>", -1);
		return marca;
	}
	
	private List<Marca> findEntentyByNome(String nome) {
		List<Marca> marcas = ((MarcaRepository) JPA_REPO).findAllByNomeContaining(nome);
		Console.log("Marcas coletadas: " + marcas.size() );
		return marcas;
	}
	
	public void deletar(Marca marca) {
		((MarcaRepository) JPA_REPO).delete(marca);
	}

}
