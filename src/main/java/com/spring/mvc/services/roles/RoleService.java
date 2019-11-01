package com.spring.mvc.services.roles;

import java.util.List;

import com.spring.mvc.domain.Role;

public interface RoleService {
	public void save(Role role);
	public void update(Role role);
	public void delete(Role roleId);
	public List<Role> findByProperty(String searchobj, Object searchparam);
	public List<Role> findAll();
	public Role findById(Integer componentId);
}
