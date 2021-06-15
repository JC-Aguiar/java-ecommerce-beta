package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Transportador;
import br.com.jcaguiar.ecommerce.repository.TransportadorRepository;

@Service
public class TransportadorService extends MasterService<Transportador, Short> {

	public TransportadorService(TransportadorRepository transpRepo) {
		super(transpRepo);
	}

	@Override
	public Optional<Transportador> findByIdLimited(Short id) {
		return null;
	}

	@Override
	public List<Transportador> findAllLimited() {
		return null;
	}

	@Override
	public List<Transportador> findByNomeContaining(String nome) {
		return null;
	}

	@Override
	public List<Transportador> findByNomeContainingLimited(String nome) {
		return null;
	}

	@Override
	public List<Transportador> findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
