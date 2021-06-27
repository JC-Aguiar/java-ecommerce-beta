package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.projection.MasterVO;

/** PADRÃO DE RETORNO PARA CONSULTAS
 * Inteface que define alguns padrões de consulta, permitindo
 * conversão automática de uma Entidade para DTO/VO.
 * Basta que o Repositório alvo defina o retorno dos métodos
 * com classes herdeiras da "MasterVO".
 * 
 * @author JM Costal Aguiar
 *
 * @param <OBJ> the name of Class Entity 
 * @param <ID> the id type of this same Class Entity
 */
@Repository
public interface MasterRepository<OBJ, ID> extends JpaRepository<OBJ, ID> {
	
	List<? extends MasterVO> findTodosAdm();
	
	List<? extends MasterVO> findTodos();
	
	MasterVO findIdAdm(ID id);
		
	MasterVO findId(ID id);
	
	MasterVO findEntidadeAdm(OBJ entidade);
	
	MasterVO findEntidade(OBJ entidade);
	
	List<? extends MasterVO> findByNomeAdm(String nome);

	List<? extends MasterVO> findByNome(String nome);
	
	List<? extends MasterVO> findByNomeContainingAdm(String nome);

	List<? extends MasterVO> findByNomeContaining(String nome);

}
