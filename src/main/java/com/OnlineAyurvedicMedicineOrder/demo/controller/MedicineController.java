package com.OnlineAyurvedicMedicineOrder.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.OnlineAyurvedicMedicineOrder.demo.entity.Medicine;
import com.OnlineAyurvedicMedicineOrder.demo.exception.MedicineIdNullException;
import com.OnlineAyurvedicMedicineOrder.demo.service.MedicineService;

@RestController
@CrossOrigin(origins="*")
public class MedicineController {

	
	@Autowired
	private MedicineService medserv;
	
	@PostMapping("/medicine")
	public ResponseEntity<String> addMedicine(@RequestBody Medicine med) throws Exception{
		Medicine addedMed = medserv.addMedicine(med);
		return new ResponseEntity<String>("medicine added successfully",HttpStatus.CREATED);
	}
	
	@GetMapping("/medicines")
	public ResponseEntity<List<Medicine>> showAllMedicine(){
		List<Medicine> medList = medserv.showAllMedicine();
		return new ResponseEntity<List<Medicine>>(medList,HttpStatus.OK);
	}
	
	@GetMapping("/medicines/medicine")
	public ResponseEntity<Medicine> viewMedicine(@RequestBody Medicine med) throws Exception{
		Medicine viewingMed = medserv.viewMedicine(med);
		return new ResponseEntity<Medicine>(viewingMed,HttpStatus.OK);
	}
	
	@GetMapping("/medicines/{medicineId}")
	public ResponseEntity<Medicine> deleteMedicine(@PathVariable int medicineId) throws MedicineIdNullException{
		Medicine deletedMed = medserv.deleteMedicine(medicineId);	
		return new ResponseEntity<Medicine>(deletedMed,HttpStatus.OK);
	}
	
	@GetMapping("/medicines/updateMedicine")
	public ResponseEntity<Medicine> updateMedicine(@RequestBody Medicine med) throws Exception{
		Medicine updatedMed = medserv.updateMedicine(med);
		return new ResponseEntity<Medicine>(updatedMed,HttpStatus.OK);
	}
//	@Autowired
//	private CategoryService categoryService;
//
//	@Autowired
//	private MedicineService medserv;
//
//	@PostMapping("/medicine")
//	public ResponseEntity<String> addMedicine(@RequestBody Medicine med) throws Exception {
//		Medicine addedMed = medserv.addMedicine(med);
//		return new ResponseEntity<String>("medicine added successfully",HttpStatus.CREATED);
//	}
//
//	@GetMapping("/medicines")
//	public ResponseEntity<List<Medicine>> showAllMedicine() {
//		List<Medicine> medList = medserv.showAllMedicine();
//		return new ResponseEntity<List<Medicine>>(medList, HttpStatus.OK);
//	}
//
//	@GetMapping("/medicines/medicine")
//	public ResponseEntity<Medicine> viewMedicine(@RequestBody Medicine med) throws Exception {
//		Medicine viewingMed = medserv.viewMedicine(med.getMedicineId());
//		return new ResponseEntity<Medicine>(viewingMed, HttpStatus.OK);
//	}
//
//	@GetMapping("/medicines/{medicineId}")
//	public ResponseEntity<Medicine> deleteMedicine(@PathVariable int medicineId) throws MedicineIdNullException {
//		Medicine deletedMed = medserv.deleteMedicine(medicineId);
//		return new ResponseEntity<Medicine>(deletedMed, HttpStatus.OK);
//	}
//
//	@GetMapping("/medicines/updateMedicine")
//	public ResponseEntity<Medicine> updateMedicine(@RequestBody Medicine med) throws Exception {
//		Medicine updatedMed = medserv.updateMedicine(med);
//		return new ResponseEntity<Medicine>(updatedMed, HttpStatus.OK);
//	}
}
