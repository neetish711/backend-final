package com.OnlineAyurvedicMedicineOrder.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class OrderedMedicine {

	@Id
	private int medicineId;
    private String medicineName;
    private float medicineCost;
    
	public OrderedMedicine(int medicineId, String medicineName, float medicineCost) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.medicineCost = medicineCost;
	}
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public float getMedicineCost() {
		return medicineCost;
	}
	public void setMedicineCost(float medicineCost) {
		this.medicineCost = medicineCost;
	}
	public OrderedMedicine() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}