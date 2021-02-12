package com.HealthCareManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.HealthCareManagement.Entity.Appointment;
import com.HealthCareManagement.Entity.Doctor;



public interface Repository_Doctor extends JpaRepository<Doctor, Integer> {

	Doctor findByUserNameAndPassWord(String tempUserName, String tempPassword);

	Doctor findByEmail(String tempEmail);
	
	@Query("select v from Appointment v where v.appDoctor.d_id =:did")
	List<Appointment> getAppointmentsByDoctorId(@Param("did") int doc_id);
}
