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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int roleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Role> findByProperty(String searchobj, Object searchparam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roledao.findAll();
	}

}
