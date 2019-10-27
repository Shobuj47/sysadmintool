package com.spring.mvc.services.pam;

public interface PamService {

	public String changePassword(String host, Integer port, String sudouser, String password, String user, String newpasswd);
	
	
	
}
