package com.spring.mvc.services.user;

import java.util.HashMap;
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

}
