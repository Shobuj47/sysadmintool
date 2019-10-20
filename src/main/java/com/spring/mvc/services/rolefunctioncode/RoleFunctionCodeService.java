package com.spring.mvc.services.rolefunctioncode;

import java.util.List;

import com.spring.mvc.domain.FunctionCodes;
import com.spring.mvc.domain.Role;

public interface RoleFunctionCodeService {
	public List<FunctionCodes> getRoleFunctionCodes(Role role);
}
