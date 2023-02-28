package com.integraDelivery.SID.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.integraDelivery.SID.domain.model.Polling;
import com.integraDelivery.SID.domain.repository.PollingRepository;
import com.integraDelivery.SID.domain.repository.ProductionRepository;
import com.integraDelivery.SID.domain.service.CadastroPollingService;


@RestController
@RequestMapping(value = "/polling")
public class PollingController {
	

	@Autowired
	private ProductionRepository productionRepository;

	@Autowired
	private PollingRepository pollingRepository;
	
	@Autowired
	private CadastroPollingService cadastroPolling;	
	
	
	@GetMapping
	public List<Polling> getPolling() {
	// https://cursos.alura.com.br/forum/topico-get-para-api-externa-com-bearer-e-response-como-list-91149
		
		RestTemplate restTemplate = new RestTemplate();
		
        // String accessToken = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzUxMiJ9.eyJzdWIiOiJlM2QzOTMzNC1kYzE4LTQ2NTgtOTA1Yi0wN2E0MTEwM2EwNjIiLCJhdWQiOlsic2hpcHBpbmciLCJjYXRhbG9nIiwiZmluYW5jaWFsIiwicmV2aWV3IiwibWVyY2hhbnQiLCJvcmRlciIsIm9hdXRoLXNlcnZlciJdLCJhcHBfbmFtZSI6ImpzZy1zb2Z0LXRlc3RlLWMiLCJvd25lcl9uYW1lIjoianNnLXNvZnQiLCJzY29wZSI6WyJzaGlwcGluZyIsImNhdGFsb2ciLCJyZXZpZXciLCJtZXJjaGFudCIsImNvbmNpbGlhdG9yIiwib3JkZXIiXSwiaXNzIjoiaUZvb2QiLCJtZXJjaGFudF9zY29wZSI6WyIwMzE1MGZkMy1jOWI2LTRmZWEtYWJkYi0zMDU4YjRiYmYwZWE6c2hpcHBpbmciLCIwMzE1MGZkMy1jOWI2LTRmZWEtYWJkYi0zMDU4YjRiYmYwZWE6bWVyY2hhbnQiLCIwMzE1MGZkMy1jOWI2LTRmZWEtYWJkYi0zMDU4YjRiYmYwZWE6Y2F0YWxvZyIsIjAzMTUwZmQzLWM5YjYtNGZlYS1hYmRiLTMwNThiNGJiZjBlYTpjb25jaWxpYXRvciIsIjAzMTUwZmQzLWM5YjYtNGZlYS1hYmRiLTMwNThiNGJiZjBlYTpyZXZpZXciLCIwMzE1MGZkMy1jOWI2LTRmZWEtYWJkYi0zMDU4YjRiYmYwZWE6b3JkZXIiXSwiZXhwIjoxNjYxMzYwOTYxLCJpYXQiOjE2NjEzMzkzNjEsImp0aSI6ImUzZDM5MzM0LWRjMTgtNDY1OC05MDViLTA3YTQxMTAzYTA2MiIsIm1lcmNoYW50X3Njb3BlZCI6dHJ1ZSwiY2xpZW50X2lkIjoiZTNkMzkzMzQtZGMxOC00NjU4LTkwNWItMDdhNDExMDNhMDYyIn0.tzTgpNJ7LGK8ojrnFeFjSBKXqA4OZjXAFU4YcfzmTEbGAuEANZ81RRzPIKvmhZSmK7CT2EcT91_-chSgkNO5LTGVAxLyscp4T2c3rb-QI64pSgAtvBt2-n1AT-GmMrYNh3r8hipQ9jXTqvqZs9iJ9E9H2KazBCtOGSTMmS18D6g"; 

		// id do merchants: 03150fd3-c9b6-4fea-abdb-3058b4bbf0ea
		
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        
        headers.add("Authorization", "Bearer "+productionRepository.findAll().get(0).getAccesstoken());

        RequestEntity<Object> request = new RequestEntity<>(
        /*
        Caso queira pegar as informaçõe de todos os types, é só tuilizar linha a baixo
        headers, HttpMethod.GET, URI.create("https://merchant-api.ifood.com.br/order/v1.0/events:polling?types=CON"));		
        */

        /*
        		 Joedson obrigada por aguarda, a informação é que só pelo portal
        		  você verifica o pedido, você pode baixar a planilha de pedidos 
        		  indo na aba financeiro, escolhe o período em que esse pedido foi realizado clica em ver detalhes e depois pedidos e busca pelo pedido e consegue verifica na pagina inicial tem opção de baixar, e se caso os pedidos que você quer ver não esteja nessa planilha você tem a opção de abrir chamado no portal e informa o numero dos pedidos que você quer verifica e o setor responsável pode esta te enviado.
        */
        		
  headers, HttpMethod.GET, URI.create("https://merchant-api.ifood.com.br/order/v1.0/events:polling?types=CON"));

        ResponseEntity<Polling[]> response = restTemplate.exchange(request, Polling[].class);
         
        int status = response.getStatusCodeValue();
	        
/*
		        System.out.println("\r\n");
		    System.out.println("Status: " + status);
		    System.out.println("\r\n");
*/
		    
	    if(status == 204 ) {
	    	// após 8:00horas da data da criação do pedido, A API não retorna o evento Polling
	    	System.out.println("\r\n");
	    	System.out.println("Status: "+status+": Não existe novos eventos");
	    	System.out.println("\r\n");
	    }else {
		    
			   for (Polling polling : response.getBody()) {
				   
				   System.out.println("getId			: " +  polling.getId());	
				   System.out.println("getCode			: " +  polling.getCode());
				   System.out.println("getFullCode		: " +  polling.getFullcode());
				   System.out.println("getOrderId		: " +  polling.getOrderid());	
				   System.out.println("getMerchantId		: " +  polling.getMerchantid());
				   System.out.println("getCreatedAt		: " +  polling.getCreatedat());
				   
				   System.out.println("\r\n");
				   
				   // vou testar passando o objeto da lista
				   cadastroPolling.salvar(polling);
				   
				   /*
				    fazer um Post para nao retorna o mesmo Polling
				   */
				   
			   }
	    	
	    	
	    }
	    
	    
	    return pollingRepository.findAll();        
    }
	
	
	

}
