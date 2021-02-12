package com.HealthCareManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HealthCareManagement.Entity.Appointment;
@Repository
public interface Repository_Appointment extends JpaRepository<Appointment, Integer>{
	
}


