package com.spring.mvc.services.pwdvault;

import java.util.List;

import com.spring.mvc.domain.Pwdvault;

public interface PwdVaultService {
	public void save(Pwdvault pwdvault);
	public void update(Pwdvault pwdvault);
	public void delete(int pwdvaultId);
	public Pwdvault findById(int id);
	public List<Pwdvault> findByProperty(String searchobj, Object searchparam);
	public List<Pwdvault> findAll();
	
	public List<Pwdvault> getUserPAMServer(Integer userid);
	public String resetPassword(int serverId, String usr, String newpassword);
}
