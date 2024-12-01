package com.kp.user.service.services;

import java.util.List;

import com.kp.user.service.models.UserDetails;

public interface UserService {

	UserDetails saveUser(UserDetails user);
	
	List<UserDetails> getAllUsers();
	
	UserDetails getUser(String userId);
}
