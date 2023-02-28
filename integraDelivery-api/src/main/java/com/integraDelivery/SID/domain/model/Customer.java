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
public class Customer {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customer_id;	
	
	@Column
	private String id;
	@Column
	private String name;
	

	@ManyToOne(cascade=CascadeType.PERSIST)
	// @ManyToOne
	@JoinColumn(nullable=false)
	private Phone phone;
	
	


}
