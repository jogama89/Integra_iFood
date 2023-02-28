package com.integraDelivery.SID.domain.model;

import java.math.BigDecimal;

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
public class Items {
			
				@EqualsAndHashCode.Include
				@Id
				@GeneratedValue(strategy = GenerationType.IDENTITY)
				private Long items_id;	
	
				// "index": 1,
				@Column(name = "index_")
				private Integer index;
			    // "id": "1a2845ff-0afd-4962-b2ec-25d6e47df3e0",
				@Column
				private String id;
			    // "uniqueId": "633ba173-a75d-4ebb-9e57-2ee36f3b7a96",
				@Column
				private String uniqueid;
			    // "name": "PEDIDO DE TESTE - Sanduíche",
				@Column(name = "name_")
				private String name;
			    // "externalCode": "c01-i001",
				@Column
				private String externalcode;
			    // "unit": "GRAMS",
				@Column
				private String unit;
			    // "quantity": 1,
				@Column
				private BigDecimal quantity;
			    // "unitPrice": 20.00,
				@Column
				private BigDecimal unitprice;
			    // "optionsPrice": 1.00,
				@Column
				private BigDecimal optionsprice;
			    // "totalPrice": 21.00,
				@Column
				private BigDecimal totalprice;
			    // "price": 20.00
				@Column
				private BigDecimal price;
				
				

 				@ManyToOne
				@JoinColumn(nullable = true)
				private Orders orders;

				
				
}
