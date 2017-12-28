package com.onetoone.ssh.action;



import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.form.UserForm;
import com.onetoone.ssh.service.UserManager;
import com.onetoone.ssh.util.MD5Util;
import com.opensymphony.xwork2.ActionSupport;


public class RegisterAction extends ActionSupport{
	Map<String,Object> returndata=new HashMap<String,Object>();
	private UserManager usermanager;
	private String username;
	private UserForm userform;
	
	public String getexecute(){
		return "success";
	}
	
	public String postexecute(){
		System.out.println("qingqiudap");
		User user = new User();
		try {
			// ע��ʱ������Ϣ����Ĭ����Ϣ����ͷ�񡢱���ͼ
			user.setFnum(0);
			user.setJianjie("��Ӱ����һ����������������һ����Ӱ");
			user.setPhoto("/static/img/user1.jpg");
			user.setStatus(1);
			// �����û���������
			user.setUsername(userform.getUsername());
			user.setPassword(MD5Util.md5Encode(userform.getConfirm()));
			usermanager.saveUser(user);
			System.out.println("ע��ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "regsuccess";
	}

	public String checkName(){
		System.out.println("username="+username);
		
		int res = usermanager.checkUsername(username);
		
		returndata.put("status",res);  
		returndata.put("success", true);
        
        return SUCCESS;
	}
	
	public UserForm getUserform() {
		return userform;
	}

	public void setUserform(UserForm userform) {
		this.userform = userform;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public Map<String, Object> getReturndata() {
		return returndata;
	}

	public void setReturndata(Map<String, Object> returndata) {
		this.returndata = returndata;
	}

	public UserManager getUsermanager() {
		return usermanager;
	}

	public void setUsermanager(UserManager usermanager) {
		this.usermanager = usermanager;
	}
	
	
}
