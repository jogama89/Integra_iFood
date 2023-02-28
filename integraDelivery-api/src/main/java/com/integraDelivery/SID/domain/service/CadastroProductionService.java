package com.integraDelivery.SID.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integraDelivery.SID.domain.execption.ProductionNaoEncontradaException;
import com.integraDelivery.SID.domain.model.Production;

import com.integraDelivery.SID.domain.repository.ProductionRepository;

// 8.15. Criando um exception handler global com ResponseEntityExceptionHandler

@Service
public class CadastroProductionService {

	@Autowired
	private ProductionRepository productionRepository;
	
	public Production salvar(Production cozinha) {
		return productionRepository.save(cozinha);
	}
	
	public Production buscarOuFalhar(Long productionId) {
		return productionRepository.findById(productionId)
			.orElseThrow(() -> new ProductionNaoEncontradaException(productionId));
	}
	
}