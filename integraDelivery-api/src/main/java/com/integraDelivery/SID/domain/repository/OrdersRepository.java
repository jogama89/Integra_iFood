package com.integraDelivery.SID.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integraDelivery.SID.domain.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
