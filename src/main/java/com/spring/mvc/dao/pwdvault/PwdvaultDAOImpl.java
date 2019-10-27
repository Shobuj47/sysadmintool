package com.spring.mvc.dao.pwdvault;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dao.BaseDAO;
import com.spring.mvc.domain.PwdVaultUsers;
import com.spring.mvc.domain.Pwdvault;
import com.spring.mvc.rowmapper.PwdvaultRowMapper;
import com.spring.mvc.services.pam.PamService;


@Repository
public class PwdvaultDAOImpl extends BaseDAO implements PwdvaultDAO {


	
	
	@Override
	public void save(Pwdvault pwdvault) {
		String sql = "INSERT INTO sysadmintool.pwdvault ( displayname, serveraddr, username, password, createdate, updatedate, createdby, updatedby)"
				+ "VALUES	( :displayname, :serveraddr, :username, :password, :createdate, :updatedate, :createdby, :updatedby );";
		Map m = new HashMap();
		m.put("displayname", pwdvault.getDisplayname());
		m.put("serveraddr", pwdvault.getServeraddr());
		m.put("username", pwdvault.getUsername());
		m.put("password", pwdvault.getPassword());
		m.put("createdate", pwdvault.getCreatedate());
		m.put("updatedate", pwdvault.getUpdatedate());
		m.put("createdby", pwdvault.getCreatedby());
		m.put("updatedby", pwdvault.getUpdatedby());
		//Keyholder to hold the componentId after inserting new record into database
		KeyHolder kh = new GeneratedKeyHolder();
		//Map all mapped values into sql query parameter
		SqlParameterSource sqlparamsource = new MapSqlParameterSource(m);
		//Execute SQL Query and hold the key into kh (KeyHolder)
		super.getNamedParameterJdbcTemplate().update(sql, sqlparamsource, kh);
		pwdvault.setComponentId(kh.getKey().intValue());
		
	}

	@Override
	public void update(Pwdvault pwdvault) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int pwdvault) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pwdvault> findByProperty(String searchobj, Object searchparam) {
		String sql = "SELECT 	componentId, displayname, serveraddr, username, password, createdate, updatedate, createdby, updatedby FROM sysadmintool.pwdvault where " + searchobj +" = ?";
		List<Pwdvault> pwdvaultlist = getJdbcTemplate().query(sql, new PwdvaultRowMapper(), searchparam);
		return pwdvaultlist;
	}

	@Override
	public List<Pwdvault> findAll() {
		String sql = "SELECT 	componentId, displayname, serveraddr, username, password, createdate, updatedate, createdby, updatedby FROM sysadmintool.pwdvault ";
		List<Pwdvault> pwdvaultlist = getJdbcTemplate().query(sql, new PwdvaultRowMapper());
		return pwdvaultlist;
	}

	@Override
	public Pwdvault findById(int id) {
		String sql = "SELECT 	componentId, displayname, serveraddr, username, password, createdate, updatedate, createdby, updatedby FROM sysadmintool.pwdvault where componentId = ?";
		return getJdbcTemplate().queryForObject(sql, new PwdvaultRowMapper(), id);
	}
	

}
