package com.integraDelivery.SID.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integraDelivery.SID.domain.execption.OrdersNaoEncontradaException;
import com.integraDelivery.SID.domain.model.Orders;
import com.integraDelivery.SID.domain.repository.OrdersRepository;

@Service
public class CadastroOrdersService {

	
	@Autowired
	private OrdersRepository ordersRepository;	
	
	
	public Orders salvar(Orders orders) {
		return ordersRepository.save(orders);
	}
	
	
	public Orders buscarOuFalhar(Long ordersId) {
		return ordersRepository.findById(ordersId)
			.orElseThrow(() -> new OrdersNaoEncontradaException(ordersId));
	}
	
	
	
}
