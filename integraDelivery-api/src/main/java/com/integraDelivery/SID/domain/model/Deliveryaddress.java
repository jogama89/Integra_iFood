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
public class Deliveryaddress {
			
			@EqualsAndHashCode.Include
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long deliveryaddress_id;	
	
			@Column
			private String streetname;
			@Column
			private String streetnumber;
			@Column
			private String formattedaddress;
			@Column
			private String neighborhood;
			@Column
			private String postalcode;
			@Column
			private String city;
			@Column
			private String state;
			@Column
			private String country;
			
			@ManyToOne(cascade=CascadeType.PERSIST)
			// @ManyToOne
			@JoinColumn(nullable=true)			
			private Coordinates coordinates;
	
	
}
