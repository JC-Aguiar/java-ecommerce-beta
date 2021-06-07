package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Pedido;

@Service
public class PedidoService extends MasterService<Pedido, Long> {
	
	public PedidoService(PedidoRepository pedidoRepo) {
		super(pedidoRepo);
	}

	@Override
	public Optional<Pedido> findByIdLimited(Long id) {
		return null;
	}

	@Override
	public List<Pedido> findAllLimited() {
		return null;
	}

	@Override
	public List<Pedido> findByNomeContaining(String nome) {
		return null;
	}

	@Override
	public List<Pedido> findByNomeContainingLimited(String nome) {
		return null;
	}

}
