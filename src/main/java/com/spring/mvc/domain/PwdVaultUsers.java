package com.spring.mvc.domain;

public class PwdVaultUsers {
	private Integer componentId; 
	private Integer pwdvaultid;
	private Integer userid; 
	private Byte status;
	
	
	public Integer getComponentId() {
		return componentId;
	}
	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}
	public Integer getPwdvaultid() {
		return pwdvaultid;
	}
	public void setPwdvaultid(Integer pwdvaultid) {
		this.pwdvaultid = pwdvaultid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	
	
	
	
}
