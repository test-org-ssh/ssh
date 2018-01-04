package com.onetoone.ssh.action;

import java.util.HashMap;
import java.util.Map;

import com.onetoone.ssh.entity.Admin;
import com.onetoone.ssh.service.AdminManager;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport{
	Map<String,Object> returndata=new HashMap<String,Object>();
	private AdminManager adminmanager;
	private String username;
	private String password;
	
	public String adminLogin(){
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		int res = adminmanager.checkPwd(admin);
		if (res == 1){
			returndata.put("result","success");  
		} else {
			returndata.put("result","error"); 
		}
		returndata.put("success", true);
		
		return SUCCESS;
	}

	public AdminManager getAdminmanager() {
		return adminmanager;
	}

	public void setAdminmanager(AdminManager adminmanager) {
		this.adminmanager = adminmanager;
	}
}
