package br.com.jcaguiar.ecommerce.service;

import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Transportador;
import br.com.jcaguiar.ecommerce.repository.TransportadorRepository;

@Service
public class TransportadorService extends MasterService<Transportador, Short> {

	public TransportadorService(TransportadorRepository transpRepo) {
		super(transpRepo);
	}

}
