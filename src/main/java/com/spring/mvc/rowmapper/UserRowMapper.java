package com.spring.mvc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.mvc.domain.User;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u = new User();
		u.setComponentId(rs.getInt("componentid"));
		u.setUsername(rs.getString("username"));
		u.setFname(rs.getString("fname"));
		u.setLname(rs.getString("lname"));
		u.setEmail(rs.getString("email"));
		u.setStatus(rs.getByte("status"));
		u.setCreatedate(rs.getDate("createdate"));
		u.setUpdatedate(rs.getDate("updatedate"));
		return u;
	}

}
