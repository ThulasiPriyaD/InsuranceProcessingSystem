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
@Table(name="claim_Insurance")
public class Claim 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String claimNumber;
	private double amount;
	private LocalDate fillingDate;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="policy_Insurance_id")
	private Policy policy;
	
	@ManyToOne
	@JoinColumn(name="policyholder_insurance_id")
	private PolicyHolder policyHolder;
	
	@ManyToOne
	@JoinColumn(name="admin_Insurance_id")
	private Admin admin;
	

	/*************************************************************************************
     * Getter and setters for retrieving the fields.
     *************************************************************************************/
	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public PolicyHolder getPolicyHolder() {
		return policyHolder;
	}

	public void setPolicyHolder(PolicyHolder policyHolder) {
		this.policyHolder = policyHolder;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getClaimNumber() {
		return claimNumber;
	}
	
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public LocalDate getFillingDate() {
		return fillingDate;
	}
	public void setFillingDate(LocalDate fillingDate) {
		this.fillingDate = fillingDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	// Constructor with parameters for creating a Claim object
	public Claim(String claimNumber, double amount, LocalDate fillingDate, String status) {
		super();
		this.claimNumber = claimNumber;
		this.amount = amount;
		this.fillingDate = fillingDate;
		this.status = status;
	}
	
	//Default constructor
	public Claim() {
		super();
	}
	
	
	
}
