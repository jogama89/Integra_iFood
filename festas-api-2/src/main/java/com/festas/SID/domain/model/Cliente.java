package com.festas.SID.domain.model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cliente {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("_id")
	private Long id;	
	
	@Column
	@JsonProperty("name")
	// @Column(name = "name", nullable=false)
	private String nome;

	// vou alterar para 'tipo'
	@Column
	@JsonProperty("tipopessoa")
	// @Column(name = "category", nullable=false)
	private String tipopessoa;

	
	// Ao gravar validar se já existe um cliente cadastrado com o CPF/CNPJ informado.
	// CPF / CNPJ
	// @Column(name = "cpf_cnpj", nullable=false)
	@Column
	private String cpf_cnpj;
	
	// RG / IE
	@Column
	// @Column(name = "rg_ie", nullable=false)
	private String rg_ie;	
	
	// Data Cadastro
	@Column
	// @CreationTimestamp
	// @Column(name = "dataCadastro", nullable=false)
	// LocalDateTime
	// private Date datacadastro;	
	@CreationTimestamp
	private LocalDateTime datacadastro;
	
	
	// Status: Ativo / Inativo
	@Column
	// @Column(name = "status", nullable=false)
	private String status;		
	
	@Column
	// @Column(name = "telefone1", nullable=false)
	private String telefone1;	
	
	
	@Column
	// @Column(name = "telefone1", nullable=false)
	private String telefone2;	
		

	
	
}
