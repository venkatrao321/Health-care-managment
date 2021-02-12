package com.HealthCareManagement.CrudService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareManagement.Entity.Doctor;
import com.HealthCareManagement.Entity.Receptionist;
import com.HealthCareManagement.Repository.Repository_Doctor;
import com.HealthCareManagement.Repository.Repository_Receptionist;

@Service
public class CrudService {
     @Autowired
	private Repository_Doctor repoDoc; 
     
     @Autowired
     private Repository_Receptionist repoReception;
     
    
     
	public List<Doctor> fetchDoctorsList(){
		return repoDoc.findAll() ;
	}
	
	public List<Receptionist>fetchReceptionistList(){
		return  repoReception.findAll();
	}
	
	
	public Doctor addDoctorTolist(Doctor doctor) {
		return repoDoc.save(doctor);
	}

	public Doctor fetchDocByEmail(String tempEmail) {
		// TODO Auto-generated method stub
		return repoDoc.findByEmail(tempEmail);
	}

	public Doctor saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return repoDoc.save(doctor);
	}

	public Receptionist addReceptionistTolist(Receptionist receptionist) {
		// TODO Auto-generated method stub
		return repoReception.save(receptionist);
	}

	
}
