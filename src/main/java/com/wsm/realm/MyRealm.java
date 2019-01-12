package com.wsm.realm;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.wsm.biz.IUserBiz;
import com.wsm.po.Permission;
import com.wsm.po.Role;
import com.wsm.po.User;

public class MyRealm extends AuthorizingRealm {
	@Resource
	private IUserBiz userbiz;
	//获取角色和权限
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username=(String) principals.getPrimaryPrincipal();
		Set<String> roles=new HashSet<String>();
		Set<String> perms=new HashSet<String>();
		//获取用户角色
		for(Role r:userbiz.findByName(username).getRoles()){
			roles.add(r.getRolename());
		}
		//获取角色权限
		for(Role r:userbiz.findByName(username).getRoles()){
			for(Permission p:r.getPerms()){
				perms.add(p.getPername());
			}
		}
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.setRoles(roles);
		info.setStringPermissions(perms);
		return info;
		/*String username=(String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationinfo=new SimpleAuthorizationInfo();
		authorizationinfo.setRoles(userbiz.getRoles(username));
		authorizationinfo.setStringPermissions(userbiz.getPermissions(username));*/
	}
	//获取登录验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username=(String) token.getPrincipal();
		User user=userbiz.findByName(username);
		if(user!=null){
			AuthenticationInfo info=new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),"");
			/*Object principal = user.getUsername();
		    String credentials = user.getPassword();
			String realmName = getName();
			ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername());
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials,credentialsSalt,realmName);*/
			return info;
		}else{	
			return null;
		}
	}

}
