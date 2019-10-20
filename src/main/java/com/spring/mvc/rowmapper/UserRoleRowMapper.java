package com.spring.mvc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.mvc.domain.User;
import com.spring.mvc.domain.UserRole;

public class UserRoleRowMapper implements RowMapper<UserRole>{

	@Override
	public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserRole userrole = new UserRole();
		userrole.setComponentId(rs.getInt("componentid"));
		userrole.setRoleid(rs.getInt("roleid"));
		userrole.setUserid(rs.getInt("userid"));
		userrole.setStatus(rs.getByte("status"));
		userrole.setCreatedate(rs.getDate("createdate"));
		userrole.setUpdatedate(rs.getDate("updatedate"));
		return userrole;
	}

}
