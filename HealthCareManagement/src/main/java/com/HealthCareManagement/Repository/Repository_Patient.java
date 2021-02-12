package com.HealthCareManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HealthCareManagement.Entity.Patient;

public interface Repository_Patient extends JpaRepository<Patient,Integer>{

}
