package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Categoria;
import br.com.jcaguiar.ecommerce.repository.CategoriaRepository;

@Service
public class CategoriaService extends MasterService<Categoria, Short> {

	public CategoriaService(CategoriaRepository jpaRepo) {
		super(jpaRepo);
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
