package com.HealthCareManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HealthCareManagement.Entity.Pharmacist;

public interface Repository_Pharmacist extends JpaRepository<Pharmacist, Integer>{

	Pharmacist findByUserNameAndPassWord(String tempUserName, String tempPassword);

}
