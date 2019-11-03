package com.spring.mvc.services.pam;

public interface PamService {

	public String changePassword(String host, int port, String sudouser, String password, String user, String newpasswd);
	public String unlockUser(String host, int port, String sudouser, String password, String user);
	public String executeCommand(String host, int port, String sudouser, String password, String cmd);
	
}
