package com.sprint;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.controller.ReviewController;
import com.app.service.ReviewService;

@ExtendWith(MockitoExtension.class)
public class ReviewTest {

	@Mock
	private ReviewService reviewService;
	
	@InjectMocks
	private ReviewController reviewController;
	
	@Test
	public void testGetAllReview()
	{
		equals(reviewController.getAllReview());
	}
	
}
