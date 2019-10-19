package com.spring.mvc.dao.role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dao.BaseDAO;
import com.spring.mvc.domain.Role;

@Repository
public class RoleDAOImpl extends BaseDAO implements RoleDAO{

	@Override
	public void save(Role role) {
		String sql = "INSERT INTO sysadmintool.role (rolename, displayname, status) VALUES"
				+ "(?,?,?)";
		Map m = new HashMap();
		m.put("rolename", role.getRolename());
		m.put("displayname", role.getDisplayname());
		m.put("status", role.getStatus());
		
		KeyHolder kh = new GeneratedKeyHolder();
		SqlParameterSource sqlparamsource = new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql, sqlparamsource, kh);
		role.setComponentId(kh.getKey().intValue());
	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Role> findByProperty(String searchobj, Object searchparam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
