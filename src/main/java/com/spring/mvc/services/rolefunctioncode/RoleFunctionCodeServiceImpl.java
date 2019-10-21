package com.spring.mvc.services.rolefunctioncode;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.BaseDAO;
import com.spring.mvc.dao.functioncode.FunctionCodeDAO;
import com.spring.mvc.dao.rolefunctioncode.RoleFunctionCodeDAO;
import com.spring.mvc.domain.FunctionCodes;
import com.spring.mvc.domain.Role;

@Service
public class RoleFunctionCodeServiceImpl extends BaseDAO implements RoleFunctionCodeService{

	@Autowired
	FunctionCodeDAO fcdao;
	
	
	@Override
	public List<FunctionCodes> getRoleFunctionCodes(Role role) {
		List<FunctionCodes> fcl = fcdao.findByProperty("componentid", role.getComponentId());
		return fcl;
	}
	
	
	
	//Return a list of distinct url list from given list of roleid
	@Override
	public List<String> getRoleFunctionCodeList(List<Integer> roleId){
		String query = "SELECT DISTINCT functioncode FROM `functioncodes` AS fc LEFT JOIN `rolefunctioncodes` rfc ON fc.`componentId` = rfc.`funcid` WHERE ";
		int i = 0;
		for (int role : roleId) {
			if (i == 0) {
				query += "rfc.`roleid` = "+ role;
			}else {
				query += " OR rfc.`roleid` = "+ role;
			}
			query += " ;";
		}
		System.out.println(query);
		
		
		
		return null;
	}

}
