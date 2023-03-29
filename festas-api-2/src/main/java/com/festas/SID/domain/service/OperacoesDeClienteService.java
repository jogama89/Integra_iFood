package com.festas.SID.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.festas.SID.domain.repository.ClienteRepository;
import com.festas.SID.domain.execption.EntidadeEmUsoException;
import com.festas.SID.domain.execption.ClienteNaoEncontradaException;
import com.festas.SID.domain.execption.EntidadeNaoEncontradaException;
import com.festas.SID.domain.model.Cliente;

@Service
public class OperacoesDeClienteService {
	
	private static final String MSG_CLIENTE_EM_USO 
	= "Cliente de código %d não pode ser removido, pois está em uso";
	
	
	@Autowired
	private ClienteRepository clienteRepository;	
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}	
	
	
	
	public void excluir(Long clienteId) {
		try {
			clienteRepository.deleteById(clienteId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ClienteNaoEncontradaException(clienteId);
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeNaoEncontradaException(
				String.format(MSG_CLIENTE_EM_USO, clienteId));
		}
	}	
	
	
	
	public Cliente buscarOuFalhar(Long clienteId) {
		return clienteRepository.findById(clienteId)
			.orElseThrow(() -> new ClienteNaoEncontradaException(clienteId));
	}
	
	
	
		

}
