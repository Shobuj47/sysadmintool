package com.spring.mvc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.mvc.domain.Pwdvault;

public class PwdvaultRowMapper implements RowMapper<Pwdvault>{

	@Override
	public Pwdvault mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pwdvault pwdvault = new Pwdvault();
		pwdvault.setComponentId(rs.getInt("componentId"));
		pwdvault.setDisplayname(rs.getString("displayname"));
		pwdvault.setServeraddr(rs.getString("serveraddr"));
		pwdvault.setPort(rs.getInt("port"));
		pwdvault.setUsername(rs.getString("username"));
		pwdvault.setPassword(rs.getString("password"));
		pwdvault.setCreatedate(rs.getDate("createdate"));
		pwdvault.setUpdatedate(rs.getDate("updatedate"));
		pwdvault.setCreatedby(rs.getInt("createdby"));
		pwdvault.setUpdatedby(rs.getInt("updatedby"));
		return pwdvault;
	}

	
}
