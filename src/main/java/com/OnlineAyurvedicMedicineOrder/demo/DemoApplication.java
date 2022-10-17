package com.OnlineAyurvedicMedicineOrder.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Role;
import com.OnlineAyurvedicMedicineOrder.demo.entity.User;
import com.OnlineAyurvedicMedicineOrder.demo.entity.UserRole;
import com.OnlineAyurvedicMedicineOrder.demo.service.UserServiceImpl;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setId(1L);
		user1.setUsername("admin@ayurveda.net");
		user1.setPassword(this.bCryptPasswordEncoder.encode("admin1230"));
		Role role1= new Role();
		role1.setRoleId(44L);
		role1.setRoleName("ADMIN");
		Set<UserRole>userRoleSet = new HashSet<>();
		
		UserRole userRole=new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user1);
		userRoleSet.add(userRole);
		this.userServiceImpl.saveUser(user1, userRoleSet);
		
	}

}
