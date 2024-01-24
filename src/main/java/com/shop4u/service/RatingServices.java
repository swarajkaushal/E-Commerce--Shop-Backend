package com.shop4u.service;

import java.util.List;

import com.shop4u.exception.ProductException;
import com.shop4u.modal.Rating;
import com.shop4u.modal.User;
import com.shop4u.request.RatingRequest;

public interface RatingServices {
	
	public Rating createRating(RatingRequest req,User user) throws ProductException;
	
	public List<Rating> getProductsRating(Long productId);

}
