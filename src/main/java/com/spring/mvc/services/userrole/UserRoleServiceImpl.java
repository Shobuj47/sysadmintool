package com.spring.mvc.services.userrole;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.BaseDAO;
import com.spring.mvc.dao.userrole.UserRoleDAO;
import com.spring.mvc.domain.User;
import com.spring.mvc.domain.UserRole;


@Service
public class UserRoleServiceImpl extends BaseDAO  implements UserRoleService{

	@Autowired
	UserRoleDAO usrroledao;
	
	@Override
	public List<UserRole> getUserRole(User user) {
		List<UserRole> usrrolel = usrroledao.findByProperty("userid", user.getComponentId());
		return usrrolel;
	}

}
