package br.com.jcaguiar.ecommerce.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity(name = "fornece")
final public class Fornece {

	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Produto produto;
	
	@ManyToOne
	private Fornecedor fornecedor;
	private Timestamp data_fornece = new Timestamp( System.currentTimeMillis() );
	private Timestamp data_cancelado;
	
}
