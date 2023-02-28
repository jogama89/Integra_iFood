package com.integraDelivery.SID.domain.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Orders {
	
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orders_id;	
	
	// "id": "1edb7fbe-b43f-4ee7-97e5-dc52975ced91",
	
	@Column
	private String id;
	// "displayId": "1489",
	@Column
	private String displayid;
	// "createdAt": "2022-08-22T19:29:31.425Z",
	@Column
	private String createdat;
	// "salesChannel": "IFOOD",
	@Column
	private String saleschannel;
	
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	// @ManyToOne
	@JoinColumn(nullable=false)
	private Merchant merchant;
	
	
	

	@ManyToOne(cascade=CascadeType.PERSIST)
	// @ManyToOne
	@JoinColumn(nullable=false)
	private Customer customer;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "orders" ,  cascade=CascadeType.PERSIST)
	private List<Items> listaItems = new ArrayList<>();	
	
	

	@ManyToOne(cascade=CascadeType.PERSIST)
	// @ManyToOne
	@JoinColumn(nullable=false)
	private Total total;


	@ManyToOne(cascade=CascadeType.PERSIST)
	// @ManyToOne
	@JoinColumn(nullable=false)
	private Payments payments;
	

	@ManyToOne(cascade=CascadeType.PERSIST)
	// @ManyToOne
	@JoinColumn(nullable=false)
	private Delivery delivery;
	
	
	
}
