package com.spring.mvc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.mvc.domain.RoleFunctionCodes;
import com.spring.mvc.domain.User;

public class RoleFunctionCodeRowMapper implements RowMapper<RoleFunctionCodes>{

	@Override
	public RoleFunctionCodes mapRow(ResultSet rs, int rowNum) throws SQLException {
		RoleFunctionCodes rfc = new RoleFunctionCodes();
		rfc.setComponentId(rs.getInt("componentId"));
		rfc.setFuncid(rs.getInt("funcid"));
		rfc.setRoleid(rs.getInt("roleid"));
		rfc.setCreatedby(rs.getInt("createdby"));
		rfc.setUpdatedby(rs.getInt("updatedby"));
		rfc.setCreatedate(rs.getDate("createdate"));
		return rfc;
	}

}
