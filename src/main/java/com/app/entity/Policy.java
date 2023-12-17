package com.app.entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "policy_Insurance")
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private Long policyNumber;
	private String policyType;
	private String policyName;
	private LocalDate startDate;
	private LocalDate endDate;
	private double amount;

	@ManyToOne
	@JoinColumn(name="policyholder_insurance_id")
	private PolicyHolder policyHolder;
	
	/*************************************************************************************
     * Getter and setters for retrieving the fields.
     *************************************************************************************/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public PolicyHolder getPolicyHolder() {
		return policyHolder;
	}
	public void setPolicyHolder(PolicyHolder policyHolder) {
		this.policyHolder = policyHolder;
	}
	public Long getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(Long policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	// Constructor with parameters for creating a Policy object
	public Policy(Long policyNumber, String policyType, String policyName, LocalDate startDate, LocalDate endDate,
			double amount) {
		super();
		this.policyNumber = policyNumber;
		this.policyType = policyType;
		this.policyName = policyName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
	}
	
	//Default Constructor
	public Policy() {
		super();
	}
}
