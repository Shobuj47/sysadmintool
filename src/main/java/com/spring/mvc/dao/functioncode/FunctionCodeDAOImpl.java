package com.spring.mvc.dao.functioncode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dao.BaseDAO;
import com.spring.mvc.domain.FunctionCodes;
import com.spring.mvc.rowmapper.FunctionCodeRowMapper;

@Repository
public class FunctionCodeDAOImpl extends BaseDAO implements FunctionCodeDAO {

	@Override
	public void save(FunctionCodes fc) {
		//User Object Insert SQL Statement
		String sql = "INSERT INTO sysadmintool.functioncodes (displayname, functioncode, createdate )"	
				+ "VALUES (:displayname, :functioncode, :createdate: )";
		//Map all User object information and SQL Parameter in array 
		Map m = new HashMap();
		m.put("displayname", fc.getDisplayname());
		m.put("functioncode", fc.getFunctioncode());
		m.put("createdate", fc.getCreatedate());
		
		//Keyholder to hold the componentId after inserting new record into database
		KeyHolder kh = new GeneratedKeyHolder();
		//Map all mapped values into sql query parameter
		SqlParameterSource sqlparamsource = new MapSqlParameterSource(m);
		//Execute SQL Query and hold the key into kh (KeyHolder)
		super.getNamedParameterJdbcTemplate().update(sql, sqlparamsource, kh);
		fc.setComponentId(kh.getKey().intValue());
	}

	@Override
	public void update(FunctionCodes fc) {
		String sql = "UPDATE sysadmintool.functioncodes SET displayname = :displayname, functioncode = :functioncode, createdate = :createdate  WHERE componentId = :componentId";
		Map m = new HashMap();
		m.put("displayname", fc.getDisplayname());
		m.put("functioncode", fc.getFunctioncode());
		m.put("createdate", fc.getCreatedate());
		getNamedParameterJdbcTemplate().update(sql, m);
	}

	@Override
	public void delete(int fcId) {
		String sql = "DELETE FROM sysadmintool.functioncodes WHERE componentId = ?";
		 getJdbcTemplate().update(sql, fcId);
	}

	@Override
	public List<FunctionCodes> findByProperty(String searchobj, Object searchparam) {
		String sql = "SELECT 	componentId, displayname, functioncode, createdate FROM sysadmintool.functioncodes "
				+ "WHERE "+ searchobj + " = ? ";
		return getJdbcTemplate().query(sql, new FunctionCodeRowMapper(), searchparam);
	}

	@Override
	public List<FunctionCodes> findAll() {
		String sql = "SELECT 	componentId, displayname, functioncode, createdate FROM sysadmintool.functioncodes "; 
		return getJdbcTemplate().query(sql, new FunctionCodeRowMapper());
	}

	
}
