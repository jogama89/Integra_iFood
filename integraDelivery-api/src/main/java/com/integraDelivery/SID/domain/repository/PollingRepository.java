package com.integraDelivery.SID.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integraDelivery.SID.domain.model.Polling;

@Repository
public interface PollingRepository extends JpaRepository<Polling, Long>{

}
