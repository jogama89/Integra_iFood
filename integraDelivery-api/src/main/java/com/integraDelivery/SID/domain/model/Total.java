package com.integraDelivery.SID.domain.model;

import java.math.BigDecimal;

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
public class Total {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long total_id;		
	
	@Column
	private BigDecimal subtotal;
	@Column
	private BigDecimal deliveryfee;
	@Column
	private BigDecimal benefits;
	@Column
	private BigDecimal orderamount;
	@Column
	private BigDecimal additionalfees;
	
	
	
}
