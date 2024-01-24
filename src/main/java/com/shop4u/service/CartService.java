package com.shop4u.service;

import com.shop4u.exception.ProductException;
import com.shop4u.modal.Cart;
import com.shop4u.modal.CartItem;
import com.shop4u.modal.User;
import com.shop4u.request.AddItemRequest;

public interface CartService {
	
	public Cart createCart(User user);
	
	public String addCartItem(Long userId,AddItemRequest req) throws ProductException;
	
	public Cart findUserCart(Long userId);

}
