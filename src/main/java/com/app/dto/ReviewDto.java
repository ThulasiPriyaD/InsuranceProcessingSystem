package com.app.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ReviewDto 
{
	
	@Positive(message = "review  should be positive")
	@Min(value = 1,message = "review shoulds be 1 to 10")
	@Max(value = 10,message = "review shoulds be 1 to 10")
	private Long review;
	
	
	@NotBlank(message = "Feedback should not be blank")
	@NotNull(message = "FeedBack should not be null")
	private String feedback;


	public Long getReview() {
		return review;
	}


	public void setReview(Long review) {
		this.review = review;
	}


	public String getFeedback() {
		return feedback;
	}


	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
}
