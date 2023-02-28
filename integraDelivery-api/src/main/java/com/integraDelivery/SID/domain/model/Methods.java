package com.integraDelivery.SID.domain.model;

import java.math.BigDecimal;

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
public class Methods {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long methods_id;	
	
	@Column
	private BigDecimal value;
	@Column
	private String currency;
	@Column
	private String method;
	@Column
	private String type;
/*
 	@Column
	private Boolean prepaid;
	
 */
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	// @ManyToOne
	@JoinColumn(nullable=false)
	private Card card;
	

	//@ManyToOne(cascade=CascadeType.PERSIST)
	@ManyToOne
	@JoinColumn(nullable = true) 
	private Payments payments;
	
	
	
}
