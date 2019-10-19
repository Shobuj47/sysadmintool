package com.spring.mvc.dao.user;

import java.util.List;

import com.spring.mvc.domain.User;
import com.spring.mvc.dao.*;

public interface UserDAO{
	public void save(User user);
	public void update(User user);
	public void delete(User user);
	public List<User> findByProperty(String searchobj, Object searchparam);
	public List<User> findAll();
}
