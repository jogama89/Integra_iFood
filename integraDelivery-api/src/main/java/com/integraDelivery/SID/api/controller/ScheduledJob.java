package com.integraDelivery.SID.api.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.integraDelivery.SID.domain.model.Production;
import com.integraDelivery.SID.domain.repository.ProductionRepository;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

// https://www.youtube.com/watch?v=pqIa_ZGDW9E

@Component
public class ScheduledJob {

	
	@Autowired
	private ProductionRepository productionRepository;
	
	// Production production;

	private final String periodo = "0/30 * * * * *"; 
//	@Scheduled(cron = "0/1 * * * * *")
	@Scheduled(cron = periodo)
	public void execute() throws InterruptedException{
		
		System.out.println("Rodando: " + LocalTime.now());
		
		String  teste = "1";
		if( ! teste.equalsIgnoreCase("0")) {

			
			String accesstoken = productionRepository.findAll().get(0).getAccesstoken();
			
			System.out.println("\r\n");
			System.out.println("Accesstoken: "+accesstoken);
			System.out.println("\r\n");
		
			
		
			
			if(accesstoken != null ) {
	 			
				RestTemplate template = new RestTemplate();  
				
				// localhost:8080/orders
				UriComponents uri = UriComponentsBuilder.newInstance()
						.scheme("http")
//		 				.host("api.trello.com")
						.host("localhost:8080")
//						.path("1/boards/5abbe4b7ddc1b351ef961414")
						.path("orders")
						.queryParam("field","all")
						.build();
			
				ResponseEntity<Map> entity = template.getForEntity(uri.toUriString(), Map.class);
				
				System.out.println("getBody ==> "+entity.getBody());
			
				  				  				  
			}else {
				
				System.out.println("Accesstoken: "+accesstoken);
				
				
			}
			
			
			
		}
		
/*
	    for (Production prod : productionRepository.findAll()) {
	    	System.out.println("------| prod |------");
	    	System.out.println("\r\n");
	    	System.out.println("getMerchantapihost..: "+prod.getMerchantapihost());
	    	System.out.println("getGranttype........: "+prod.getGranttype());
	    	System.out.println("getClientid.........: "+prod.getClientid());
	    	System.out.println("getClientsecret.....: "+prod.getClientsecret());
	    	System.out.println("\r\n");
	    }		
 */
		
		
	}
 
	
	
	
	
	
	
    private static final String TIME_ZONE = "America/Sao_Paulo";
    
    // A cada 2 horas e 59 segundos, sera execultado !
    @Scheduled(cron = "0 59 0/2 * * *", zone = TIME_ZONE)
    //@Scheduled(cron = "0/1 * * * * *", zone = TIME_ZONE)
    public void verificaPorHora() { 
       System.out.println(LocalDateTime.now()); 
       // Código que realiza a consulta de fluxo de vendas 
       
		
       String  teste = "1";
		if( ! teste.equalsIgnoreCase("0")) {
		
			RestTemplate template = new RestTemplate();  
			
			// localhost:8080/orders
			UriComponents uri = UriComponentsBuilder.newInstance()
					.scheme("http")
//	 				.host("api.trello.com")
					.host("localhost:8080")
//					.path("1/boards/5abbe4b7ddc1b351ef961414")
					.path("production")
					.queryParam("field","all")
					.build();
		
			ResponseEntity<Map> entity = template.getForEntity(uri.toUriString(), Map.class);
			
			System.out.println("getBody ==> "+entity.getBody());
			
		}       
		 
       
    }
	
    
    
    
/*
     // Vai executar todos os dias, as 16 horas e 25 , minutos 
    @Scheduled(cron = "0 25 16 * * *", zone = TIME_ZONE)
    public void verificaPorHora() { 
       System.out.println(LocalDateTime.now()); 
       // Código que realiza a consulta de fluxo de vendas 
    }
	
 */
	
	
	
	
	
}
