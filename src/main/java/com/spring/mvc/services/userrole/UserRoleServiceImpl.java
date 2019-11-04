package com.spring.mvc.services.userrole;

import java.sql.Array;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.BaseDAO;
import com.spring.mvc.dao.userrole.UserRoleDAO;
import com.spring.mvc.domain.Role;
import com.spring.mvc.domain.User;
import com.spring.mvc.domain.UserRole;
import com.spring.mvc.rowmapper.RoleRowMapper;
import com.spring.mvc.rowmapper.UserRoleRowMapper;


@Service
public class UserRoleServiceImpl extends BaseDAO  implements UserRoleService{

	@Autowired
	private UserRoleDAO usrroledao;
	
	@Override
	public List<UserRole> getUserRole(User user) {
		try {
		List<UserRole> usrrolel = usrroledao.findByProperty("userid", user.getComponentId());
		return usrrolel;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<UserRole> getUserRoleIdList(Integer userid){
		String sql = "SELECT 	DISTINCT roleid, componentId, userid, STATUS, createdate, updatedate FROM userrole WHERE userid = " + userid + " ORDER BY roleid ";
		System.out.println("Query for getting user role     "+sql);
		return getJdbcTemplate().query(sql, new UserRoleRowMapper());
	}
	
	
	public Boolean validateAccess(List<String> urllist, String accessurl) {
		Boolean validation = false;
		for (String url : urllist) {
			if(url.equalsIgnoreCase(accessurl)) {
				validation = true;
				break;
			}
		}
		return validation;
	}

	//Return a list of roles asociated with the given userid
	@Override
	public List<Role> getUserRoles(Integer userid) {
		String sql = "SELECT DISTINCT roles.componentId,  roles.rolename,  roles.displayname,  roles.status FROM role AS roles LEFT JOIN userrole usrr ON roles.`componentId` = usrr.`roleid` WHERE ";
		if(userid != null) {
			sql += "usrr.userid = ?";
			return  getJdbcTemplate().query(sql, new RoleRowMapper(), userid) ;
		}
		return null;
	}

	@Override
	public List<Role> getUserRole(Integer userid) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
