package com.spring.mvc.services.roles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.BaseDAO;
import com.spring.mvc.dao.role.RoleDAO;
import com.spring.mvc.domain.Role;

@Service
public class RoleServiceImpl extends BaseDAO implements RoleService{

	@Autowired
	RoleDAO roledao;
	
	
	@Override
	public void save(Role role) {
		roledao.save(role);
	}

	@Override
	public void update(Role role) {
		roledao.update(role);
	}

	@Override
	public void delete(Integer roleId) {
		roledao.delete(roleId);
	}

	@Override
	public List<Role> findByProperty(String searchobj, Object searchparam) {
		return roledao.findByProperty(searchobj, searchparam);
	}

	@Override
	public List<Role> findAll() {
		return roledao.findAll();
	}

	@Override
	public Role findById(Integer componentId) {
		System.out.println(" RoleServiceImpl : findById " + componentId);
		return roledao.findById(componentId);
	}

}
