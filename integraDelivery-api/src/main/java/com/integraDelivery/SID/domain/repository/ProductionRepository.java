package com.integraDelivery.SID.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integraDelivery.SID.domain.model.Production;

@Repository
public interface ProductionRepository extends JpaRepository<Production, Long>{


	
}
