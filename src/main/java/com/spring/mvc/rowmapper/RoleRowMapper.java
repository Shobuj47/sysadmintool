package com.spring.mvc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.mvc.domain.Role;

public class RoleRowMapper implements RowMapper<Role>{

	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		Role role = new Role();
		role.setComponentId(rs.getInt("componentid"));
		role.setDisplayname(rs.getString("displayname"));
		role.setRolename(rs.getString("rolename"));
		role.setStatus(rs.getByte("status"));
		return null;
	}

	
}
