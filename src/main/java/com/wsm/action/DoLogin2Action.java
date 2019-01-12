package com.wsm.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoLogin2Action {
	@RequestMapping("/login2.do")
	@RequiresRoles("admin")
	public String login(String username,String userpass){
		System.out.println(username);
		System.out.println(userpass);
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(username,userpass);
		try{
			subject.login(token);
			Session session=subject.getSession();
			session.setAttribute("username",username);
			return "redirect:/success.jsp";
		}catch(AuthenticationException e){
			e.printStackTrace();
			return "redirect:/login.jsp";
		}
	}
	@RequestMapping("/admin.do")
	@RequiresPermissions("user:*")
	public String login3(String username,String userpass){
		System.out.println(username);
		System.out.println(userpass);
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(username,userpass);
		try{
			subject.login(token);
			Session session=subject.getSession();
			session.setAttribute("username",username);
			return "redirect:/success.jsp";
		}catch(AuthenticationException e){
			e.printStackTrace();
			return "redirect:/login.jsp";
		}
	}
}
