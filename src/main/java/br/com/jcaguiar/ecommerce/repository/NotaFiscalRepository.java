package br.com.jcaguiar.ecommerce.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import br.com.jcaguiar.ecommerce.model.NotaFiscal;

@Repository
public interface NotaFiscalRepository extends MasterRepository<NotaFiscal, Long> {
	
	List<NotaFiscal> findByNumero(String numero);
	
	List<NotaFiscal> findByNumero(String numero, Sort sort);
		
	List<NotaFiscal> findByNumeroContaining(String numero);
	
	List<NotaFiscal> findByNumeroContaining(String numero, Sort sort);
	
	List<NotaFiscal> findBySerie(String numero);
	
	List<NotaFiscal> findBySerie(String numero, Sort sort);
	
	List<NotaFiscal> findByDataEmissao(LocalDateTime data_emissao);
		
	List<NotaFiscal> findByDataEmissao(LocalDateTime data_emissao, Sort sort);
	
	List<NotaFiscal> findByDataEmissaoBetween(LocalDateTime dataInicio, LocalDateTime dataFim);
	
	List<NotaFiscal> findByDataEmissaoBetween(LocalDateTime dataInicio, LocalDateTime dataFim, Sort sort);
	
	List<NotaFiscal> findByDestinatarioNomeContaining(String destinatarioNome);
	
	List<NotaFiscal> findByDestinatarioNomeContaining(String destinatarioNome, Sort sort);
	
	List<NotaFiscal> findByDestinatarioDocumentoContaining(String destinatarioDocumento);
		
	List<NotaFiscal> findByDestinatarioDocumentoContaining(String destinatarioDocumento, Sort sort);

}
