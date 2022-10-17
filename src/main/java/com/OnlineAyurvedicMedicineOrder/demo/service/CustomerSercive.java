package com.OnlineAyurvedicMedicineOrder.demo.service;

import java.util.List;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Customer;
import com.OnlineAyurvedicMedicineOrder.demo.exception.CustomerAlreadyExistsException;
import com.OnlineAyurvedicMedicineOrder.demo.exception.CustomerDoesNotExistsException;

public interface CustomerSercive {

	Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException;

	Customer viewCustomer(int id) throws CustomerDoesNotExistsException;

	Customer updateCustomer(Customer customer);

	Customer deleteCustomer(int id) throws CustomerDoesNotExistsException;

	List<Customer> showAllCustomers();

	Customer viewCustomerByName(String customerName) throws CustomerDoesNotExistsException;
}

//import java.util.List;
//
//import com.OnlineAyurvedicMedicineOrder.demo.entity.Customer;
//import com.OnlineAyurvedicMedicineOrder.demo.exception.CustomerAlreadyExistsException;
//import com.OnlineAyurvedicMedicineOrder.demo.exception.CustomerDoesNotExistsException;
//
//public interface CustomerSercive {
//
//	Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException;
//
//	Customer viewCustomer(int id) throws CustomerDoesNotExistsException;
//
//	Customer updateCustomer(Customer customer);
//
//	Customer deleteCustomer(int id) throws CustomerDoesNotExistsException;
//
//	List<Customer> showAllCustomers();
//
//}
