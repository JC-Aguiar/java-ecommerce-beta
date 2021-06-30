package br.com.jcaguiar.ecommerce.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Entity(name = "pagamento")
final public class Pagamento implements Entidade<Long> {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cartao cartao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;
	private byte parcelas;
	private final LocalDateTime data_pagamento = LocalDateTime.now();

}
