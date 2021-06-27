package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Carrinho;
import br.com.jcaguiar.ecommerce.repository.CarrinhoRepository;

@Service
public class CarrinhoService extends MasterService<Carrinho, Long> {

	public CarrinhoService(CarrinhoRepository carrinhoRepo) {
		super(carrinhoRepo);
	}

	@Override
	public Optional<Carrinho> findByIdUser(Long id) {
		return null;
	}

	@Override
	public List<Carrinho> findAllBasic() {
		return null;
	}

	@Override
	public List<Carrinho> findByNomeContaining(String nome) {
		return null;
	}

	@Override
	public List<Carrinho> findByNomeContainingBasic(String nome) {
		return null;
	}

	@Override
	public List<Carrinho> findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
