package com.onetoone.ssh.action;

import com.onetoone.ssh.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	private UserManager usermanager;

	public String index() throws Exception {
		System.out.println("��ʼ����");
		System.out.println("���ý���");
		return SUCCESS;
	}
	public UserManager getUsermanager() {
		return usermanager;
		 //
	}
	public void setUsermanager(UserManager usermanager) {
		this.usermanager = usermanager;
	}
	
	
}
