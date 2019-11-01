package com.spring.mvc.services.user;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.BaseDAO;
import com.spring.mvc.dao.user.UserDAO;
import com.spring.mvc.domain.User;
import com.spring.mvc.exception.UserBlockedException;
import com.spring.mvc.rowmapper.UserRowMapper;

@Service
public class UserServiceImpl extends BaseDAO implements UserService{

	@Autowired
	private UserDAO usrdao;
	
	
	
	
	
	@Override
	public User Login(String username, String password) throws UserBlockedException {
		String sql = "SELECT 	componentId, username, fname, lname, email, password, status, createdate, updatedate FROM sysadmintool.user WHERE username = :username and password = :password;";
		Map m = new HashMap();
		m.put("username", username);
		m.put("password", password);
		
		try {
			User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
			if (u.getStatus() == 0) {
				throw new UserBlockedException("User Account is Blocked");
			}else {
				return u;
			}
		}catch(EmptyResultDataAccessException ex) {
			return null;
		}
	}

	@Override
	public void register(User user) {
		usrdao.save(user);
	}
	
	@Override
	public List<User> findAll(){
		return usrdao.findAll();
	}

	@Override
	public void save(User user) {
		System.out.println("UserServiceImpl Service");
		if (user != null) {
			System.out.println("UserServiceImpl Service : User is not null saving the user");
			usrdao.save(user);	
		}else {
			System.out.println("UserServiceImpl Service : User is Null. Unable to save");
		}
	}

	@Override
	public void update(User user) {
		java.sql.Timestamp getdatetime = new java.sql.Timestamp(new java.util.Date().getTime());
		if(user.getStatus() == null) {
			user.setStatus((byte) 1);
		}
		user.setUpdatedate(getdatetime);
		usrdao.update(user);
	}

	@Override
	public void delete(Integer userId) {
		usrdao.delete(userId);
	}

	@Override
	public List<User> findByProperty(String searchobj, Object searchparam) {
		return usrdao.findByProperty(searchobj, searchparam);
	}

	@Override
	public User findById(int componentId) {
		System.out.println("UserServiceImpl Service : findById = userid : "+ componentId);
		return usrdao.findById(componentId);
	}
	
	
	

}
