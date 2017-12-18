package com.onetoone.ssh.action;

import com.onetoone.ssh.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	private UserManager usermanager;
	@Override
	public String execute() throws Exception {
		System.out.println("开始调用");
		usermanager.saveUser();
		System.out.println("调用结束");
		return SUCCESS;
	}
	public UserManager getUsermanager() {
		return usermanager;
	}
	public void setUsermanager(UserManager usermanager) {
		this.usermanager = usermanager;
	}
	
	
}
