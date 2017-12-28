package com.onetoone.ssh.action;

import java.util.HashMap;
import java.util.Map;

import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.form.UserForm;
import com.onetoone.ssh.service.UserManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	Map<String,Object> returndata=new HashMap<String,Object>();
	private UserManager usermanager;
	private String username;
	private String password;
	private UserForm userform;
	
	public String getexecute(){
		System.out.println("请求到这里啦");
		return "success";
	}
	
	public String postexecute(){
System.out.println("username="+username);
		User user = usermanager.checkPwd(userform);
		int res = 0;
		
		if (user != null){
			System.out.println("登录成功");
			ActionContext ac = ActionContext.getContext();
			ac.getSession().put("myself",user);
			System.out.println("User的信息"+user.getUsername()+user.getPassword());
			res = 1;
		} else {
			return ERROR;
		}
		
		returndata.put("status",res);  
		returndata.put("success", true);
        
		return "loginsuccess";
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserForm getUserform() {
		return userform;
	}

	public void setUserform(UserForm userform) {
		this.userform = userform;
	}
	
	
}
