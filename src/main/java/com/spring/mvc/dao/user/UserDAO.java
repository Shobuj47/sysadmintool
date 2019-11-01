package com.spring.mvc.dao.user;

import java.util.List;

import com.spring.mvc.domain.User;
import com.spring.mvc.dao.*;

public interface UserDAO{
	public void save(User user);
	public void update(User user);
	public void delete(Integer userId);
	public List<User> findByProperty(String searchobj, Object searchparam);
	public User findById(int componentId);
	public List<User> findAll();
}
