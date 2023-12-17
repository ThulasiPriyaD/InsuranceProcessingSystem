package com.app.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.dto.ReviewDto;
import com.app.entity.Review;
import com.app.globalexception.NotFoundException;
import com.app.service.ReviewService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/review")
public class ReviewController 
{
	@Autowired
	ReviewService reviewService;
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@GetMapping("/getAllReviews")
	public List<Review> getAllReview()
	{
		logger.info("Fetching all reviews");
		return reviewService.getAllreview();
	}
	
	@PostMapping("/createReview")
	public ResponseEntity<Review> createReview(@Valid @RequestBody ReviewDto dto)
	{
		logger.info("Creating review");
		Review review=reviewService.createReview(dto);
		logger.warn("Invalid review data received");
		return ResponseEntity.status(HttpStatus.CREATED).body(review);
	}
	
	@DeleteMapping("/deleteReview/{reviewId}")
	public ResponseEntity<String> deleteById(@PathVariable Long reviewId) throws NotFoundException
	{
		String delete=reviewService.deleteReview(reviewId);
		logger.info("Deleting review with ID");
		return ResponseEntity.status(HttpStatus.CREATED).body(delete);
		
	}
}
