package com.onetoone.ssh.action;

import com.onetoone.ssh.form.UserForm;
import com.onetoone.ssh.util.MD5Util;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
	private UserForm userform;
	
	public String getexecute(){
		System.out.println("����������_ע��ҳ");
		return "getsuccess";
	}
	
	public String postexecute(){
		System.out.println("�û���"+userform.getUsername());
		System.out.println("����"+userform.getPassword());
		try {
			System.out.println("ȷ������"+MD5Util.md5Encode(userform.getConfirm()));
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
