package com.HealthCareManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HealthCareManagement.Entity.Admin;
import com.HealthCareManagement.Entity.Doctor;
import com.HealthCareManagement.Entity.Pharmacist;
import com.HealthCareManagement.Entity.Receptionist;
import com.HealthCareManagement.Service.Service_Admin;

@RestController
public class RegistrationAndLoginContoller_Admin {

	@Autowired
	private Service_Admin service;

	@PostMapping("/registerAdmin")
	public Admin registerAdmin(@RequestBody Admin admin) throws Exception {

		String tempemail = admin.getEmail();
		if (tempemail != null && !"".equals(tempemail)) {
			Admin adminObj = service.fetchAdminByEmail(tempemail);
			if (adminObj != null) {
				throw new Exception("admin with " + tempemail + "already exist");
			}
		}
		Admin adminObj = null;
		adminObj = service.saveAdmin(admin);
		return adminObj;
	}

	@PostMapping("/adminlogin")
	@CrossOrigin(origins = "http://localhost:4200")
	public Admin loginAdmin(@RequestBody Admin admin) throws Exception {
		String tempUserName = admin.getUserName();
		String tempPassword = admin.getPassWord();
		Admin adminObj = null;
		if (tempUserName != null && tempPassword != null) {
			adminObj = service.fetchAdminByUserNameAndPassWord(tempUserName, tempPassword);

		}
		if (adminObj == null) {
			throw new Exception("Wrong Credintials");
		}
		return adminObj;

	}

	@PutMapping("/updatePharmacist/{id}")
	public ResponseEntity<Pharmacist> updatepharmacist(@PathVariable int id, @RequestBody Pharmacist pharmacist) {
		pharmacist.setPh_id(id);
		return ResponseEntity.ok().body(service.updatePharmacist(pharmacist));
	}

	@GetMapping("/viewPharmacist")
	public ResponseEntity<List<Pharmacist>> getAllPharmacist() {
		return ResponseEntity.ok().body(service.getAllPharmacist());
	}

	@PutMapping("/updateReceptionist/{id}")
	public ResponseEntity<Receptionist> updateReceptionist(@PathVariable int id,
			@RequestBody Receptionist receptionist) {
		receptionist.setR_id(id);
		return ResponseEntity.ok().body(service.updateReceptionist(receptionist));
	}

	@GetMapping("/viewReceptionist")
	public ResponseEntity<List<Receptionist>> getAllReceptionist() {
		return ResponseEntity.ok().body(service.getAllReceptionist());
	}

	@PutMapping("/updateDoctor/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable int id, @RequestBody Doctor doctor) {
		doctor.getD_id();
		return ResponseEntity.ok().body(service.updateDoctor(doctor));
	}

	@GetMapping("/viewDoctor")
	public ResponseEntity<List<Doctor>> getAllDoctor() {
		return ResponseEntity.ok().body(service.getAllDoctor());
	}
}
