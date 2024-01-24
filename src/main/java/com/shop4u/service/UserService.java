package com.shop4u.service;

import com.shop4u.exception.UserException;
import com.shop4u.modal.User;

public interface UserService {
	
	public User findUserById(Long userId) throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;

}
