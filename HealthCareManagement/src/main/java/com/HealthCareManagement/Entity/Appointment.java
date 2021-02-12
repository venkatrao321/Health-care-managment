package com.HealthCareManagement.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ap_id")
	private Integer ap_id;

	@Column(length = 20, name = "date")
	private String date;

	@Column(length = 20, name = "time")
	private String time;

	@Column(length = 20, name = "patientName")
	private String patientName;

	@ManyToOne
	@JoinColumn(name = "d_id")
	private Doctor appDoctor;

	@OneToOne
	@JoinColumn(name = "p_id")
	private Patient appPatient;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(Integer ap_id, String date, String time, Doctor appDoctor, Patient appPatient,
			String patientName) {
		super();
		this.ap_id = ap_id;
		this.date = date;
		this.time = time;
		this.appDoctor = appDoctor;
		this.appPatient = appPatient;
		this.patientName = patientName;
	}

	public Integer getAp_id() {
		return ap_id;
	}

	public void setAp_id(Integer ap_id) {
		this.ap_id = ap_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Doctor getAppDoctor() {
		return appDoctor;
	}

	public void setAppDoctor(Doctor appDoctor) {
		this.appDoctor = appDoctor;
	}

	public Patient getAppPatient() {
		return appPatient;
	}

	public void setAppPatient(Patient appPatient) {
		this.appPatient = appPatient;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

}
