package com.HealthCareManagement.Controller;

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

import com.HealthCareManagement.Entity.Doctor;
import com.HealthCareManagement.Entity.Medicine;
import com.HealthCareManagement.Entity.Pharmacist;
import com.HealthCareManagement.Repository.Repository_Patient;
import com.HealthCareManagement.Service.Service_Pharmacist;

import Exception.RecordNotFoundException;

@RestController
public class LoginController_Pharmacist {
	@Autowired
	Service_Pharmacist service;

	@PostMapping("/pharmacistlogin")
	@CrossOrigin(origins = "http://localhost:4200")
	public Pharmacist loginPharmacist(@RequestBody Pharmacist pharmacist) throws Exception {

		String tempUserName = pharmacist.getUserName();
		String tempPassword = pharmacist.getPassWord();
		Pharmacist pharmacistObj = null;
		if (tempUserName != null && tempPassword != null) {
			pharmacistObj = service.fetchpharmacistByUserNameAndPassWord(tempUserName, tempPassword);

		}
		if (pharmacistObj == null) {
			throw new Exception("Wrong Credintials");
		}
		return pharmacistObj;

	}

	@PostMapping("/addmedicine")
	public ResponseEntity<Medicine> createMedicine(@RequestBody Medicine medicine) {
		return ResponseEntity.ok().body(this.service.createMedicine(medicine));
	}

	@GetMapping("/viewMedicine")
	public ResponseEntity<List<Medicine>> getAllMedicine() {
		return ResponseEntity.ok().body(service.getAllMedicine());
	}

	@DeleteMapping("/deletemedicine/{id}")
	public HttpStatus deleteMedicine(@PathVariable int id) throws RecordNotFoundException {
		this.service.deleteMedicine(id);
		return HttpStatus.OK;
	}

	@GetMapping("/getMedicineById/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable int id) {
		return ResponseEntity.ok().body(service.getMedicineById(id));
	}

	@PutMapping("/updateMedicine/{id}")
	public ResponseEntity<Medicine> updateProduct(@PathVariable int id, @RequestBody Medicine medicine) {
		medicine.setM_id(id);
		return ResponseEntity.ok().body(service.updateMedicine(medicine));
	}

}
