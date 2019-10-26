package com.spring.mvc.command.common;

import java.util.List;

public class LoginCommand {
	private String loginName;
    private String password;    
    private List<String> AccessableUrl;
    
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public List<String> getAccessableUrl() {
		return AccessableUrl;
	}
    
	public void setAccessableUrl(List<String> urllist) {
		this.AccessableUrl = urllist;
	}
    
}
