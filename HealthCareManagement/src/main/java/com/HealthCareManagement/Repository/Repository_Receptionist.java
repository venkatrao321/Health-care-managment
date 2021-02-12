package com.HealthCareManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HealthCareManagement.Entity.Receptionist;

public interface Repository_Receptionist extends JpaRepository <Receptionist, Integer> {

	Receptionist findByUserNameAndPassWord(String tempUserName, String tempPassword);

}
