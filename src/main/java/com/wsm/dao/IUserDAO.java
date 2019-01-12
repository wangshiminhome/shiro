package com.wsm.dao;

import java.util.Set;

import com.wsm.po.User;

public interface IUserDAO {
	public User findByName(String username);
	/*public User getUserName(String username);
	public Set<String> getRoles(String username);
	public Set<String> getPermissions(String username);*/
}
