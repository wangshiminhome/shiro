package com.wsm.biz;

import java.util.Set;

import com.wsm.po.User;

public interface IUserBiz {
	public User findByName(String username);
	/*public User getByUserName(String username);
	public Set<String> getRoles(String username);
	public Set<String> getPermissions(String username);*/
}
