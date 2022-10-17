package com.OnlineAyurvedicMedicineOrder.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Medicine;
import com.OnlineAyurvedicMedicineOrder.demo.exception.MedicineIdNullException;
import com.OnlineAyurvedicMedicineOrder.demo.exception.MedicineIllegalCostException;
import com.OnlineAyurvedicMedicineOrder.demo.exception.MedicineIllegalMfdDateException;
import com.OnlineAyurvedicMedicineOrder.demo.exception.NullCategoryIdException;
import com.OnlineAyurvedicMedicineOrder.demo.repository.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService {

	
	@Autowired
	private MedicineRepository medrepo;
	
	@Override
	public Medicine addMedicine(Medicine medicine) throws Exception {
		
		LocalDate currentdate = LocalDate.now();
		if(medicine.getMedicineId()==0) {
			throw new MedicineIdNullException();
		}
		else if(medicine.getMedicineCost()<0.0f) {
			throw new MedicineIllegalCostException();
		}		
		else if(currentdate.compareTo(medicine.getMfd())<0) {
			throw new MedicineIllegalMfdDateException();			
		}else {
		Medicine savedmedicine = medrepo.save(medicine);
		return savedmedicine;
		}
	}

	
	@Override
	public Medicine updateMedicine(Medicine medicine) throws Exception {
		LocalDate currentdate = LocalDate.now();
		if(medicine.getMedicineId()==0) {
			throw new MedicineIdNullException();
		}
		else if(medicine.getMedicineCost()<0.0f) {
			throw new MedicineIllegalCostException();
		}		
		else if(currentdate.compareTo(medicine.getMfd())<0) {
			throw new MedicineIllegalMfdDateException();			
		}
		
		Medicine updatedMed=new Medicine();
		if(medrepo.existsById(medicine.getMedicineId())){
			updatedMed = medrepo.save(medicine);
			return updatedMed;
		}
		return updatedMed;
	}

	
	@Override
	public List<Medicine> showAllMedicine() {
		List<Medicine> medlist = medrepo.findAll();
		return medlist;
	}


	@Override
	public Medicine viewMedicine(Medicine medicine) throws Exception {
		LocalDate currentdate = LocalDate.now();
		if(medicine.getMedicineId()==0) {
			throw new MedicineIdNullException();
		}
		else if(medicine.getMedicineCost()<0.0f) {
			throw new MedicineIllegalCostException();
		}		
		else if(currentdate.compareTo(medicine.getMfd())<0) {
			throw new MedicineIllegalMfdDateException();			
		}
		else {
		int medId = medicine.getMedicineId();
		Optional<Medicine> viewingMed = medrepo.findById(medId);
		return viewingMed.get();
		}
	}


	@Override
	public Medicine deleteMedicine(int id) throws MedicineIdNullException {
		if(id==0) {
			throw new MedicineIdNullException();
		}
		else {
		Optional<Medicine> medToDelete = medrepo.findById(id);
		medrepo.deleteById(id);;
		return medToDelete.get();
		}
	}
//	@Autowired
//	private MedicineRepository medicineRepository;
//
//	@Override
//	public Medicine addMedicine(Medicine medicine) {
//		Medicine addedMedicine = medicineRepository.save(medicine);
//		return addedMedicine;
//	}
//
//	@Override
//	public Medicine viewMedicine(int id) {
//		Optional<Medicine> med = medicineRepository.findById(id);
//		return med.get();
//	}
//
//	@Override
//	public Medicine deleteMedicine(int id) {
//		Optional<Medicine> med = medicineRepository.findById(id);
//		medicineRepository.deleteById(id);
//		return med.get();
//
//	}
//
//	@Override
//	public List<Medicine> showAllMedicine() {
//		List<Medicine> medicines = medicineRepository.findAll();
//		return medicines;
//	}
//
//	@Override
//	public Medicine updateMedicine(Medicine medicine) throws Exception {
//		LocalDate currentdate = LocalDate.now();
//		if (medicine.getMedicineId() == 0) {
//			throw new MedicineIdNullException();
//		} else if (medicine.getMedicineCost() < 0.0f) {
//			throw new MedicineIllegalCostException();
//		} else if (currentdate.compareTo(medicine.getMfd()) < 0) {
//			throw new MedicineIllegalMfdDateException();
//		} else if (medicine.getCategory().getCategoryId() == 0) {
//			throw new NullCategoryIdException();
//		}
//
//		Medicine updatedMed = new Medicine();
//		if (medicineRepository.existsById(medicine.getMedicineId())) {
//			updatedMed = medicineRepository.save(medicine);
//			return updatedMed;
//		}
//		return updatedMed;
//	}
}
