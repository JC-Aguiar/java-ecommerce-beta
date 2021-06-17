package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Fornecedor;
import br.com.jcaguiar.ecommerce.repository.FornecedorRepository;

@Service
public class FornecedorService extends MasterService<Fornecedor, Short> {

	public FornecedorService(FornecedorRepository fornecedorRepo) {
		super(fornecedorRepo);
	}

	@Override
	public Optional<Fornecedor> findByIdLimited(Short id) {
		return null;
	}

	@Override
	public List<Fornecedor> findAllLimited() {
		return null;
	}

	@Override
	public List<Fornecedor> findByNomeContaining(String nome) {
		return null;
	}

	@Override
	public List<Fornecedor> findByNomeContainingLimited(String nome) {
		return null;
	}

	@Override
	public List<Fornecedor> findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}