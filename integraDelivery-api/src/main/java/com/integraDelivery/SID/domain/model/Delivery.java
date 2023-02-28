package com.integraDelivery.SID.domain.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long delivery_id;	
	
	@Column
	private String mode;
	@Column
	private String deliveredby;
	@Column
	private String deliverydatetime;
	@Column
	private String observations;
	

	@ManyToOne(cascade=CascadeType.PERSIST)
	// @ManyToOne
	@JoinColumn(nullable=false)
	private Deliveryaddress deliveryaddress;
	
}
