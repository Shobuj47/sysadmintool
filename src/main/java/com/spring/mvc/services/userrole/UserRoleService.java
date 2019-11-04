package com.spring.mvc.services.userrole;

import java.util.List;

import com.spring.mvc.domain.Role;
import com.spring.mvc.domain.User;
import com.spring.mvc.domain.UserRole;

public interface UserRoleService {
	public List<UserRole> getUserRole(User user);
	public List<UserRole> getUserRoleIdList(Integer id);
	public Boolean validateAccess(List<String> urllist, String accessurl);
	public List<Role> getUserRole(Integer userid);
	public List<Role> getUserRoles(Integer userid);
}
