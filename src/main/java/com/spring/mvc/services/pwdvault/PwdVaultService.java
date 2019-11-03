package com.spring.mvc.services.pwdvault;

import java.util.List;

import com.spring.mvc.domain.Pwdvault;

public interface PwdVaultService {
	public void save(Pwdvault pwdvault);
	public void update(Pwdvault pwdvault);
	public void delete(Integer pwdvaultId);
	public Pwdvault findById(Integer id);
	public List<Pwdvault> findByProperty(String searchobj, Object searchparam);
	public List<Pwdvault> findAll();
	public String unlockPassword(Integer serverId, String usr);
	public List<Pwdvault> getUserPAMServer(Integer userid);
	public String resetPassword(Integer serverId, String usr, String newpassword);
}
