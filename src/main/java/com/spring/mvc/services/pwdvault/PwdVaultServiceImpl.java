package com.spring.mvc.services.pwdvault;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.BaseDAO;
import com.spring.mvc.dao.pwdvault.PwdvaultDAO;
import com.spring.mvc.domain.Pwdvault;
import com.spring.mvc.rowmapper.PwdvaultRowMapper;
import com.spring.mvc.services.pam.PamService;
import com.spring.mvc.services.pwdvaultuser.PwdVaultUserService;

@Service
public class PwdVaultServiceImpl  extends BaseDAO implements PwdVaultService{

	@Autowired
	PwdVaultUserService pwdvaultusersrv;
	PwdvaultDAO pwdvaultdao;
	PamService pamsrv;
	
	@Override
	public List<Pwdvault> getUserPAMServer(Integer userid) {
		List<Integer> pwdvaultservers = pwdvaultusersrv.getPwdVaultList(userid);
		String sql = "SELECT 	componentId, displayname, serveraddr, username, password, createdate, updatedate, createdby, updatedby FROM sysadmintool.pwdvault where ";
		int i = 0;
		for (int pwdvaultserver : pwdvaultservers) {
			if (i == 0) {
				sql += " componentId = " + pwdvaultserver;
			} else {
				sql += " OR componentId = " + pwdvaultserver;
			}
			i++;
		}
		List<Pwdvault> pwdvaultlist = getJdbcTemplate().query(sql, new PwdvaultRowMapper());
		return pwdvaultlist;
	}
	
	@Override
	public String resetPassword(int serverId, String usr, String newpassword) {
		Pwdvault pwd;
		pwd = pwdvaultdao.findById(serverId);
		String changeResult = pamsrv.changePassword(pwd.getServeraddr(), 22, pwd.getUsername(), pwd.getPassword(), usr, newpassword);
		System.out.println(changeResult);
		return changeResult;
	}
	
	

}
