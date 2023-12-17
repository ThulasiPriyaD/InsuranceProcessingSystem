package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Review")
public class Review 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	

	private Long review;

	private String feedback;
	
	public Review() {}

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
