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
import com.spring.mvc.rowmapper.RoleRowMapper;

@Repository
public class RoleDAOImpl extends BaseDAO implements RoleDAO{

	@Override
	public void save(Role role) {
		String sql = "INSERT INTO sysadmintool.role (rolename, displayname, status) VALUES"
				+ "(:rolename, :displayname, :status)";
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
		String sql = "UPDATE sysadmintool.role SET rolename = :rolename, displayname = :displayname, status = :status  WHERE componentId = :componentId ;";
		Map m = new HashMap();
		m.put("componentId", role.getComponentId());
        m.put("rolename", role.getRolename());
        m.put("displayname", role.getDisplayname());
        m.put("status", role.getStatus());
		getNamedParameterJdbcTemplate().update(sql, m);
	}

	@Override
	public void delete(int roleId) {
		String sql = "DELETE FROM sysadmintool.role WHERE componentId = ? ";
		getJdbcTemplate().update(sql, roleId);
		
	}

	@Override
	public List<Role> findByProperty(String searchobj, Object searchparam) {
		String sql = "SELECT 	componentId, rolename, displayname, status FROM sysadmintool.role WHERE " + searchobj + " =?";
		return getJdbcTemplate().query(sql, new RoleRowMapper(), searchparam);
	}

	@Override
	public List<Role> findAll() {
		String sql = "SELECT componentId, rolename, displayname, status FROM sysadmintool.role";
		List<Role> rolelist = getJdbcTemplate().query(sql, new RoleRowMapper());
		System.out.println(sql);
		System.out.println("Total Available Roles " + rolelist.size() + " Printing Display Names from findall into dao");
		for (Role r1 : rolelist){
			System.out.println(r1.getDisplayname());
		}
		return rolelist;
	}

	@Override
	public Role findById(Integer componentId) {
		System.out.println(" RoleDAOImpl : findById " + componentId);
		String sql = "SELECT componentId, rolename, displayname, status FROM sysadmintool.role where componentid = ?";
		return getJdbcTemplate().queryForObject(sql, new RoleRowMapper(), componentId);
	}

}
