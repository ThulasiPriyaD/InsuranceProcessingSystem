package com.app.dto;

import jakarta.validation.constraints.*;

public class PremiumDto {
	
	// Validation annotations for ensuring non-null, non-empty, and correct format values
	
	@NotBlank(message = "Policy number is required")
	@NotNull(message="Policy Number should not be Null")
    private String policyNumber;

	@Positive(message="Amount should be positive and not null ")
    private Double amount;
 
    @NotEmpty(message="Status should be ACTIVE or INACTIVE")
    private String status;

    /*************************************************************************************
     * Getter and setters for retrieving the fields.
     *************************************************************************************/
	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
      

}
