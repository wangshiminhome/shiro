package com.wsm.biz;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wsm.dao.IUserDAO;
import com.wsm.po.User;
@Service(value="userbiz")
public class UserBiz implements IUserBiz{
	@Resource
	private IUserDAO userdao;
	public User findByName(String username){
		return userdao.findByName(username);
	}
	/*public User getByUserName(String username){
		return userdao.getUserName(username);
	}
	public Set<String> getRoles(String username){
		return userdao.getRoles(username);
	}
	public Set<String> getPermissions(String username){
		return userdao.getPermissions(username);
	}*/
}
