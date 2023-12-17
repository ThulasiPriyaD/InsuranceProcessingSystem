package com.app.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="premium_Insurance")
public class Premium {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String policyNumber;
	private double amount;
	private String status;
	private LocalDate dueDate;

	@ManyToOne
	@JoinColumn(name="policy_Insurance_id")
	private Policy policy;

	//Default Constructor
	public Premium() {}

	// Constructor with parameters for creating a Premium object
	public Premium( String policyNumber, double amount, String status, LocalDate dueDate) {
		super();
		this.policyNumber = policyNumber;
		this.amount = amount;
		this.status = status;
		this.dueDate = dueDate;
	}



	/*************************************************************************************
	 * Getter and setters for retrieving the fields.
	 *************************************************************************************/
	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}


}
