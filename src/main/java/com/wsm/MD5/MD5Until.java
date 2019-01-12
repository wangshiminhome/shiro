package com.wsm.MD5;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Until {
	//pwd为密码
	//salt为盐值
	//i为加密次数
	public static String toMd5(String pwd,String salt,int i){
		Md5Hash toMd5 = new Md5Hash(pwd,salt,i);
		return toMd5.toString();
		}
}
