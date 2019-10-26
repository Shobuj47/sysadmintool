package com.spring.mvc.services.rolefunctioncode;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.mvc.dao.BaseDAO;
import com.spring.mvc.dao.functioncode.FunctionCodeDAO;
import com.spring.mvc.domain.FunctionCodes;
import com.spring.mvc.domain.Role;
import com.spring.mvc.domain.UserRole;
import com.spring.mvc.services.userrole.UserRoleService;

@Service
public class RoleFunctionCodeServiceImpl extends BaseDAO implements RoleFunctionCodeService{

	@Autowired
	FunctionCodeDAO fcdao;
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
		int i = 0;
		System.out.println("Role Array Size " + roles.size());
		for (i = 0; i < roles.size();i++) {
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
	
	
}
