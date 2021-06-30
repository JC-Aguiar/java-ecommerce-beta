package br.com.jcaguiar.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Pedido;
import br.com.jcaguiar.ecommerce.projection.MasterVO;
import br.com.jcaguiar.ecommerce.repository.PedidoRepository;

@Service
public class PedidoService extends MasterService<Pedido, Long> {
	
	public PedidoService(PedidoRepository pedidoRepo) {
		super(pedidoRepo);
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
	public MasterVO findId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findIdAdm(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findEntidade(Pedido entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterVO findEntidadeAdm(Pedido entidade) {
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


}
