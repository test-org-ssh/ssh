package com.onetoone.ssh.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	public String getexecute(){
		System.out.println("����������");
		return "getsuccess";
	}
	
	public String postexecute(){
		return "postsuccess";
	}
}
