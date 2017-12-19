package com.onetoone.ssh.action;



import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.onetoone.ssh.form.UserForm;
import com.onetoone.ssh.util.MD5Util;
import com.opensymphony.xwork2.ActionSupport;


public class RegisterAction extends ActionSupport{
	private String username;
	private String returndata;
	private UserForm userform;
	
	public String getexecute(){
		System.out.println("请求到这里啦_注册页");
		return "success";
	}
	
	public String postexecute(){
		System.out.println("用户名"+userform.getUsername());
		System.out.println("密码"+userform.getPassword());
		try {
			System.out.println("确认密码"+MD5Util.md5Encode(userform.getConfirm()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String checkName(){
		System.out.println("username="+username);
		Map<String,Object> map=new HashMap<String,Object>();
        map.put("backusername", username+"retun");  
        map.put("success", true);
        
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

	public String getReturndata() {
		return returndata;
	}

	public void setReturndata(String returndata) {
		this.returndata = returndata;
	}
	
	
}
