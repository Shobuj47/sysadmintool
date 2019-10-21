package com.spring.mvc.dao.rolefunctioncode;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.mvc.dao.BaseDAO;
import com.spring.mvc.domain.RoleFunctionCodes;
import com.spring.mvc.rowmapper.RoleFunctionCodeRowMapper;

@Repository
public class RoleFunctionCodeDAOImpl extends BaseDAO implements RoleFunctionCodeDAO{

	@Override
	public void save(RoleFunctionCodes rfc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(RoleFunctionCodes rfc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(RoleFunctionCodes rfc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RoleFunctionCodes> findByProperty(String searchobj, Object searchparam) {
		String sql = "SELECT 	componentId, roleid, funcid, createdate, createdby, updatedby FROM sysadmintool.rolefunctioncodes "
				+ "WHERE " + searchobj + " =?";
		return getJdbcTemplate().query(sql, new RoleFunctionCodeRowMapper(), searchparam);
	}

	@Override
	public List<RoleFunctionCodes> findAll() {
		String sql = "SELECT 	componentId, roleid, funcid, createdate, createdby, updatedby FROM sysadmintool.rolefunctioncodes ";
		return getJdbcTemplate().query(sql, new RoleFunctionCodeRowMapper());
	}

}
