package com.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class policyDto
{
	 // Policy number should be positive and not null
	@Positive(message = "policy number should be positive and not null")
	private Long policyNumber;
	
	// Policy type should not be blank and must not be null
	@NotNull(message = "policy type should not be null")
	@NotBlank(message="policy type is Required")
	private String policyType;
	
	// Policy name should not be blank and must not be null
	@NotNull(message = "policyName should not be null")
	@NotBlank(message="policy name is Required")
	private String policyName;
	
	// Amount should be positive and not null
	@Positive(message = "amount should be positive and not null")
	private double amount;
	
	/*************************************************************************************
     * Getter and setters for retrieving the fields.
     *************************************************************************************/
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
