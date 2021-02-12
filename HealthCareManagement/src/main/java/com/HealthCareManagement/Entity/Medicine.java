package com.HealthCareManagement.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medicine")
public class Medicine {
	
	@Id
	@Column(name = "m_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int m_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "mfd")
	private String mfd;
	
	@Column(name = "expiry")
	private String expiry;

	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medicine(int m_id, String name, int amount, int quantity, String mfd, String expiry) {
		super();
		this.m_id = m_id;
		this.name = name;
		this.amount = amount;
		this.quantity = quantity;
		this.mfd = mfd;
		this.expiry = expiry;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getMfd() {
		return mfd;
	}

	public void setMfg(String mfd) {
		this.mfd = mfd;
	}
	
	
}
