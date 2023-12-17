package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ReviewDto;
import com.app.entity.Review;
import com.app.globalexception.NotFoundException;
import com.app.repository.ReviewRepo;

import jakarta.validation.Valid;

@Service
public class ReviewService {

	@Autowired
	ReviewRepo reviewRepo;

	public List<Review> getAllreview() {
		return reviewRepo.findAll();

	}

//	public Optional<Review> getByReviewId(Long reviewId) throws NotFoundException 
//	{	
//		if(reviewRepo.existsById(reviewId))
//		{
//			return reviewRepo.findById(reviewId);
//		}
//		else
//		{
//			throw new NotFoundException("reviewId not found");
//		}
//	}

	public Review createReview(@Valid ReviewDto dto)  {

		Review review = new Review();
		review.setFeedback(dto.getFeedback());
		review.setReview(dto.getReview());
		return reviewRepo.save(review);
	}

//	public String updateReview(Long reviewId, @Valid ReviewDto dto) throws NotFoundException {
//
//		if (reviewRepo.existsByreviewId(reviewId)) {
//			Review review = new Review();
//			review.setReview(dto.getReview());
//			review.setFeedback(dto.getFeedback());
//			reviewRepo.save(review);
//			return "updated successfully";
//		} else {
//			throw new NotFoundException("review Id not found");
//		}
//	}

	public String deleteReview(Long reviewId) throws NotFoundException {
		
		if(reviewRepo.existsById(reviewId))
		{
			reviewRepo.deleteById(reviewId);
			return " deleted successfully";
		}
		else
		{
			throw new NotFoundException("review Id not found");
		}
		
	}

}
