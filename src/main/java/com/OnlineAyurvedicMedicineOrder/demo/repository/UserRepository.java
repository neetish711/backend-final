package com.OnlineAyurvedicMedicineOrder.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Customer;
import com.OnlineAyurvedicMedicineOrder.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);
	
//	public User findByCustomerName(String customerName);
}
