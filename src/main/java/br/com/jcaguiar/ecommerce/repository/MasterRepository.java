package br.com.jcaguiar.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/** PADRÃO DE RETORNO PARA CONSULTAS
 * Inteface que define alguns padrões de consulta, permitindo
 * conversão automática de uma Entidade para DTO/VO.
 * Basta que o Repositório alvo defina o retorno dos métodos
 * com classes herdeiras da "MasterGET".
 * 
 * @author JM Costal Aguiar
 *
 * @param <Produto> the name of Class Entity 
 * @param <ID> the id type of this same Class Entity
 */
@NoRepositoryBean
public interface MasterRepository<OBJ, ID> extends JpaRepository<OBJ, ID> {
	
//	List<? extends MasterGET> findTodosAdm();
//	
//	List<? extends MasterGET> findTodos();
//	
//	MasterGET findIdAdm(ID id);
//		
//	MasterGET findId(ID id);
//	
//	MasterGET findEntidadeAdm(Produto entidade);
//	
//	MasterGET findEntidade(Produto entidade);
	
//	List<? extends MasterGET> findByNomeAdm(String nome);
//
//	List<? extends MasterGET> findByNome(String nome);
//	
//	List<? extends MasterGET> findByNomeContainingAdm(String nome);
//
//	List<? extends MasterGET> findByNomeContaining(String nome);

}
