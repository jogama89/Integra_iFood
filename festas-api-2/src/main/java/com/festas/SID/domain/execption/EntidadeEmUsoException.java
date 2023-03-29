package com.festas.SID.domain.execption;

//8.14. Desafio: implementando exception handler

public class EntidadeEmUsoException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public EntidadeEmUsoException(String mensagem) {
		super(mensagem);
	}
	
}