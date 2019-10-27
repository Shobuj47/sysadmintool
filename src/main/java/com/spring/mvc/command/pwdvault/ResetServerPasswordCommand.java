package com.spring.mvc.command.pwdvault;

public class ResetServerPasswordCommand {
	private int serverId;
	private String username;
    private String password;
    
    
    
    
	public int getServerId() {
		return serverId;
	}
	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}  
    
    
    
    
}
