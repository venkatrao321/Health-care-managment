package com.HealthCareManagement.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "d_id", updatable = false)
	private int d_id;

	@Column(name = "email")
	private String email;

	@Column(name = "userName")
	private String userName;

	@Column(name = "passWord")
	private String passWord;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "phoneNo")
	private int phoneNo;

	@Column(name = "address")
	private String address;

	@Column(name = "gender")
	private String gender;

	@Column(name = "age")
	private int age;

	@Column(name = "specalization")
	private String specalization;

	@JsonIgnore
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	private Set<Patient> Patient = new HashSet<Patient>();

	@JsonIgnore
	@OneToMany(mappedBy = "appDoctor", cascade = CascadeType.ALL)
	private Set<Appointment> appointments = new HashSet<Appointment>();

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(int d_id, String email, String userName, String passWord, String firstName, String lastName,
			int phoneNo, String address, String gender, int age, String specalization,
			Set<com.HealthCareManagement.Entity.Patient> patient, Set<Appointment> appointments) {
		super();
		this.d_id = d_id;
		this.email = email;
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.gender = gender;
		this.age = age;
		this.specalization = specalization;
		Patient = patient;
		this.appointments = appointments;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSpecalization() {
		return specalization;
	}

	public void setSpecalization(String specalization) {
		this.specalization = specalization;
	}

	@JsonIgnore
	public Set<Patient> getPatient() {
		return Patient;
	}

	public void setPatient(Set<Patient> patient) {
		Patient = patient;
	}

	@JsonIgnore
	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "Doctor [d_id=" + d_id + ", email=" + email + ", userName=" + userName + ", passWord=" + passWord
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo=" + phoneNo + ", address="
				+ address + ", gender=" + gender + ", age=" + age + ", specalization=" + specalization + ", Patient="
				+ Patient + ", appointments=" + appointments + "]";
	}

}
