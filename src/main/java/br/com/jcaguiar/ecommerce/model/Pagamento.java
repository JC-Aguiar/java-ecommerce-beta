package br.com.jcaguiar.ecommerce.model;

import java.math.BigInteger;
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
	private Pedido pedido;
	
	private String cartaoNumero;
	private LocalDateTime cartaoDataValidade;
	private String cartaoTitular;
	private String cartaoCpf;
	private String cartaoAgencia;
	private String cartaoToken;
	private byte parcelas;
	private BigInteger subtotal;
	private LocalDateTime data_pagamento = LocalDateTime.now();
	
	public void setPagamento(Cartao cartao, BigInteger subtotal, String token, byte parcelas) {
		this.cartaoNumero = cartao.getNumero();
		this.cartaoDataValidade = cartao. getData_validade();
		this.cartaoTitular = cartao.getTitular();
		this.cartaoCpf = cartao.getCpf();
		this.cartaoAgencia = cartao.getAgencia();
		this.subtotal = subtotal;
		this.cartaoToken = token;
		this.parcelas = parcelas;
	}

}
