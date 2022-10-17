package com.OnlineAyurvedicMedicineOrder.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Customer;
import com.OnlineAyurvedicMedicineOrder.demo.entity.User;
import com.OnlineAyurvedicMedicineOrder.demo.entity.UserRole;
import com.OnlineAyurvedicMedicineOrder.demo.exception.CustomerDoesNotExistsException;
import com.OnlineAyurvedicMedicineOrder.demo.exception.IdNotFoundToDelete;
import com.OnlineAyurvedicMedicineOrder.demo.exception.UserAlreadyExistException;
import com.OnlineAyurvedicMedicineOrder.demo.repository.RoleRepository;
import com.OnlineAyurvedicMedicineOrder.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;

//	@Override
//	public User saveUser(User user) throws UserAlreadyExistException {
//		if (userRepo.existsById(user.getId())) {
//			throw new UserAlreadyExistException();
//		}
//		User savedUser = userRepo.save(user);
//		return savedUser;
//	}

	@Override
	public User changeUser(User user) {
		if (userRepo.existsById(user.getId())) {
//			userRepo.deleteById(user.getId());
			userRepo.save(user);
		} else {
			userRepo.save(user);
		}
		return user;
	}

	@Override
	public List<User> getAllUser() {
		List<User> allUsers = userRepo.findAll();
		return allUsers;
	}

	@Override
	public User delUserById(Long id) throws IdNotFoundToDelete {
		if (userRepo.existsById(id)) {
			Optional<User> delUser = userRepo.findById(id);
			userRepo.deleteById(id);
			return delUser.get();
		} else {
			throw new IdNotFoundToDelete();
		}
	}

	@Override
	public boolean isValidateUser(User user) {
		if (user.getId() > 0 && user.getUsername().length() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User saveUser(User user, Set<UserRole> userRoles) throws UserAlreadyExistException {
		
		if (userRepo.existsById(user.getId())) {
			throw new UserAlreadyExistException();
		}
		for(UserRole ur:userRoles) {
			roleRepo.save(ur.getRole());
		}
		
		user.getUserRoles().addAll(userRoles);
		
		User savedUser=this.userRepo.save(user);
		return savedUser;
	}
	
	@Override
	public User viewCustomerByName(String username) {
		User customer = userRepo.findByUsername(username);
		return customer;
	}

}
