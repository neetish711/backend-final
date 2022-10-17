package com.OnlineAyurvedicMedicineOrder.demo.service;

import java.util.List;
import java.util.Set;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Customer;
import com.OnlineAyurvedicMedicineOrder.demo.entity.User;
import com.OnlineAyurvedicMedicineOrder.demo.entity.UserRole;
import com.OnlineAyurvedicMedicineOrder.demo.exception.CustomerDoesNotExistsException;
import com.OnlineAyurvedicMedicineOrder.demo.exception.IdNotFoundToDelete;
import com.OnlineAyurvedicMedicineOrder.demo.exception.UserAlreadyExistException;

public interface UserService {
	User saveUser(User user,Set<UserRole> userRoles) throws UserAlreadyExistException;

	User changeUser(User user);

	List<User> getAllUser();

	User delUserById(Long id) throws IdNotFoundToDelete;

	boolean isValidateUser(User user);
	
	User viewCustomerByName(String username);
}
