package com.HealthCareManagement.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HealthCareManagement.Entity.Appointment;
import com.HealthCareManagement.Entity.Patient;
import com.HealthCareManagement.Entity.Receptionist;
import com.HealthCareManagement.Repository.Repository_Patient;
import com.HealthCareManagement.Service.Service_Receptionist;

import Exception.RecordNotFoundException;

@RestController
public class LoginController_Receptionist {

	@Autowired
	private Service_Receptionist service;

	@Autowired
	private Repository_Patient repos;

	@PostMapping("/receptionistlogin")
	@CrossOrigin(origins = "http://localhost:4200")
	public Receptionist loginReceptionist(@RequestBody Receptionist receptionist) throws Exception {

		String tempUserName = receptionist.getUserName();
		String tempPassword = receptionist.getPassWord();
		Receptionist receptionistObj = null;
		if (tempUserName != null && tempPassword != null) {
			receptionistObj = service.fetchReceptionistByUserNameAndPassWord(tempUserName, tempPassword);

		}
		if (receptionistObj == null) {
			throw new Exception("Wrong Credintials");
		}
		return receptionistObj;

	}

	@GetMapping("/getallpatient")
	public ResponseEntity<List<Patient>> getAllPatient() {
		List<Patient> list = service.getAllPatient();

		return new ResponseEntity<List<Patient>>(list, HttpStatus.OK);
	}

	@GetMapping("/getpatientbyid{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable("id") int id) throws RecordNotFoundException {
		Patient entity = service.getPatientById(id);

		return new ResponseEntity<Patient>(entity, HttpStatus.OK);
	}

	@DeleteMapping("/deletePatient{id}")
	public HttpStatus deletePatientById(@PathVariable("id") int id) throws RecordNotFoundException {
		service.deletePatientById(id);
		return HttpStatus.FORBIDDEN;
	}

	@PostMapping("/createPatient")
	public ResponseEntity<Patient> createOrUpdateStudent(@Validated @RequestBody Patient patient)
			throws RecordNotFoundException {
		Patient updated = service.createOrUpdatePatient(patient);
		return new ResponseEntity<Patient>(updated, HttpStatus.OK);
	}

	@PutMapping("/update/{pid}")
	public ResponseEntity<Patient> updatePatient(@PathVariable int pid, @RequestBody Patient p) {
		Patient patient = service.updatePatient(pid, p);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}

	@GetMapping("/getallAppointment")
	public ResponseEntity<List<Appointment>> getAllAppointment() {
		List<Appointment> list = service.getAllAppointment();

		return new ResponseEntity<List<Appointment>>(list, HttpStatus.OK);
	}

	@DeleteMapping("/deleteAppointment{id}")
	public HttpStatus deleteAppointmentById(@PathVariable("id") int id) throws RecordNotFoundException {
		service.deleteAppointmentById(id);
		return HttpStatus.OK;
	}

	@PostMapping("/createAppointment")
	public ResponseEntity<Appointment> createOrUpdateAppointment(@Validated @RequestBody Appointment appointment)
			throws RecordNotFoundException {
		Appointment updated = service.createOrUpdateAppointment(appointment);
		return new ResponseEntity<Appointment>(updated, HttpStatus.OK);
	}
}
