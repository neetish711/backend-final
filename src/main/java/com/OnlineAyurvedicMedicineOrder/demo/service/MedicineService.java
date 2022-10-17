package com.OnlineAyurvedicMedicineOrder.demo.service;

import java.util.List;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Medicine;

public interface MedicineService {
	
	public Medicine addMedicine(Medicine medicine) throws Exception;
	public Medicine viewMedicine(Medicine medicine) throws Exception;
	public Medicine updateMedicine(Medicine medicine) throws Exception;
	public Medicine deleteMedicine(int id) throws com.OnlineAyurvedicMedicineOrder.demo.exception.MedicineIdNullException;
	public List<Medicine> showAllMedicine();
//	Medicine addMedicine(Medicine medicine);
//
//	Medicine viewMedicine(int id);
//
//	Medicine updateMedicine(Medicine medicine) throws Exception;
//
//	Medicine deleteMedicine(int id);
//
//	List<Medicine> showAllMedicine();

}
