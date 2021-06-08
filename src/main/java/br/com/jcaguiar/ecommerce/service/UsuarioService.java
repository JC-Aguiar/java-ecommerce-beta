package br.com.jcaguiar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.jcaguiar.ecommerce.model.Usuario;
import br.com.jcaguiar.ecommerce.repository.UsuarioRepository;

@Service
public class UsuarioService extends MasterService<Usuario, Integer> {
	
	public UsuarioService(UsuarioRepository userRepo) {
		super(userRepo);
	}

	@Override
	public Optional<Usuario> findByIdLimited(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAllLimited() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findByNomeContaining(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findByNomeContainingLimited(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
