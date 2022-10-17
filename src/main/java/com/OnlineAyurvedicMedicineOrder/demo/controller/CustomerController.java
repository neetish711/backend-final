package com.OnlineAyurvedicMedicineOrder.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Customer;
import com.OnlineAyurvedicMedicineOrder.demo.exception.CustomerAlreadyExistsException;
import com.OnlineAyurvedicMedicineOrder.demo.exception.CustomerDoesNotExistsException;
import com.OnlineAyurvedicMedicineOrder.demo.service.CustomerSercive;

@RestController
@CrossOrigin(origins="*")
public class CustomerController {

	@Autowired
	private CustomerSercive customerServ;

	@PostMapping("/customer/savecustomer")
	public ResponseEntity<Customer> save_customer(@RequestBody Customer customer)
			throws CustomerAlreadyExistsException {
		Customer savedCustomer = customerServ.addCustomer(customer);
		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
	}

	@GetMapping("/customer/getcustomer/{id}")
	public ResponseEntity<Customer> get_Customer(@PathVariable int id) throws CustomerDoesNotExistsException {
		Customer customer = customerServ.viewCustomer(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@PutMapping("/customer/updatecustomer")
	public ResponseEntity<Customer> update_customer(@RequestBody Customer customer) {
		Customer savedCustomer = customerServ.updateCustomer(customer);
		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
	}

	@DeleteMapping("/customer/deletecustomer/{id}")
	public ResponseEntity<Customer> delete_customer(@PathVariable int id) throws CustomerDoesNotExistsException {
		Customer customer = customerServ.deleteCustomer(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@GetMapping("/customer/allcustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerServ.showAllCustomers();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/customer/{customerName}")
	public ResponseEntity<Customer> get_CustomerByName(@PathVariable String customerName) throws CustomerDoesNotExistsException {
		Customer customer = customerServ.viewCustomerByName(customerName);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
}
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.OnlineAyurvedicMedicineOrder.demo.entity.Customer;
//import com.OnlineAyurvedicMedicineOrder.demo.exception.CustomerAlreadyExistsException;
//import com.OnlineAyurvedicMedicineOrder.demo.exception.CustomerDoesNotExistsException;
//import com.OnlineAyurvedicMedicineOrder.demo.service.CustomerSercive;
//
//@RestController
//@CrossOrigin(origins="*")
//public class CustomerController {
//
//	@Autowired
//	private CustomerSercive customerServ;
//
//	@PostMapping("/customer/savecustomer")
//	public ResponseEntity<Customer> save_customer(@RequestBody Customer customer)
//			throws CustomerAlreadyExistsException {
//		Customer savedCustomer = customerServ.addCustomer(customer);
//		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
//	}
//
//	@GetMapping("/customer/getcustomer/{id}")
//	public ResponseEntity<Customer> get_Customer(@PathVariable int id) throws CustomerDoesNotExistsException {
//		Customer customer = customerServ.viewCustomer(id);
//		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
//	}
//
//	@PutMapping("/customer/updatecustomer")
//	public ResponseEntity<Customer> update_customer(@RequestBody Customer customer) {
//		Customer savedCustomer = customerServ.updateCustomer(customer);
//		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
//	}
//
//	@DeleteMapping("/customer/deletecustomer/{id}")
//	public ResponseEntity<Customer> delete_customer(@PathVariable int id) throws CustomerDoesNotExistsException {
//		Customer customer = customerServ.deleteCustomer(id);
//		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
//	}
//
//	@GetMapping("/customer/allcustomers")
//	public ResponseEntity<List<Customer>> getAllCustomers() {
//		List<Customer> customers = customerServ.showAllCustomers();
//		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
//	}
//}
