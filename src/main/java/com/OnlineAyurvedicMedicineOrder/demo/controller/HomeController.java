package com.OnlineAyurvedicMedicineOrder.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Medicine;
//import com.OnlineAyurvedicMedicineOrder.demo.service.CategoryService;
import com.OnlineAyurvedicMedicineOrder.demo.service.MedicineService;

@RestController
@CrossOrigin(origins="*")
public class HomeController {

//	@Autowired
//	CategoryService categoryService;

	@Autowired
	MedicineService medicineService;

	@GetMapping("")
	public ResponseEntity<String> home(Model model) {
		return new ResponseEntity<String>("Home page", HttpStatus.OK);
	}

	@GetMapping("/admin/home")
	public String viewAdminHomePage() {
		return "admin/admin_home";
	}

	@GetMapping("/customer/home")
	public String viewUserHomePage() {
		return "customer/customer_home";
	}

	@GetMapping("/admin/login")
	public String viewAdminLoginPage() {
		return "admin/admin_login";
	}

	@GetMapping("/customer/login")
	public String viewUserLoginPage() {
		return "customer/customer_login";
	}

//	@GetMapping("/shop")
//	public ResponseEntity<String> shop(Model model) {
//		model.addAttribute("categories", categoryService.getAllCategories());
//		model.addAttribute("medicines", medicineService.showAllMedicine());
//		return new ResponseEntity<String>("Viewing shop", HttpStatus.OK);
//	}

	/*
	 * @GetMapping("/shop/category/{id}") public String shopByCategory(Model
	 * model,@PathVariable int id) { model.addAttribute("categories",
	 * categoryService.getAllCategories()); model.addAttribute("medicines",
	 * medicineService.getAllMedicinesByCategoryId(id)); return "shop"; }
	 */

//	@GetMapping("/shop/viewmedicine/{id}")
//	public ResponseEntity<Medicine> viewMedicineGet(Model model, @PathVariable int id) {
//		// model.addAttribute("medicine",medicineService.viewMedicine(id).get());
//		Medicine med = medicineService.viewMedicine(id);
//		return new ResponseEntity<Medicine>(med, HttpStatus.OK);
//	}

}
