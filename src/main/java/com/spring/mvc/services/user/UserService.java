package com.spring.mvc.services.user;

import java.util.List;

import com.spring.mvc.domain.User;
import com.spring.mvc.exception.UserBlockedException;

public interface UserService {

	public User Login(String username, String password) throws UserBlockedException;	
	public void register(User user);
	public List<User> findAll();
}
