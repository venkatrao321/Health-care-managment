package com.HealthCareManagement.CrudController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HealthCareManagement.CrudService.CrudService;
import com.HealthCareManagement.Entity.Admin;
import com.HealthCareManagement.Entity.Doctor;
import com.HealthCareManagement.Entity.Receptionist;
import com.HealthCareManagement.Service.Service_Doctor;


@RestController
public class CrudController {
   
	@Autowired
	private CrudService crudService;
	
	
	
	 //to fetch list of doctors from database
	@GetMapping("/getDoctorsList")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Doctor> fetchDoctorsList(){
		List<Doctor>doctors= new ArrayList<Doctor>();
		doctors=	crudService.fetchDoctorsList();
		return doctors;
		
	}
	
	@PostMapping("/addDoctor")
	@CrossOrigin(origins="http://localhost:4200")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
	return	crudService.addDoctorTolist(doctor);
	}
	
	@GetMapping("/getReceptionistsList")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Receptionist>fetchReceptionistsList(){
		List<Receptionist>receptionists=new ArrayList<Receptionist>();
		receptionists=crudService.fetchReceptionistList();
		return receptionists;
	}
	
	@PostMapping("/addReceptionist")
	@CrossOrigin(origins="http://localhost:4200")
	public Receptionist addReceptionist(@RequestBody Receptionist receptionist) {
	return	crudService.addReceptionistTolist(receptionist);
	}
	
	
	
	/*
	 * @PostMapping("/addDoctornew")
	 * 
	 * @CrossOrigin(origins="http://localhost:4200") public Doctor
	 * loginDoctor(@RequestBody Doctor doctor) throws Exception { String
	 * tempUserName = doctor.getUserName(); String tempPassword = doctor
	 * .getPassWord(); Doctor docObj=null; if (tempUserName!=null &&
	 * tempPassword!=null) {
	 * docObj=registerService.fetchDoctorByUserNameAndPassWord(tempUserName,
	 * tempPassword);
	 * 
	 * } if (docObj==null) { throw new Exception("Wrong Credintials"); } return
	 * docObj;
	 * 
	 * 
	 * }
	 */
	
	
}
