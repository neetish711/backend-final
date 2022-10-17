package com.OnlineAyurvedicMedicineOrder.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false, length = 100)
	private String email;

	@Column(nullable = false, length = 8)
	private String password;

	@Column(nullable = false, length = 100)
	private String customerName;//

	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_fk", referencedColumnName = "id")
	private List<Order> Orders;

	@Column(nullable = false, length = 10)
	private long mobile;//

	@Column(nullable = false, length = 100)
	private String address;//

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public Customer(String email, String password, String customerName) {
//		super();
//		this.email = email;
//		this.password = password;
//		this.customerName = customerName;
//	}
//
//	public Customer(int id, String email, String customerName, String password, List<Order> orders) {
//		super();
//		this.id = id;
//		this.email = email;
//		this.customerName = customerName;
//		this.password = password;
//		Orders = orders;
//	}

	public String getCustomerName() {
		return customerName;
	}

	public Customer(int id, String email, String password, String customerName, List<Order> orders, long mobile,
			String address) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.customerName = customerName;
		Orders = orders;
		this.mobile = mobile;
		this.address = address;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Order> getOrders() {
		return Orders;
	}

	public void setOrders(List<Order> orders) {
		Orders = orders;
	}

	public Customer() {
		super();
	}

}
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "customers")
//public class Customer {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int id;
//
//	@Column(nullable = false, length = 100)
//	private String email;
//
//	@Column(nullable = false, length = 8)
//	private String password;
//
//	@Column(nullable = false, length = 100)
//	private String customerName;//
//
//	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "customer_fk", referencedColumnName = "id")
//	private List<Order> Orders;
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public Customer(String email, String password, String customerName) {
//		super();
//		this.email = email;
//		this.password = password;
//		this.customerName = customerName;
//	}
//
//	public Customer(int id, String email, String customerName, String password, List<Order> orders) {
//		super();
//		this.id = id;
//		this.email = email;
//		this.customerName = customerName;
//		this.password = password;
//		Orders = orders;
//	}
//
//	public String getCustomerName() {
//		return customerName;
//	}
//
//	public void setCustomerName(String customerName) {
//		this.customerName = customerName;
//	}
//
//	public List<Order> getOrders() {
//		return Orders;
//	}
//
//	public void setOrders(List<Order> orders) {
//		Orders = orders;
//	}
//
//	public Customer() {
//		super();
//	}
//
//}
