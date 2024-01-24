package com.shop4u.service;

import java.util.List;

import com.shop4u.exception.ProductException;
import com.shop4u.modal.Review;
import com.shop4u.modal.User;
import com.shop4u.request.ReviewRequest;

public interface ReviewService {

	public Review createReview(ReviewRequest req,User user) throws ProductException;
	
	public List<Review> getAllReview(Long productId);
	
	
}
