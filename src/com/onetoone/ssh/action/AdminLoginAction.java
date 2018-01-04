package com.onetoone.ssh.action;

import java.util.HashMap;
import java.util.Map;

import com.onetoone.ssh.entity.Admin;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.form.AdminForm;
import com.onetoone.ssh.form.UserForm;
import com.onetoone.ssh.service.AdminManager;
import com.onetoone.ssh.service.UserManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport{
	Map<String,Object> returndata=new HashMap<String,Object>();
	private AdminManager adminmanager;
	private String username;
	private String password;
	private AdminForm userform=new AdminForm();
	
	public AdminForm getUserform() {
		return userform;
	}

	public String login(){
		System.out.println("请求到这里啦admin");
		return "success";
	}
	
	public String testadminlogin(){
		System.out.println("不知道");
		System.out.println("username="+username);
		/*Admin admin = adminmanager.getMySelf("admin");
		if (admin != null){
			System.out.println("登录成功");
			ActionContext ac = ActionContext.getContext();
			ac.getSession().put("admin",admin);
	
		} else {
	
			return ERROR;
		}*/
        
		return "lll";
	}
	
	public String checkPwd(){
		System.out.println("进入了checkPwd--admin");
		userform.setUsername(username);
		userform.setPassword(password);
		System.out.println();
		System.out.println(username);
		System.out.println(password);
		int res = adminmanager.checkPwd(userform);
		
		System.out.println("res---admin"+res);
		
		returndata.put("status",res);  
		returndata.put("success", true);
        
		return SUCCESS;
	}
	public Map<String, Object> getReturndata() {
		return returndata;
	}

	public void setReturndata(Map<String, Object> returndata) {
		this.returndata = returndata;
	}


	public AdminManager getAdminmanager() {
		return adminmanager;
	}

	public void setAdminmanager(AdminManager adminmanager) {
		this.adminmanager = adminmanager;
	}

	public void setUserform(AdminForm userform) {
		this.userform = userform;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
