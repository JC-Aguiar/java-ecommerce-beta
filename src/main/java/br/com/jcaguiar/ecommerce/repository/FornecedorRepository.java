package br.com.jcaguiar.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.com.jcaguiar.ecommerce.model.Fornecedor;

public interface FornecedorRepository extends MasterRepository<Fornecedor, Short> {
	
	//"SELECT f.id, f.ativo, f.razao_social, f.nome, f.ie, f.matriz, e as endereco as marca, "
	@Query("SELECT f, fr FROM fornecedor f LEFT JOIN fornece fr ON f = fr ")
	List<Fornecedor> findTodosAdm();
	
	@Query("SELECT f, fr FROM fornecedor f LEFT JOIN fornece fr ON f = fr WHERE f = ?1")
	Fornecedor findFornecedor(Fornecedor fornecedor);
	
	@Query("SELECT f, fr FROM fornecedor f LEFT JOIN fornece fr ON f = fr WHERE f = ?1")
	Fornecedor findFornecedorById(Fornecedor fornecedorId);
	
}
