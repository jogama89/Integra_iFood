package com.integraDelivery.SID.domain.execption;

// 8.14. Desafio: implementando exception handler

public class ProductionNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public ProductionNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public ProductionNaoEncontradaException(Long cidadeId) {
		this(String.format("Não existe um cadastro de cidade com código %d", cidadeId));
	}
	
}
