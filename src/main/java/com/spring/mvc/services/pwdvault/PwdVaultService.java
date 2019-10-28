package com.spring.mvc.services.pwdvault;

import java.util.List;

import com.spring.mvc.domain.Pwdvault;

public interface PwdVaultService {

	
	public List<Pwdvault> getUserPAMServer(Integer userid);
	public String resetPassword(int serverId, String usr, String newpassword);
}