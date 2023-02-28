package com.integraDelivery.SID.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integraDelivery.SID.domain.model.Polling;
import com.integraDelivery.SID.domain.repository.PollingRepository;

@Service
public class CadastroPollingService {

	@Autowired
	private PollingRepository pollingRepository;
	
	public Polling salvar(Polling polling) {
		return pollingRepository.save(polling);
	}
	
	
	
	
}
