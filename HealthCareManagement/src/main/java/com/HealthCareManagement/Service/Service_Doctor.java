package com.HealthCareManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareManagement.Entity.Appointment;
import com.HealthCareManagement.Entity.Doctor;
import com.HealthCareManagement.Repository.Repository_Appointment;
import com.HealthCareManagement.Repository.Repository_Doctor;

@Service
public class Service_Doctor {

	@Autowired
	Repository_Doctor repo;
	@Autowired
	Repository_Appointment Arepo;
	public Doctor fetchDoctorByUserNameAndPassWord(String tempUserName, String tempPassword) {
		// TODO Auto-generated method stub
		return  repo.findByUserNameAndPassWord(tempUserName,tempPassword);
	}
    public List< Appointment> getAllAppointmentByDoctorId(int id) {
    	return repo.getAppointmentsByDoctorId(id);
    }
}
