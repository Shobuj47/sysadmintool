package com.spring.mvc.dao.userrole;

import java.sql.Array;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dao.BaseDAO;
import com.spring.mvc.domain.UserRole;
import com.spring.mvc.rowmapper.UserRoleRowMapper;

@Repository
public class UserRoleDAOImpl extends BaseDAO implements UserRoleDAO {

	@Override
	public void save(UserRole userrole) {
		String sql = "INSERT INTO sysadmintool.userrole (userid, roleid, status, updatedate ) "
				+ "VALUES (:userid, :roleid, :status, :updatedate );";
		Map m = new HashMap();
		m.put("userid", userrole.getUserid());
		m.put("roleid", userrole.getRoleid());
		m.put("status", userrole.getStatus());
		m.put("updatedate", userrole.getUpdatedate());
		
		KeyHolder kh = new GeneratedKeyHolder();
		//Map all mapped values into sql query parameter
		SqlParameterSource sqlparamsource = new MapSqlParameterSource(m);
		//Execute SQL Query and hold the key into kh (KeyHolder)
		super.getNamedParameterJdbcTemplate().update(sql, sqlparamsource, kh);
		userrole.setComponentId(kh.getKey().intValue());
	}

	@Override
	public void update(UserRole userrole) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserRole userrole) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserRole> findByProperty(String searchobj, Object searchparam) {
		String sql ="SELECT DISTINCT roleid FROM sysadmintool.userrole WHERE " + searchobj + " = ?;";
		return getJdbcTemplate().query(sql, new UserRoleRowMapper(), searchparam);
	}

	@Override
	public List<UserRole> findAll() {
		String sql = "SELECT componentId, userid, roleid, status, createdate, updatedate FROM sysadmintool.userrole";
		return getJdbcTemplate().query(sql, new UserRoleRowMapper());
	}
	
	//Return a list of role id of associated user
	public List<UserRole> getUserRoleIdList(int userId){
		String sql = "SELECT DISTINCT roleid FROM sysadmintool.userrole WHERE userid = ?";
		return getJdbcTemplate().query(sql, new UserRoleRowMapper(), userId);
	}
	

}
