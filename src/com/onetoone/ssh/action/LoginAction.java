package com.onetoone.ssh.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	public String getexecute(){
		System.out.println("请求到这里啦");
		return "success";
	}
	
	public String postexecute(){
		return "success";
	}
}
