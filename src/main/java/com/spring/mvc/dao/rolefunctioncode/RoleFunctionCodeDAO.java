package com.spring.mvc.dao.rolefunctioncode;

import java.util.List;

import com.spring.mvc.domain.RoleFunctionCodes;

public interface RoleFunctionCodeDAO {
	public void save(RoleFunctionCodes rfc);
	public void update(RoleFunctionCodes rfc);
	public void delete(RoleFunctionCodes rfc);
	public List<RoleFunctionCodes> findByProperty(String searchobj, Object searchparam);
	public List<RoleFunctionCodes> findAll();
}
