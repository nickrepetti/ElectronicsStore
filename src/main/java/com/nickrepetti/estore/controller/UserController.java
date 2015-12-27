package com.nickrepetti.estore.controller;

import com.nickrepetti.estore.dao.UserRepository;
import com.nickrepetti.estore.model.User;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
		
	private UserRepository userRepository;
	
	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getUser(
		@PathVariable Long userId) {
			
		return userRepository.getUser(userId);
	}
	
	@RequestMapping(value="/{userId}/items", method=RequestMethod.POST)
	public User addToCart(
		@PathVariable("userId") Long userId,
		@RequestParam("itemId") Long itemId) {
		
		return userRepository.addToCart(userId, itemId);
	}
}