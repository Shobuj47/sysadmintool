package com.spring.mvc.dao.role;

import java.util.List;

import com.spring.mvc.domain.Role;

public interface RoleDAO {
	public void save(Role role);
	public void update(Role role);
	public void delete(int roleId);
	public List<Role> findByProperty(String searchobj, Object searchparam);
	public List<Role> findAll();
}
