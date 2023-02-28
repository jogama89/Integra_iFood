package com.integraDelivery.SID.api.controller;

import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.common.io.BaseEncoding;
import com.integraDelivery.SID.domain.model.AccessToken;
import com.integraDelivery.SID.domain.model.Production;
import com.integraDelivery.SID.domain.repository.ProductionRepository;
import com.integraDelivery.SID.domain.service.CadastroProductionService;

// 8.12. Tratando exceções em nível de controlador com @ExceptionHandler

@RestController
@RequestMapping(value = "/production")
public class ProductionController {

	@Autowired
	private ProductionRepository productionRepository;
	
	@Autowired
	private CadastroProductionService cadastroProduction;	
	
/*
 	@GetMapping
	public List<Production> listar() {
		
		// System.out.println("TESTE 01: "+productionRepository.findAll());
		
		return productionRepository.findAll();
	}
 */
	
	
	
	
	@PutMapping("/{cozinhaId}")
	public Production atualizar(@PathVariable Long productionId,
			@RequestBody Production production) {
		Production productionAtual = cadastroProduction.buscarOuFalhar(productionId);
		
		BeanUtils.copyProperties(production, productionAtual, "id");
		
		return cadastroProduction.salvar(productionAtual);
	}
		
	
	
	
	
	
	
	@GetMapping
	public List<Production> postAccessToken(){
	
		Production production = new Production();
/*
 		production.setMerchantapihost("https://merchant-api.ifood.com.br");
		production.setGranttype("client_credentials");
		production.setClientid("e3d39334-dc18-4658-905b-07a41103a062");
		production.setClientsecret("n5rb7x3rvb90fd0zyokv0v3pjlirvyi8kyds3ijjh2t5696tohj28grjwo96krtntnqvgeb2wwzgzkazih8riamall5qxcea02l");
 */
		
		    for (Production prod : productionRepository.findAll()) {

		    	production = prod;
		    	System.out.println("------| prod |------");
		    	System.out.println("\r\n");
		    	System.out.println("getMerchantapihost..: "+prod.getMerchantapihost());
		    	System.out.println("getGranttype........: "+prod.getGranttype());
		    	System.out.println("getClientid.........: "+prod.getClientid());
		    	System.out.println("getClientsecret.....: "+prod.getClientsecret());
		    	System.out.println("\r\n");
		    	
		    }
 
		 
	
	AccessToken accessToken = new AccessToken();
	
	try {
	// Production production = new Production();
	/*
	
	production.setMerchantApiHost("https://merchant-api.ifood.com.br");
	production.setGrantType("client_credentials");
	production.setClientId("e3d39334-dc18-4658-905b-07a41103a062");
	production.setClientSecret("n5rb7x3rvb90fd0zyokv0v3pjlirvyi8kyds3ijjh2t5696tohj28grjwo96krtntnqvgeb2wwzgzkazih8riamall5qxcea02l");

	*/
	RestTemplate restTemplate = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	
	byte[] authorization = (production.getClientid() + ":" + production.getClientsecret()).getBytes("UTF-8");
	
	String base64Auth = BaseEncoding.base64().encode(authorization);
	 
	headers.add("Authorization", "Basic " + base64Auth);
	
	MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
	param.add("clientId", production.getClientid());
	param.add("clientSecret", production.getClientsecret());
	param.add("grantType", "client_credentials");
	param.add("uri", "https://merchant-api.ifood.com.br/authentication/v1.0/oauth/token");
	HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(param, headers);
	ResponseEntity<Map> response = restTemplate.postForEntity("https://merchant-api.ifood.com.br/authentication/v1.0/oauth/token", request , Map.class);
	
	// System.out.println("getStatusCode: " + response.getStatusCode());
	// System.out.println("getBody: " + response.getBody());
	
	 // cria o JSONObject
	   JSONObject obj = new JSONObject(response.getBody());
	   
	   		accessToken.setStatusCode(response.getStatusCode().toString());
	   
	 // verifica se possui a chave "nome"
	    if (obj.has("accessToken")) {
	    	accessToken.setAccessToken(obj.getString("accessToken"));
	    }		    
	    if (obj.has("type")) {
	    	accessToken.setType(obj.getString("type"));
	    }	
	    if (obj.has("expiresIn")) {
	    	accessToken.setExpiresIn(obj.getInt("expiresIn"));
	    }				    
	
	    
	    production.setAccesstoken(accessToken.getAccessToken());
	    System.out.println("getAccessToken: " + accessToken.getAccessToken());
	
	    cadastroProduction.salvar(production);
	    
	} catch (UnsupportedEncodingException e) {
	
	  System.out.println("getCause: " + e.getCause());
	  System.out.println("getMessage: " + e.getMessage());	
	  
	}
	
	return productionRepository.findAll();
	}	


	
	
	
	
	
	

	
}