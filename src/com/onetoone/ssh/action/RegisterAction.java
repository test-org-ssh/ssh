package com.onetoone.ssh.action;

import com.onetoone.ssh.form.UserForm;
import com.onetoone.ssh.util.MD5Util;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
	private UserForm userform;
	
	public String getexecute(){
		System.out.println("请求到这里啦_注册页");
		return "getsuccess";
	}
	
	public String postexecute(){
		System.out.println("用户名"+userform.getUsername());
		System.out.println("密码"+userform.getPassword());
		try {
			System.out.println("确认密码"+MD5Util.md5Encode(userform.getConfirm()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "postsuccess";
	}

	public UserForm getUserform() {
		return userform;
	}

	public void setUserform(UserForm userform) {
		this.userform = userform;
	}
}
