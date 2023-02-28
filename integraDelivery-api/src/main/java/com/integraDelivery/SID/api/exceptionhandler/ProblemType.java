package com.integraDelivery.SID.api.exceptionhandler;

import lombok.Getter;

// 8.20. Customizando exception handlers de ResponseEntityExceptionHandler

@Getter
public enum ProblemType {

	MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
	ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade não encontrada"),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
	ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio");
	
	private String title;
	private String uri;
	
	ProblemType(String path, String title) {
		// modificar esta caminho fixo para o local da minha API | EX: localhost:8080
		this.uri = "https://algafood.com.br" + path;
		this.title = title;
	}
	
}
