package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Carrinho;
import br.com.jcaguiar.ecommerce.repository.CarrinhoRepository;
import br.com.jcaguiar.ecommerce.service.MasterService;

@Service
public class CarrinhoService extends MasterService<Carrinho, Long> {

	public CarrinhoService(CarrinhoRepository carrinhoRepo) {
		super(carrinhoRepo);
	}

	@Override
	public Optional<Carrinho> findByIdLimited(Long id) {
		return null;
	}

	@Override
	public List<Carrinho> findAllLimited() {
		return null;
	}

	@Override
	public List<Carrinho> findByNomeContaining(String nome) {
		return null;
	}

	@Override
	public List<Carrinho> findByNomeContainingLimited(String nome) {
		return null;
	}

	
	
}
