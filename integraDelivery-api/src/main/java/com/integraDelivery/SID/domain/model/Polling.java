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
public class Polling {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long polling_id;
	
	
	//  "id": "cd40582b-0ef2-4d52-bc7c-507fdff12e21"
	@Column
	private String id;
	@Column
	private String code;
	@Column
	private String fullcode;
	@Column
	private String orderid;
	@Column
	private String merchantid;
	@Column
	private String createdat;
	@Column
	private boolean txtimportado;	
	
}
