package com.HealthCareManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HealthCareManagement.Entity.Admin;

public interface Repository_Admin extends JpaRepository<Admin, Integer> {

	Admin findByEmail(String email);

	Admin findByUserNameAndPassWord(String tempUserName, String tempPassword);

	

}
