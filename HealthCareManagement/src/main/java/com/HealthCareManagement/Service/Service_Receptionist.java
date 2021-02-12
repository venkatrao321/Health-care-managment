package com.HealthCareManagement.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareManagement.Entity.Appointment;
import com.HealthCareManagement.Entity.Patient;
import com.HealthCareManagement.Entity.Receptionist;
import com.HealthCareManagement.Repository.Repository_Appointment;
import com.HealthCareManagement.Repository.Repository_Patient;
import com.HealthCareManagement.Repository.Repository_Receptionist;

import Exception.RecordNotFoundException;

@Service
public class Service_Receptionist {

	@Autowired
	Repository_Receptionist repo;
	@Autowired
	Repository_Patient Prepo;
	@Autowired
	Repository_Appointment apRepo;

	public Receptionist fetchReceptionistByUserNameAndPassWord(String tempUserName, String tempPassword) {
		// TODO Auto-generated method stub
		return repo.findByUserNameAndPassWord(tempUserName, tempPassword);
	}

	// find all patient
	public List<Patient>getAllPatient() {
		List<Patient> patientList = Prepo.findAll();

		if (patientList.size() > 0) {
			return patientList;
		} else {
			return new ArrayList<Patient>();
		}

	}
	 public Patient getPatientById(int id) throws RecordNotFoundException
     {
         Optional<Patient> patient = Prepo.findById(id);
          
         if(patient.isPresent()) {
             return patient.get();
         } else {
             throw new RecordNotFoundException("No patient record exist for given id",id);
         }
     }
	 public void deletePatientById(int id) throws RecordNotFoundException
	    {
	        Optional<Patient> patient = Prepo.findById(id);
	         
	        if(patient.isPresent())
	        {
	            Prepo.deleteById(id);
	        } else {
	            throw new RecordNotFoundException("No patient record exist for given id",id);
	        }
	    }
	 public Patient createOrUpdatePatient(Patient entity) throws RecordNotFoundException
	    {
	    	    	
	    	if(entity.getP_id() !=0)
	    	{
	    	  Optional<Patient> patient = Prepo.findById(entity.getP_id());
	        
	    	if(patient.isPresent())
	        {
	        	Patient newEntity = patient.get();
	           
	            newEntity.setFirstName(entity.getFirstName());
	            newEntity.setLastName(entity.getLastName());
	            newEntity.setPhoneNo(entity.getPhoneNo());
	            newEntity.setAddress(entity.getAddress());
	            newEntity.setAge(entity.getAge());
	            newEntity.setGender(entity.getGender());
	            newEntity.setBloodgrp(entity.getBloodgrp());
	            newEntity.setWeight(entity.getWeight());
	            newEntity.setDisease(entity.getDisease());
	            newEntity.setDoctor(entity.getDoctor());
	            
	 
	            newEntity = Prepo.save(newEntity);
	             
	            return newEntity;
	        } else {
	            entity = Prepo.save(entity);
	             
	            return entity;
	        }
	    	}
	    	
	    	else
	    	{
	    		entity = Prepo.save(entity);
	    		return entity;
	    	}	    
	 }

	public Patient updatePatient(int pid, Patient entity) throws RecordNotFoundException{
		
		Optional<Patient> extpatient=Prepo.findById(pid);
		if(extpatient.isPresent())
		{
			Patient newEntity = extpatient.get();
	           
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            newEntity.setPhoneNo(entity.getPhoneNo());
            newEntity.setAddress(entity.getAddress());
            newEntity.setAge(entity.getAge());
            newEntity.setGender(entity.getGender());
            newEntity.setBloodgrp(entity.getBloodgrp());
            newEntity.setWeight(entity.getWeight());
            newEntity.setDisease(entity.getDisease());
            newEntity.setDoctor(entity.getDoctor());
            
 
            newEntity = Prepo.save(newEntity);
            return newEntity;
		}else {
			throw new RecordNotFoundException("No patient record exist for given id",pid);
		}
		
	}
	//DeleteAppointment
	 public void deleteAppointmentById(int id) throws RecordNotFoundException
	    {
	        Optional<Appointment> appointment = apRepo.findById(id);
	         
	        if(appointment.isPresent())
	        {
	            apRepo.deleteById(id);
	        } else {
	            throw new RecordNotFoundException("No Appointment record exist for given id",id);
	        }
	    } 
	 public Appointment createOrUpdateAppointment(Appointment entity) throws RecordNotFoundException
	    {
	    	    	
	    	if(entity.getAp_id() !=0)
	    	{
	    	  Optional<Appointment> appointment =apRepo.findById(entity.getAp_id());
	        
	    	if(appointment.isPresent())
	        {
	    		Appointment newEntity = appointment.get();
	           
	            newEntity.setDate(entity.getDate());
	            newEntity.setTime(entity.getTime());
	            newEntity.setAppDoctor(entity.getAppDoctor());
	            newEntity.setAppPatient(entity.getAppPatient());
	            newEntity.setPatientName(entity.getPatientName());
	         
	 
	            newEntity = apRepo.save(newEntity);
	             
	            return newEntity;
	        } else {
	            entity = apRepo.save(entity);
	             
	            return entity;
	        }
	    	}
	    	
	    	else
	    	{
	    		entity = apRepo.save(entity);
	    		return entity;
	    	}	    
	 }
	 public List<Appointment>getAllAppointment() {
			List<Appointment> AppointmentList = apRepo.findAll();

			if (AppointmentList.size() > 0) {
				return AppointmentList;
			} else {
				return new ArrayList<Appointment>();
			}

		}
}
