package com.OnlineAyurvedicMedicineOrder.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.OnlineAyurvedicMedicineOrder.demo.entity.User;
import com.OnlineAyurvedicMedicineOrder.demo.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("No user with the given email");
		}
		
		return user;
	}
	
	
}
