package com.integraDelivery.SID.domain.execption;

// 8.14. Desafio: implementando exception handler

public class OrdersNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public OrdersNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public OrdersNaoEncontradaException(Long ordersId) {
		this(String.format("Não existe um cadastro de Orders com código %d", ordersId));
	}
	
}
