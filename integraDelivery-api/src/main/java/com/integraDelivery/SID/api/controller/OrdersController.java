package com.integraDelivery.SID.api.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.integraDelivery.SID.domain.model.Card;
import com.integraDelivery.SID.domain.model.Coordinates;
import com.integraDelivery.SID.domain.model.Customer;
import com.integraDelivery.SID.domain.model.Delivery;
import com.integraDelivery.SID.domain.model.Deliveryaddress;
import com.integraDelivery.SID.domain.model.Items;
import com.integraDelivery.SID.domain.model.Merchant;
import com.integraDelivery.SID.domain.model.Methods;
import com.integraDelivery.SID.domain.model.Payments;
import com.integraDelivery.SID.domain.model.Phone;
import com.integraDelivery.SID.domain.model.Polling;
import com.integraDelivery.SID.domain.model.Production;
import com.integraDelivery.SID.domain.model.Total;
import com.integraDelivery.SID.domain.repository.OrdersRepository;
import com.integraDelivery.SID.domain.repository.PollingRepository;
import com.integraDelivery.SID.domain.repository.ProductionRepository;
import com.integraDelivery.SID.domain.model.Orders;
import com.integraDelivery.SID.domain.service.CadastroOrdersService;

@RestController
@RequestMapping(value = "/orders")
public class OrdersController {
	
	
	@Autowired
	private CadastroOrdersService cadastroOrders;
	
	@Autowired
	private OrdersRepository ordersRepository;		
	
	@Autowired
	private ProductionRepository productionRepository;	
	
	@Autowired
	private PollingRepository pollingRepository;
	
	
	
	@PutMapping("/{ordersId}")
	public Orders atualizar(@PathVariable Long ordersId,
			@RequestBody Orders orders) {
		Orders ordersAtual = cadastroOrders.buscarOuFalhar(ordersId);
		
		BeanUtils.copyProperties(orders, ordersAtual, "orders_id");
		
		return cadastroOrders.salvar(ordersAtual);
	}
		
	
	@GetMapping
	public void getOrders(String token, String id) {
	// https://cursos.alura.com.br/forum/topico-get-para-api-externa-com-bearer-e-response-como-list-91149
		
/*
		token="eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzUxMiJ9.eyJzdWIiOiJlM2QzOTMzNC1kYzE4LTQ2NTgtOTA1Yi0wN2E0MTEwM2EwNjIiLCJhdWQiOlsic2hpcHBpbmciLCJjYXRhbG9nIiwiZmluYW5jaWFsIiwicmV2aWV3IiwibWVyY2hhbnQiLCJvcmRlciIsIm9hdXRoLXNlcnZlciJdLCJhcHBfbmFtZSI6ImpzZy1zb2Z0LXRlc3RlLWMiLCJvd25lcl9uYW1lIjoianNnLXNvZnQiLCJzY29wZSI6WyJzaGlwcGluZyIsImNhdGFsb2ciLCJyZXZpZXciLCJtZXJjaGFudCIsImNvbmNpbGlhdG9yIiwib3JkZXIiXSwiaXNzIjoiaUZvb2QiLCJtZXJjaGFudF9zY29wZSI6WyIwMzE1MGZkMy1jOWI2LTRmZWEtYWJkYi0zMDU4YjRiYmYwZWE6c2hpcHBpbmciLCIwMzE1MGZkMy1jOWI2LTRmZWEtYWJkYi0zMDU4YjRiYmYwZWE6bWVyY2hhbnQiLCIwMzE1MGZkMy1jOWI2LTRmZWEtYWJkYi0zMDU4YjRiYmYwZWE6Y2F0YWxvZyIsIjAzMTUwZmQzLWM5YjYtNGZlYS1hYmRiLTMwNThiNGJiZjBlYTpjb25jaWxpYXRvciIsIjAzMTUwZmQzLWM5YjYtNGZlYS1hYmRiLTMwNThiNGJiZjBlYTpyZXZpZXciLCIwMzE1MGZkMy1jOWI2LTRmZWEtYWJkYi0zMDU4YjRiYmYwZWE6b3JkZXIiXSwiZXhwIjoxNjYzMzkxMjg4LCJpYXQiOjE2NjMzNjk2ODgsImp0aSI6ImUzZDM5MzM0LWRjMTgtNDY1OC05MDViLTA3YTQxMTAzYTA2MiIsIm1lcmNoYW50X3Njb3BlZCI6dHJ1ZSwiY2xpZW50X2lkIjoiZTNkMzkzMzQtZGMxOC00NjU4LTkwNWItMDdhNDExMDNhMDYyIn0.KowVJDIOUMejDQQmB4qY1UDFWXGw5dWUO2tKcq91s_CEjcQN2dQ5Hc2Et_jdoNYPdensaqvPFuN3XqGbYHVtvUZTGY1CgLyzjMtjBEQCzfm_UTtT4B4xUDU7dZx6eJr6yUTnSpHcW3Sg1g6t-evAS0EYaHJm-AkUgELneDAgXLU";
		id="1a8f34cf-e4b5-4cbd-af8f-15bf856076f3";
		
 */
		
			token	= productionRepository.findAll().get(0).getAccesstoken();
	    
	    	// fazer condição para lista que for null
		   for (Polling polling : pollingRepository.findAll()) {
			   
			    id=polling.getOrderid();
			   
				RestTemplate restTemplate = new RestTemplate();
				
		        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		        headers.add("Authorization", "Bearer "+token);
		        RequestEntity<Object> request = new RequestEntity<>(

//		        headers, HttpMethod.GET, URI.create("https://merchant-api.ifood.com.br/order/v1.0/orders/1edb7fbe-b43f-4ee7-97e5-dc52975ced91"));
		        headers, HttpMethod.GET, URI.create("https://merchant-api.ifood.com.br/order/v1.0/orders/"+id));
		        ResponseEntity<Map> response = restTemplate.exchange(request, Map.class);

		        /*
		        ResponseEntity<?> response = restTemplate.exchange(request, Map.class);   
		        Map<String,Object> campos = (Map<String, Object>) response.getBody();
		        campos.forEach((nomePropriedade,valorPropriedade) -> {
		        	System.out.println(nomePropriedade +" = "+valorPropriedade);
		        });

		         */
		        /*
		        ResponseEntity<String> response = restTemplate.exchange(request, String.class);   
		        String json = response.getBody();
		        System.out.println("\r\n");
			    System.out.println("Status: " + response.getStatusCode());
			    System.out.println("json: " + json);
			    System.out.println("\r\n");
			    Orders config = new Gson().fromJson(json, Orders.class);
			    System.out.println("getId: " + config.getId());
			    System.out.println("getId: " + config.getListaItems());
		         */

			 // cria o JSONObject
			   JSONObject obj = new JSONObject(response.getBody());
			    
			   // OrdersController
			   
			    Orders orders = new Orders();

			    // verifica se possui a chave "nome"
			    if (obj.has("id")) {
			    	orders.setId(obj.getString("id"));
			    }
			    
			    if (obj.has("displayId")) {
			    	orders.setDisplayid(obj.getString("displayId"));
			    }
			    if (obj.has("createdAt")) {
			    	orders.setCreatedat(obj.getString("createdAt"));
			    }
			    if (obj.has("salesChannel")) {
			    	orders.setSaleschannel(obj.getString("salesChannel"));
			    }
			    
			    System.out.println("\r\n");
			    System.out.println("------ | Orders |-------");
			    System.out.println("getId............: "+ orders.getId());
			    System.out.println("getDisplayId.....: "+ orders.getDisplayid());
			    System.out.println("getCreatedAt.....: "+ orders.getCreatedat());
			    System.out.println("getSalesChannel..: "+ orders.getSaleschannel());
			    System.out.println("\r\n");
			   
					 // obtém o objeto com os Mercado
					JSONObject delivery = obj.getJSONObject("delivery");
					
					Delivery entrega = new Delivery();
					
					entrega.setMode				(delivery.getString("mode"));
					entrega.setDeliveredby		(delivery.getString("deliveredBy"));
					entrega.setDeliverydatetime	(delivery.getString("deliveryDateTime"));
					entrega.setObservations		(delivery.getString("observations"));
					
					orders.setDelivery(entrega);
			    
					// System.out.println("-------| deliveryAddress |-------");
					JSONObject deliveryAddress = delivery.getJSONObject("deliveryAddress");
					
					Deliveryaddress entregaEndereco = new Deliveryaddress();
			    
					entregaEndereco.setStreetname		(deliveryAddress.getString("streetName"));
					entregaEndereco.setStreetnumber		(deliveryAddress.getString("streetNumber"));
					entregaEndereco.setFormattedaddress	(deliveryAddress.getString("formattedAddress"));
					entregaEndereco.setNeighborhood		(deliveryAddress.getString("neighborhood"));
					entregaEndereco.setPostalcode		(deliveryAddress.getString("postalCode"));
					entregaEndereco.setCity				(deliveryAddress.getString("city"));
					entregaEndereco.setState			(deliveryAddress.getString("state"));
					entregaEndereco.setCountry			(deliveryAddress.getString("country"));
					
					// System.out.println("-------| coordinates |-------");
					JSONObject coordinates = deliveryAddress.getJSONObject("coordinates");
					
					Coordinates coordenadas = new Coordinates();
					coordenadas.setLatitude		(coordinates.getBigDecimal("latitude"));
					coordenadas.setLongitude	(coordinates.getBigDecimal("longitude"));
					
					entregaEndereco.setCoordinates(coordenadas);
					
					entrega.setDeliveryaddress(entregaEndereco);
					
					System.out.println("-------| delivery |-------");
					System.out.println("getMode...............: "+orders.getDelivery().getMode());
					System.out.println("getDeliveredBy........: "+orders.getDelivery().getDeliveredby());
					System.out.println("getDeliveryDateTime...: "+orders.getDelivery().getDeliverydatetime());
					System.out.println("getObservations.......: "+orders.getDelivery().getObservations());
					System.out.println("\r\n");	
					
					System.out.println("-------| DeliveryAddress |-------");
					System.out.println("getStreetName........: "+orders.getDelivery().getDeliveryaddress().getStreetname());
					System.out.println("getStreetNumber......: "+orders.getDelivery().getDeliveryaddress().getStreetnumber());
					System.out.println("getFormattedAddress..: "+orders.getDelivery().getDeliveryaddress().getFormattedaddress());
					System.out.println("getNeighborhood......: "+orders.getDelivery().getDeliveryaddress().getNeighborhood());
					System.out.println("getPostalCode......... "+orders.getDelivery().getDeliveryaddress().getPostalcode());
					System.out.println("getCity..............: "+orders.getDelivery().getDeliveryaddress().getCity());
					System.out.println("getState.............: "+orders.getDelivery().getDeliveryaddress().getState());
					System.out.println("getCountry...........: "+orders.getDelivery().getDeliveryaddress().getCountry());
					System.out.println("\r\n");			
					
					System.out.println("-------| coordinates |-------");
					System.out.println("getLatitude........: "+orders.getDelivery().getDeliveryaddress().getCoordinates().getLatitude());
					System.out.println("getLongitude.......: "+orders.getDelivery().getDeliveryaddress().getCoordinates().getLongitude());
					System.out.println("\r\n");	
			    
			    System.out.println("-------| merchant |-------");
					 // obtém o objeto com os Mercado
					JSONObject mercado = obj.getJSONObject("merchant");
					Merchant merchant = new Merchant();
					merchant.setId(mercado.getString("id"));
					merchant.setName(mercado.getString("name"));
					
					orders.setMerchant(merchant);
					
					System.out.println("getId.........: "+orders.getMerchant().getId());
					System.out.println("getName.......: "+orders.getMerchant().getName());
					
					System.out.println("\r\n");
		/*
					for (String chave : mercado.keySet()) {
					   System.out.println("merchant....: "+chave + "=" + mercado.get(chave));
					}			
		 */
					    
			    System.out.println("------- | customer | --------");
			    
		 	    // obtém o objeto com os customer=Cliente
			    JSONObject cliente = obj.getJSONObject("customer");
			    
			    Customer customer = new Customer();
			    customer.setId(cliente.getString("id"));
			    customer.setName(cliente.getString("name"));
				   
			    Phone phone = new Phone();
			    JSONObject phoneClis = cliente.getJSONObject("phone");
			    
			    phone.setNumber(phoneClis.getString("number"));
			    phone.setLocalizer(phoneClis.getString("localizer"));
			    phone.setLocalizerexpiration(phoneClis.getString("localizerExpiration"));
			    
			    customer.setPhone(phone);
			    
			    orders.setCustomer(customer);
			    
			    System.out.println("getId......: "+orders.getCustomer().getId());
			    System.out.println("getName....: "+orders.getCustomer().getName());
			    System.out.println("\r\n");
			    
			    System.out.println("------- | phone | --------");
			    System.out.println("getNumber...............: "+orders.getCustomer().getPhone().getNumber());
			    System.out.println("getLocalizer............: "+orders.getCustomer().getPhone().getLocalizer());
			    System.out.println("getLocalizerExpiration..: "+orders.getCustomer().getPhone().getLocalizerexpiration());
			    System.out.println("\r\n");
			    
			 /*
			     for (String chave : cliente.keySet()) {
			       System.out.println("customer....: "+chave + "=" + cliente.get(chave));
			    }
			  */
			    
			    // obtém o array de Items
			    JSONArray itens = obj.getJSONArray("items");
			    // filmes.forEach(System.out::println); // imprime todos os Items
			    List<Items> listaItems = new ArrayList<>();
			    JSONObject jsonObject = null;
			    try {
			        for(int i = 0; i<itens.length(); i++) {
			            jsonObject = itens.getJSONObject(i);

			            Items items = new Items();
			            items.setIndex(jsonObject.getInt("index"));
			            items.setId(jsonObject.getString("id"));
			            items.setUniqueid(jsonObject.getString("uniqueId"));
			            items.setName(jsonObject.getString("name"));
			            items.setExternalcode(jsonObject.getString("externalCode"));
			            items.setUnit(jsonObject.getString("unit"));
			            items.setQuantity(jsonObject.getBigDecimal("quantity"));
			            items.setUnitprice(jsonObject.getBigDecimal("unitPrice"));
			            items.setOptionsprice(jsonObject.getBigDecimal("optionsPrice"));
			            items.setTotalprice(jsonObject.getBigDecimal("totalPrice"));
			            items.setPrice(jsonObject.getBigDecimal("price"));
			           
			            listaItems.add(items);
			            
			        }

			    } catch (Exception e) {
			        e.printStackTrace();
			    }

					    orders.setListaItems(listaItems);
					    
					    for (Items item : orders.getListaItems()) {
					    	
					    	System.out.println("------| Item |------");
					    	System.out.println("getIndex.........: "+item.getIndex());
					    	System.out.println("getId............: "+item.getId());
					    	System.out.println("getUniqueId......: "+item.getUniqueid());
					    	System.out.println("getName..........: "+item.getName());
					    	System.out.println("getExternalCode..: "+item.getExternalcode());
					    	System.out.println("getUnit..........: "+item.getUnit());
					    	System.out.println("getQuantity......: "+item.getQuantity());
					    	System.out.println("getUnitPrice.....: "+item.getUnitprice());
					    	System.out.println("getOptionsPrice..: "+item.getOptionsprice());
					    	System.out.println("getTotalPrice....: "+item.getTotalprice());
					    	System.out.println("getPrice.........: "+item.getPrice());
					    	System.out.println("\r\n");
					    	
					    }
			    
					 	    // obtém o objeto com os customer=Cliente
						    JSONObject total = obj.getJSONObject("total");
						    
						    Total totalPed = new Total();
						    
						    totalPed.setSubtotal(total.getBigDecimal("subTotal"));
						    totalPed.setDeliveryfee(total.getBigDecimal("deliveryFee"));
						    totalPed.setBenefits(total.getBigDecimal("benefits"));
						    totalPed.setOrderamount(total.getBigDecimal("orderAmount"));
						    totalPed.setAdditionalfees(total.getBigDecimal("additionalFees"));
						    
						    orders.setTotal(totalPed);
						    
						    System.out.println("------- | total | --------");
						    System.out.println("getSubTotal........: "+orders.getTotal().getSubtotal());
						    System.out.println("getDeliveryFee.....: "+orders.getTotal().getDeliveryfee());
						    System.out.println("getBenefits........: "+orders.getTotal().getBenefits());
						    System.out.println("getOrderAmount.....: "+orders.getTotal().getOrderamount());
						    System.out.println("getAdditionalFees..: "+orders.getTotal().getAdditionalfees());
						    System.out.println("\r\n");				    
						    
		/*
						    for (String chave : total.keySet()) {
						       System.out.println("total....: "+chave + "=" + total.get(chave));
						    }
		 */
						    System.out.println("\r\n");
					   
					    // Payments
				 	    // obtém o objeto com os payments=Pagamentos
					    JSONObject pagamentos = obj.getJSONObject("payments");
					    Payments payments = new Payments();
					    
					    payments.setPrepaid(pagamentos.getBigDecimal("prepaid"));
					    payments.setPending(pagamentos.getInt("pending"));
					    
					    // obtém o array de methods
					    JSONArray methods = pagamentos.getJSONArray("methods");
					    // filmes.forEach(System.out::println); // imprime todos os Items
					    List<Methods> listaMethods = new ArrayList<>();
					    JSONObject jsonObjectMethods = null;
					    try {
					        for(int i = 0; i<methods.length(); i++) {
					        	jsonObjectMethods = methods.getJSONObject(i);
					        	
					        	Methods method = new Methods();
					        	method.setValue(jsonObjectMethods.getBigDecimal("value"));
					        	method.setCurrency(jsonObjectMethods.getString("currency"));
					        	method.setMethod(jsonObjectMethods.getString("method"));
					        	method.setType(jsonObjectMethods.getString("type"));
					        	
							    JSONObject card = jsonObjectMethods.getJSONObject("card");
							    Card cartao = new Card();
							    cartao.setBrand(card.getString("brand"));
					        	method.setCard(cartao);
					        	
					            listaMethods.add(method);
					            
					        }

					    } catch (Exception e) {
					        e.printStackTrace();
					    }			    
					    
					 	payments.setMethods(listaMethods);
					    
					    orders.setPayments(payments);
					    
					    System.out.println("------- | payments | --------");
					    System.out.println("getPrepaid....: "+orders.getPayments().getPrepaid());
					    System.out.println("getPending....: "+orders.getPayments().getPending());
					    System.out.println("\r\n");
					    
					     
						    for (Methods pgto : orders.getPayments().getMethods()) {
						    	System.out.println("------| Methods |------");
						    	System.out.println("value.......: "+pgto.getValue());
						    	System.out.println("currency....: "+pgto.getCurrency());
						    	System.out.println("Method......: "+pgto.getMethod());
						    	System.out.println("type........: "+pgto.getType());
						    	System.out.println("\r\n");
						    	
						    	System.out.println("------| card |------");
						    	System.out.println("Brand.......: "+pgto.getCard().getBrand());
						    	System.out.println("\r\n");
						    }
				    			     
			    
						   //  System.out.println("getOrders_id: "+orders.getOrders_id());
						   //  System.out.println("\r\n");
		/*
		 				    System.out.println("orders: "+orders.getId());
						    System.out.println("orders: "+orders.getDelivery().getDeliveredBy());
						    System.out.println("orders: "+orders.getCustomer().getId());
						    
						    orders.setOrders_id(1L);
						    System.out.println("getOrders_id: "+orders.getOrders_id());

						    orders.getMerchant().setMerchant_id(1L);
						    System.out.println("getMerchant_id: "+orders.getMerchant().getMerchant_id());

						    orders.getCustomer().setCustomer_id(1L);
						    System.out.println("getCustomer_id: "+orders.getCustomer().getCustomer_id());
						    
						    orders.getTotal().setTotal_id(1L);;
						    System.out.println("getTotal_id: "+orders.getTotal().getTotal_id());
						    
		 */
						    
						    System.out.println("\r\n");
						    
						    ordersRepository.save(orders);
						    
						    
						    /*
						     Assim que salvar no banco de dados.
						     fazer um post no iFood confirmando que jaesta no banco de dados,
						     para o iFood não enviar novamente
						     
						     */
						    
						    
		/*
			    for (String chave : pagamentos.keySet()) {
//		 	       System.out.println("payments....: "+chave + "=" + pagamentos.get(chave));
			       if(chave.equalsIgnoreCase("prepaid")) {
			    	   payments.setPrepaid(pagamentos.getBigDecimal("prepaid"));
			       }
			       if(chave.equalsIgnoreCase("pending")) {
			    	   payments.setPending(pagamentos.getInt("pending"));
			       }
			       // System.out.println("payments =======> "+payments.getPrepaid());
			    }
		 */
			    	   
			    System.out.println("\r\n");
			    
		     /*
			    Orders orders = new Gson().fromJson((Reader) response.getBody(), Orders.class);
			       // System.out.println("getListaItems			: " +  orders.getListaItems());
				   System.out.println("getId			: " +  orders.getId());	
				   System.out.println("getDisplayId		: " +  orders.getDisplayId());
				   System.out.println("getCreatedAt		: " +  orders.getCreatedAt());
				   System.out.println("getSalesChannel		: " +  orders.getSalesChannel());		    
				   System.out.println("\r\n");  
		   
		      	*/
			    
			    /*
			       // System.out.println("getListaItems			: " +  response.getBody().getListaItems());
				   System.out.println("getId			: " +  response.getBody().getId());	
				   System.out.println("getDisplayId		: " +  response.getBody().getDisplayId());
				   System.out.println("getCreatedAt		: " +  response.getBody().getCreatedAt());
				   System.out.println("getSalesChannel		: " +  response.getBody().getSalesChannel());
				   System.out.println("getSalesChannel		: " +  response.getBody().getListaItems());
				   System.out.println("\r\n");
				   
			     */

			     /*
				   for (Orders orders : response.getBody()) {
					   System.out.println("getId			: " +  orders.getId());	
					   System.out.println("getDisplayId			: " +  orders.getDisplayId());
					   System.out.println("getCreatedAt		: " +  orders.getCreatedAt());
					   System.out.println("getSalesChannel		: " +  orders.getSalesChannel());	
					   System.out.println("\r\n");
				   }
			     */
				 			   
			   
			   
		   }	    
	    
	    
	    
	    
	    
	    
    }
	
	
	
	
	
	
	
	
	
	
	
	

}
