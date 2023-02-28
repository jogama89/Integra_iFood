package com.integraDelivery.SID.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Production {

	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

 	@Column
 	private String merchantapihost 				;
 	@Column
	private String accesstoken 					;
	@Column
	private String clientid 					;
	@Column
	private String clientsecret 				;
	@Column
	private String granttype 					;
	@Column
	private String authorizationcode 			;
	@Column
	private String authorizationcodeverifier 	;
	@Column
	private String refreshtoken 				;
	@Column
	private String merchantid 					;
	@Column
	private String operation 					;
	@Column
	private String interruptionid 				;
	@Column
	private String orderid 						;
	@Column
	private String cancellationcode 			;
	@Column
	private String cancellationreason 			;
	@Column
	private String changepreparationtime 		;
	@Column
	private String changepreparationreason 		;
	@Column
	private String catalogid 					;
	@Column
	private String categoryid 					;
	@Column
	private String productid 					;
	@Column
	private String pizzaid 						;
	@Column
	private String optiongroupid 				;

	
}
