package com.OnlineAyurvedicMedicineOrder.demo.service;
/*
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.OnlineAyurvedicMedicineOrder.demo.entity.CustomUserDetails;
import com.OnlineAyurvedicMedicineOrder.demo.entity.Customer;
import com.OnlineAyurvedicMedicineOrder.demo.entity.CustomerUserDetails;
import com.OnlineAyurvedicMedicineOrder.demo.entity.User;
import com.OnlineAyurvedicMedicineOrder.demo.repository.CustomerRepository;
import com.OnlineAyurvedicMedicineOrder.demo.repository.UserRepository;


@Service
public class CustomerUserDetailsService implements UserDetailsService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer=customerRepository.findByEmail(username);
		if(customer == null) {
			throw new UsernameNotFoundException("No user with the given email");
		}
		return new CustomerUserDetails(customer);
	}
	
	
}
*/