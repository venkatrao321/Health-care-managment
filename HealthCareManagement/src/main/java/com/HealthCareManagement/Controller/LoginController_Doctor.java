package com.HealthCareManagement.Controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HealthCareManagement.Entity.Appointment;
import com.HealthCareManagement.Entity.Doctor;
import com.HealthCareManagement.Service.Service_Doctor;



@RestController
public class LoginController_Doctor {

	@Autowired
	private Service_Doctor loginservice;

	@PostMapping("/doctorlogin")
	@CrossOrigin(origins = "http://localhost:4200")
	public Doctor loginDoctor(@RequestBody Doctor doctor) throws Exception {

		String tempUserName = doctor.getUserName();
		String tempPassword = doctor.getPassWord();
		Doctor doctorObj = null;
		if (tempUserName != null && tempPassword != null) {
			doctorObj = loginservice.fetchDoctorByUserNameAndPassWord(tempUserName, tempPassword);

		}
		if (doctorObj == null) {
			throw new Exception("Wrong Credintials");
		}
		return doctorObj;

	}
	@GetMapping("/GetAppo")
	public List<Appointment>getAppoinmentsByDoctorId(@RequestParam("D_id") int id)
	{
		return loginservice.getAllAppointmentByDoctorId(id);
		
	}

}
