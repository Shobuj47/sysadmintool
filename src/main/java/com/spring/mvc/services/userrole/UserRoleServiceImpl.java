package com.spring.mvc.services.userrole;

import java.sql.Array;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.BaseDAO;
import com.spring.mvc.dao.userrole.UserRoleDAO;
import com.spring.mvc.domain.User;
import com.spring.mvc.domain.UserRole;
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
	public List<UserRole> getUserRoleIdList(int userid){
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
	

}
