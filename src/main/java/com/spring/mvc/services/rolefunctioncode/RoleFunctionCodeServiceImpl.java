package com.spring.mvc.services.rolefunctioncode;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.mvc.dao.BaseDAO;
import com.spring.mvc.dao.functioncode.FunctionCodeDAO;
import com.spring.mvc.dao.rolefunctioncode.RoleFunctionCodeDAO;
import com.spring.mvc.domain.FunctionCodes;
import com.spring.mvc.domain.Role;
import com.spring.mvc.domain.RoleFunctionCodes;
import com.spring.mvc.domain.UserRole;
import com.spring.mvc.rowmapper.FunctionCodeRowMapper;
import com.spring.mvc.services.userrole.UserRoleService;

@Service
public class RoleFunctionCodeServiceImpl extends BaseDAO implements RoleFunctionCodeService{

	@Autowired
	FunctionCodeDAO fcdao;
	@Autowired
	RoleFunctionCodeDAO rfcdao;
	@Autowired
	UserRoleService usrrolesrv;
	
	@Override
	public List<FunctionCodes> getRoleFunctionCodes(Role role) {
		List<FunctionCodes> fcl = fcdao.findByProperty("componentid", role.getComponentId());
		return fcl;
	}
	
	
	
	//Return a list of distinct url list from given list of roleid
	@Override
	public List<String> getRoleFunctionCodeList(List<UserRole> roles){
		String query = "SELECT DISTINCT functioncode FROM `functioncodes` AS fc LEFT JOIN `rolefunctioncodes` rfc ON fc.`componentId` = rfc.`funcid` WHERE ";
		System.out.println("Role Array Size " + roles.size());
		for (int i = 0; i < roles.size();i++) {
			if (i == 0) {
				query += "rfc.`roleid` = "+ roles.get(i).getRoleid();
			}else {
				query += " OR rfc.`roleid` = "+ roles.get(i).getRoleid();
			}
			query += " ;";
		}
		System.out.println(query);
		return getJdbcTemplate().queryForList(query, String.class);
	}
	
	@Override
	public List<FunctionCodes> getNavBarItems(List<UserRole> roles){
		String query = "SELECT DISTINCT functioncode, fc.componentId, displayname, fc.createdate, ismenubar FROM `functioncodes` AS fc LEFT JOIN `rolefunctioncodes` rfc ON fc.`componentId` = rfc.`funcid` WHERE ";
		System.out.println("Role Array Size " + roles.size());
		for (int i = 0; i < roles.size();i++) {
			if (i == 0) {
				query += "rfc.`roleid` = "+ roles.get(i).getRoleid();
			}else {
				query += " OR rfc.`roleid` = "+ roles.get(i).getRoleid();
			}
			query += " AND fc.ismenubar = b'1'  ;";
		}
		System.out.println(query);
		return getJdbcTemplate().query(query, new FunctionCodeRowMapper());
	}



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
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<RoleFunctionCodes> findAll() {
		return rfcdao.findAll();
	}
	
	
	
	
}
