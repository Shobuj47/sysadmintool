package com.spring.mvc.dao.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dao.*;
import com.spring.mvc.domain.User;
import com.spring.mvc.rowmapper.UserRowMapper;


@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {


	@Override
	public void save(User user) {
		
		System.out.println("UserDaoImpl DAO");
		
		//User Object Insert SQL Statement
		String sql = "INSERT INTO sysadmintool.user (username,  fname,  lname,  email,  password,  status, updatedate ) "
				+ "VALUES (:username,  :fname,  :lname,  :email,  :password,  :status, :updatedate );";
		System.out.println(sql);
		//Map all User object information and SQL Parameter in array 
		Map m = new HashMap();
		m.put("username", user.getUsername());
		m.put("fname", user.getFname());
		m.put("lname", user.getLname());
		m.put("email", user.getEmail());
		m.put("password", user.getPassword());
		m.put("status", user.getStatus());
		m.put("updatedate", user.getUpdatedate());

		//Keyholder to hold the componentId after inserting new record into database
		KeyHolder kh = new GeneratedKeyHolder();
		//Map all mapped values into sql query parameter
		SqlParameterSource sqlparamsource = new MapSqlParameterSource(m);
		//Execute SQL Query and hold the key into kh (KeyHolder)
		super.getNamedParameterJdbcTemplate().update(sql, sqlparamsource, kh);
		user.setComponentId(kh.getKey().intValue());
		System.out.println("UserDaoImpl DAO : User Saved");
	}

	@Override
	public void update(User user) {
		System.out.println("UserDaoImpl DAO");
		String sql = "UPDATE sysadmintool.user SET username = :username, fname = :fname, lname = :lname, email = :email, password = :password, status = :status, updatedate = :updatedate WHERE componentId = :componentId ;";
		System.out.println(sql);
		Map m = new HashMap();
		m.put("componentId", user.getComponentId());
		m.put("username", user.getUsername());
		m.put("fname", user.getFname());
		m.put("lname", user.getLname());
		m.put("email", user.getEmail());
		m.put("password", user.getPassword());
		m.put("status", user.getStatus());
		m.put("updatedate", user.getUpdatedate());
		getNamedParameterJdbcTemplate().update(sql, m);
		System.out.println("UserDaoImpl DAO : User Updated");
	}

	@Override
	public void delete(Integer userId) {
		System.out.println("UserDaoImpl DAO");
		String sql = "DELETE FROM sysadmintool.user WHERE componentId = ?";
		getJdbcTemplate().update(sql, userId);
		System.out.println("UserDaoImpl DAO : User Deleted");
		
	}

	@Override
	public List<User> findByProperty(String searchobj, Object searchparam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT 	componentId, username, fname, lname, email, password, status, createdate, updatedate  FROM sysadmintool.user ";
		List<User> usr = getJdbcTemplate().query(sql, new UserRowMapper());
		System.out.println("user list size " + usr.size());
		return usr;
	}

	@Override
	public User findById(int componentId) {
		String sql = "SELECT 	componentId, username, fname, lname, email, password, status, createdate, updatedate  FROM sysadmintool.user where componentid = ?";
		System.out.println("UserDAOImpl : findById = sql " + sql);
		User u =  getJdbcTemplate().queryForObject(sql, new UserRowMapper(), componentId);
		System.out.println("UserDAOImpl : returning User");
		return u;
	}

}
