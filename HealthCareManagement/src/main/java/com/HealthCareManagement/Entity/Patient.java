package com.HealthCareManagement.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	int p_id;
	@Column(name = "firstName")
	String firstName;
	@Column(name = "lastName")
	String lastName;
	@Column(name = "phoneNo")
	int phoneNo;
	@Column(name = "address")
	String address;
	@Column(name = "age")
	int age;
	@Column(name = "gender")
	String gender;
	@Column(name = "bloodgrp")
	String bloodgrp;
	@Column(name = "weight")
	String weight;
	@Column(name = "disease")
	String disease;

	@ManyToOne
	@JoinColumn(name = "d_id")
	private Doctor doctor;

	@JsonIgnore
	@OneToOne(mappedBy = "appPatient", cascade = CascadeType.ALL)
	private Appointment appointment;

	public Patient() {
		super();

	}

	public Patient(int p_id, String firstName, String lastName, int phoneNo, String address, int age, String gender,
			String bloodgrp, String weight, String disease, Doctor doctor, Appointment appointment) {
		super();
		this.p_id = p_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.age = age;
		this.gender = gender;
		this.bloodgrp = bloodgrp;
		this.weight = weight;
		this.disease = disease;
		this.doctor = doctor;
		this.appointment = appointment;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodgrp() {
		return bloodgrp;
	}

	public void setBloodgrp(String bloodgrp) {
		this.bloodgrp = bloodgrp;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Patient [P_id=" + p_id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo=" + phoneNo
				+ ", address=" + address + ", age=" + age + ", gender=" + gender + ", bloodgrp=" + bloodgrp
				+ ", weight=" + weight + ", disease=" + disease + ", doctor=" + doctor + "]";
	}

}
