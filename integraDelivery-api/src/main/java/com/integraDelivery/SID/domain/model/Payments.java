package com.integraDelivery.SID.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Payments {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long payments_id;	

	@Column
	private BigDecimal prepaid;
	@Column
	private Integer pending;
	
	@JsonIgnore
	@OneToMany(mappedBy = "payments",  cascade=CascadeType.PERSIST)
	private List<Methods> methods = new ArrayList<>();	
	
}
