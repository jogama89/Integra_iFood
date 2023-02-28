package com.integraDelivery.SID.domain.execption;

//8.14. Desafio: implementando exception handler

public class EntidadeNaoEncontradaException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
}