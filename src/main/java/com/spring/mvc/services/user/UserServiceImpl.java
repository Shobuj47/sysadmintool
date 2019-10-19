package com.spring.mvc.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.BaseDAO;
import com.spring.mvc.dao.user.UserDAO;
import com.spring.mvc.domain.User;
import com.spring.mvc.exception.UserBlockedException;

@Service
public class UserServiceImpl extends BaseDAO implements UserService{

	@Autowired
	private UserDAO usrdao;
	
	@Override
	public User Login(String username, String password) throws UserBlockedException {
		
		return null;
	}

	@Override
	public void register(User user) {
		usrdao.save(user);
	}

}
