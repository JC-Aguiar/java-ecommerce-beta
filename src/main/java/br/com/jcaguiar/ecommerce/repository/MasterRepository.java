package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository<OBJ, ID, VO, VO_BASIC> extends JpaRepository<OBJ, ID> {
	
	abstract List<VO> findTodos();
	
	abstract List<VO_BASIC> findTodosBasic();
	
	abstract VO findId(ID id);
	
	abstract VO_BASIC findIdBasic(ID id);
	
	abstract VO findEntidade(OBJ entidade);
	
	abstract VO_BASIC findEntidadeBasic(OBJ entidade);
	
	abstract List<VO> findByNome(String nome);

	abstract List<VO_BASIC> findByNomeBasic(String nome);
	
	abstract List<VO> findByNomeContaining(String nome);

	abstract List<VO_BASIC> findByNomeContainingBasic(String nome);

}
