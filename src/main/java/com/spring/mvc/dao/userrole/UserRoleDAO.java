package com.spring.mvc.dao.userrole;

import java.util.List;

import com.spring.mvc.domain.UserRole;

public interface UserRoleDAO {
	public void save(UserRole userrole);
	public void update(UserRole userrole);
	public void delete(UserRole userrole);
	public List<UserRole> findByProperty(String searchobj, Object searchparam);
	public List<UserRole> findAll();
}
