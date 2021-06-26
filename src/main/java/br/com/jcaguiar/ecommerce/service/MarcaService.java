package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Marca;
import br.com.jcaguiar.ecommerce.model.Produto;
import br.com.jcaguiar.ecommerce.repository.MarcaRepository;

@Service
public class MarcaService extends MasterService<Marca, Short> {

	public MarcaService(MarcaRepository jpaRepo) {
		super(jpaRepo);
	}
	
	public List<Marca> findByProduto(Produto produto){
		System.out.printf("CONSULTANDO MARCA\n");
		return ((MarcaRepository) JPA_REPO).findByProduto(produto);
	}

	@Override
	public Optional<?> findByIdLimited(Short id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> findAllLimited() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> findByNomeContaining(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> findByNomeContainingLimited(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
