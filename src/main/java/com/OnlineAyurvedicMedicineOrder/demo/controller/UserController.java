package com.OnlineAyurvedicMedicineOrder.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Role;
import com.OnlineAyurvedicMedicineOrder.demo.entity.User;
import com.OnlineAyurvedicMedicineOrder.demo.entity.UserRole;
import com.OnlineAyurvedicMedicineOrder.demo.exception.CustomerDoesNotExistsException;
import com.OnlineAyurvedicMedicineOrder.demo.exception.IdNotFoundToDelete;
import com.OnlineAyurvedicMedicineOrder.demo.exception.UserAlreadyExistException;
import com.OnlineAyurvedicMedicineOrder.demo.service.UserService;

@RestController
@CrossOrigin(origins="*")
public class UserController {
	
//	@Autowired
//	private JwtUtil jwtUtil;
//	
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	@Autowired
//	private UserDetailsServiceImpl customUserDetailsService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user) throws UserAlreadyExistException {
		
		//Encoding password BCryptPasswordEncoder
		
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		Set<UserRole> roles=new HashSet<>();
		Random random=new Random();
		user.setId(random.nextLong(100));
		Role role=new Role();
		role.setRoleId(45L);
		role.setRoleName("Customer");
		
		UserRole userRole=new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);
		
		User obj=this.userService.saveUser(user, roles);
		
		return new ResponseEntity<User>(obj,HttpStatus.CREATED);
		
		
//		
//		if (userService.isValidateUser(user)) {
//			User savedUser = userService.saveUser(user, roles);
//			return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
//		} else {
//			return new ResponseEntity<User>(user, HttpStatus.EXPECTATION_FAILED);
//		}
	}

	@PutMapping("/user/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		if (userService.isValidateUser(user)) {
			User changedUser = userService.changeUser(user);
			return new ResponseEntity<User>(changedUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUser() {
		List<User> allUsers = userService.getAllUser();
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Long id) throws IdNotFoundToDelete {
		User delUser = userService.delUserById(id);
		return new ResponseEntity<User>(delUser, HttpStatus.OK);
	}
	
	@GetMapping("/user/{username}")
	public ResponseEntity<User> get_UserByName(@PathVariable String username) throws CustomerDoesNotExistsException {
		User customer = userService.viewCustomerByName(username);
		return new ResponseEntity<User>(customer, HttpStatus.OK);
	}
	

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody User user) throws Exception {
//    	System.out.println(user);
//    	
//    	try {
//    		this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
//    		
//    	}catch(UsernameNotFoundException e) {
//    		e.printStackTrace();
//    		throw new Exception("Bad Credentials");
//    	}
//    	
//    	
//    	UserDetails userDetails=this.customUserDetailsService.loadUserByUsername(user.getUsername());
//    	
//    	String token=this.jwtUtil.generateToken(userDetails);
//    	System.out.println("JWT" +token);
//    	
//    	return ResponseEntity.ok(new JwtResponse(token));
//       
//    }
//	

}
