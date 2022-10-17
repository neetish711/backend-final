package com.OnlineAyurvedicMedicineOrder.demo.entity;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Order {

	@Id
	private int orderId;
	private LocalDate orderDate;
	private LocalDate dispatchDate;
	private float cost;
	
	@OneToMany(targetEntity=OrderedMedicine.class,cascade=CascadeType.ALL)
	@JoinColumn(name="order_fk",referencedColumnName="orderId")
	private List<OrderedMedicine> medicineList;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(int orderId, LocalDate orderDate, LocalDate dispatchDate, float cost,
			List<OrderedMedicine> medicineList) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.dispatchDate = dispatchDate;
		this.cost = cost;
		this.medicineList = medicineList;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public LocalDate getDispatchDate() {
		return dispatchDate;
	}
	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}

	public List<OrderedMedicine> getMedicineList() {
		return medicineList;
	}

	public void setMedicineList(List<OrderedMedicine> medicineList) {
		this.medicineList = medicineList;
	}
	
	
	
}
//import java.time.LocalDate;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "orders")
//public class Order {
//
//	@Id
//	private int orderId;
//	private LocalDate orderDate;
//	private LocalDate dispatchDate;
//	private float cost;
//
//	@OneToMany(targetEntity = Medicine.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "order_fk", referencedColumnName = "orderId")
//	private List<Medicine> medicineList;
//
//	public Order() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Order(int orderId, LocalDate orderDate, LocalDate dispatchDate, float cost, List<Medicine> medicineList) {
//		super();
//		this.orderId = orderId;
//		this.orderDate = orderDate;
//		this.dispatchDate = dispatchDate;
//		this.cost = cost;
//		this.medicineList = medicineList;
//	}
//
//	public int getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(int orderId) {
//		this.orderId = orderId;
//	}
//
//	public LocalDate getOrderDate() {
//		return orderDate;
//	}
//
//	public void setOrderDate(LocalDate orderDate) {
//		this.orderDate = orderDate;
//	}
//
//	public LocalDate getDispatchDate() {
//		return dispatchDate;
//	}
//
//	public void setDispatchDate(LocalDate dispatchDate) {
//		this.dispatchDate = dispatchDate;
//	}
//
//	public float getCost() {
//		return cost;
//	}
//
//	public void setCost(float cost) {
//		this.cost = cost;
//	}
//
//	public List<Medicine> getMedicineList() {
//		return medicineList;
//	}
//
//	public void setMedicineList(List<Medicine> medicineList) {
//		this.medicineList = medicineList;
//	}
//
//}
