package com.OnlineAyurvedicMedicineOrder.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByEmail(String email);
	public Customer findByCustomerName(String customerName);

}
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.OnlineAyurvedicMedicineOrder.demo.entity.Customer;
//
//@Repository
//public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//
//	public Customer findByEmail(String email);
//
//}
