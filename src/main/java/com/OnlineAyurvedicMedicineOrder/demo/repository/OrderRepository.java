package com.OnlineAyurvedicMedicineOrder.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
