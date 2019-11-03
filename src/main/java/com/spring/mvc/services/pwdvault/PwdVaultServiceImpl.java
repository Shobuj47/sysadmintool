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
	@Autowired
	PwdvaultDAO pwdvaultdao;
	@Autowired
	PamService pamsrv;
	
	
	@Override
	public List<Pwdvault> getUserPAMServer(Integer userid) {
		List<Integer> pwdvaultservers = pwdvaultusersrv.getPwdVaultList(userid);
		String sql = "SELECT 	componentId, displayname, serveraddr, port, username, password, createdate, updatedate, updatedby FROM sysadmintool.pwdvault where ";
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
	public String resetPassword(Integer serverId, String usr, String newpassword) {
		System.out.println(serverId + " " + usr + " " + newpassword);
		Pwdvault pwd = pwdvaultdao.findById(serverId);
		int port = 22;
		System.out.println(pwd.getServeraddr() + " Port: " +  pwd.getPort() + " username " + pwd.getUsername() +" Password "+ pwd.getPassword() + " resetuser " + usr+ " resetpass" +newpassword);
		String changeResult = pamsrv.changePassword(pwd.getServeraddr(), port, pwd.getUsername(), pwd.getPassword(), usr, newpassword);
		System.out.println(changeResult);
		return changeResult;
	}

	@Override
	public String unlockPassword(Integer serverId, String usr) {
		System.out.println(serverId + " " + usr );
		Pwdvault pwd = pwdvaultdao.findById(serverId);
		System.out.println(pwd.getServeraddr() + " Port: " +  pwd.getPort() + " username " + pwd.getUsername() +" Password "+ pwd.getPassword() + " resetuser " + usr+ " resetpass");
		String changeResult = pamsrv.unlockUser(pwd.getServeraddr(), pwd.getPort() , pwd.getUsername(), pwd.getPassword(), usr);
		System.out.println(changeResult);
		return changeResult;
	}
	
	
	
	@Override
	public void save(Pwdvault pwdvault) {
		pwdvaultdao.save(pwdvault);
	}

	@Override
	public void update(Pwdvault pwdvault) {
		pwdvaultdao.update(pwdvault);
	}

	@Override
	public void delete(Integer pwdvaultId) {
		pwdvaultdao.delete(pwdvaultId);
	}

	@Override
	public Pwdvault findById(Integer id) {
		return pwdvaultdao.findById(id);
	}

	@Override
	public List<Pwdvault> findByProperty(String searchobj, Object searchparam) {
		return pwdvaultdao.findByProperty(searchobj, searchparam);
	}

	@Override
	public List<Pwdvault> findAll() {
		return pwdvaultdao.findAll();
	}
	
	

}
