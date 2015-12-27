package com.nickrepetti.estore.dao;

import com.nickrepetti.estore.model.Item;
import com.nickrepetti.estore.model.User;

import com.nickrepetti.estore.util.UserNotFoundException;

public interface UserRepository {
	
	public User getUser(Long id) throws UserNotFoundException;
	
	public User addToCart(Long userId, Long itemId);
}