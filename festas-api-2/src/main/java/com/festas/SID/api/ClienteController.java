package com.festas.SID.api;

import java.io.Console;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.festas.SID.domain.execption.EntidadeEmUsoException;
import com.festas.SID.domain.execption.EntidadeNaoEncontradaException;
import com.festas.SID.domain.execption.NegocioException;
import com.festas.SID.domain.model.Cliente;
import com.festas.SID.domain.repository.ClienteRepository;
import com.festas.SID.domain.service.OperacoesDeClienteService;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;	
	
	@Autowired
	private OperacoesDeClienteService operacoesDeClienteService;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> adicionar(@RequestBody Cliente cliente) {
		try {
			
			Cliente clienteCadastrado = clienteRepository.consultarPorCpfCnpj(cliente.getCpf_cnpj());
			  		
 			if( clienteCadastrado != null) {
 				throw new NegocioException("Cliente já cadastrado com este CPF ou CNPJ !");
 			}
 			
			cliente = operacoesDeClienteService.salvar(cliente);
			return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
			 
		} catch (EntidadeNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}	
	
	@GetMapping("/{clienteId}")
	public Cliente buscar(@PathVariable Long clienteId) {
		return operacoesDeClienteService.buscarOuFalhar(clienteId);
	}
	
	@GetMapping("/filtrar/{nome}")
	public List<Cliente> cozinhasPorNome(@PathVariable String nome) {
		return clienteRepository.findTodasByNomeContaining(nome);
	}
	
	@PutMapping("/{clienteId}")
	public Cliente atualizar(@PathVariable Long clienteId,
			@RequestBody Cliente cliente) {
		try {
			Cliente clienteAtual = operacoesDeClienteService.buscarOuFalhar(clienteId);
			
			BeanUtils.copyProperties(cliente, clienteAtual, "id");

			return operacoesDeClienteService.salvar(clienteAtual);
		} catch (EntidadeNaoEncontradaException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	
	
	
	
	@PatchMapping("/{clienteId}")
	public Cliente atualizarParcial(@PathVariable Long clienteId,
			@RequestBody Map<String, Object> campos, HttpServletRequest request) {
		Cliente clienteAtual = operacoesDeClienteService.buscarOuFalhar(clienteId);
		
		merge(campos, clienteAtual, request);
		
		return atualizar(clienteId, clienteAtual);
	}	

	private void merge(Map<String, Object> dadosOrigem, Cliente clienteDestino,
			HttpServletRequest request) {
		ServletServerHttpRequest serverHttpRequest = new ServletServerHttpRequest(request);
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
			
			Cliente clienteOrigem = objectMapper.convertValue(dadosOrigem, Cliente.class);
			
			dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
				Field field = ReflectionUtils.findField(Cliente.class, nomePropriedade);
				field.setAccessible(true);
				
				Object novoValor = ReflectionUtils.getField(field, clienteOrigem);
				
				ReflectionUtils.setField(field, clienteDestino, novoValor);
			});
		} catch (IllegalArgumentException e) {
			Throwable rootCause = ExceptionUtils.getRootCause(e);
			throw new HttpMessageNotReadableException(e.getMessage(), rootCause, serverHttpRequest);
		}
	}	
	
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<?> remover(@PathVariable Long clienteId) {
				
		try {
			operacoesDeClienteService.excluir(clienteId);
				return ResponseEntity.noContent().build();			
		
		}catch (EntidadeNaoEncontradaException e) {		
			return ResponseEntity.notFound().build();
			
		}catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
		

	}
	
	
	
}
