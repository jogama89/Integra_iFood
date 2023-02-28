package com.integraDelivery.SID;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.integraDelivery.SID.api.MyTrayIcon;


@SpringBootApplication
@EnableScheduling
public class IntegraDeliveryApiApplication {
	
/*
 	
	@Bean
	public WebClient webClientProdutos(WebClient.Builder builder) {
		return builder
			.baseUrl("http://localhost:8080/production")
			.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			.build();
		
	}
 */

	public static ConfigurableApplicationContext context;

	
	public static void main(String[] args) {
		// SpringApplication.run(IntegraDeliveryApiApplication.class, args);
		
		
        SpringApplicationBuilder builder = new SpringApplicationBuilder(IntegraDeliveryApiApplication.class);
        builder.headless(false);
        context = builder.run(args);		
		
        
        MyTrayIcon m = new MyTrayIcon();
		
	}

}
