package com.spring.mvc.domain;

import java.util.Date;

public class RoleFunctionCodes {
	private int componentId;
	private int roleid;
	private int funcid;
	private Date createdate;
	private int createdby;
	private int updatedby;
	public int getComponentId() {
		return componentId;
	}
	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public int getFuncid() {
		return funcid;
	}
	public void setFuncid(int funcid) {
		this.funcid = funcid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public int getCreatedby() {
		return createdby;
	}
	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}
	public int getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(int updatedby) {
		this.updatedby = updatedby;
	}

	
	
}
