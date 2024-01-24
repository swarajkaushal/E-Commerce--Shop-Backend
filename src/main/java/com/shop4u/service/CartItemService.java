package com.shop4u.service;

import com.shop4u.exception.CartItemException;
import com.shop4u.exception.UserException;
import com.shop4u.modal.Cart;
import com.shop4u.modal.CartItem;
import com.shop4u.modal.Product;

public interface CartItemService {
	
	public CartItem createCartItem(CartItem cartItem);
	
	public CartItem updateCartItem(Long userId, Long id,CartItem cartItem) throws CartItemException, UserException;
	
	public CartItem isCartItemExist(Cart cart,Product product,String size, Long userId);
	
	public void removeCartItem(Long userId,Long cartItemId) throws CartItemException, UserException;
	
	public CartItem findCartItemById(Long cartItemId) throws CartItemException;
	
}
