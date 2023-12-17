package com.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ClaimDto 
{
	// Claim number should not be blank and must not be null
	@NotBlank(message = "claimNumber is required")
	@NotNull(message = "claimNumber should not be null")
	private String claimNumber;
	
	// Amount should be positive and not null
	@Positive(message = "amount should be positive and not null")
	private double amount;
	
	// Status should not be blank and must not be null
	@NotNull(message = "status should not be null")
	@NotBlank(message="status is Required")
	private String status;
	
	/*************************************************************************************
     * Getter and setters for retrieving the fields.
     *************************************************************************************/
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	// Constructor with parameters for creating a ClaimDto object
	public ClaimDto(String claimNumber, double amount, String status) {
		super();
		this.claimNumber = claimNumber;
		this.amount = amount;
		this.status = status;
	}
	
	// Default constructor
	public ClaimDto() {
		super();
	}
	
	
}
