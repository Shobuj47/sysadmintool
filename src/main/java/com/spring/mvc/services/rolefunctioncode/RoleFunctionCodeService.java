package com.spring.mvc.services.rolefunctioncode;

import java.util.List;

import com.spring.mvc.domain.FunctionCodes;
import com.spring.mvc.domain.Role;
import com.spring.mvc.domain.RoleFunctionCodes;
import com.spring.mvc.domain.UserRole;

public interface RoleFunctionCodeService {
	public List<FunctionCodes> getRoleFunctionCodes(Role role);
	public List<String> getRoleFunctionCodeList(List<UserRole> roles);
	public List<FunctionCodes> getNavBarItems(List<UserRole> roles);
	
	public void save(RoleFunctionCodes rfc);
	public void update(RoleFunctionCodes rfc);
	public void delete(RoleFunctionCodes rfc);
	public List<RoleFunctionCodes> findByProperty(String searchobj, Object searchparam);
	public List<RoleFunctionCodes> findAll();
}
