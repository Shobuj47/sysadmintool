package com.spring.mvc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.mvc.domain.FunctionCodes;
import com.spring.mvc.domain.Role;

public class FunctionCodeRowMapper  implements RowMapper<FunctionCodes>{

	@Override
	public FunctionCodes mapRow(ResultSet rs, int rowNum) throws SQLException {
		FunctionCodes fc = new FunctionCodes();
		fc.setComponentId(rs.getInt("componentId"));
		fc.setDisplayname(rs.getString("displayname"));
		fc.setFunctioncode(rs.getString("functioncode"));
		fc.setCreatedate(rs.getDate("createdate"));
		return fc;
	}
	
	
}
