package com.wsm.po;

import java.util.HashSet;
import java.util.Set;

public class Permission {
	private Integer perid;
	private String pername;
	/*private Set<Role> roles=new HashSet<Role>();
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}*/
	public Integer getPerid() {
		return perid;
	}
	public void setPerid(Integer perid) {
		this.perid = perid;
	}
	public String getPername() {
		return pername;
	}
	public void setPername(String pername) {
		this.pername = pername;
	}
	
}
