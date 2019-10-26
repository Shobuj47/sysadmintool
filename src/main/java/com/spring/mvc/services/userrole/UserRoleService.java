package com.spring.mvc.services.userrole;

import java.util.List;

import com.spring.mvc.domain.User;
import com.spring.mvc.domain.UserRole;

public interface UserRoleService {
	public List<UserRole> getUserRole(User user);
	public List<UserRole> getUserRoleIdList(int id);
	public Boolean validateAccess(List<String> urllist, String accessurl);
}
