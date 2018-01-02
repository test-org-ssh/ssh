package com.onetoone.ssh.action;

import java.util.List;

import com.onetoone.ssh.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.ActionContext;
import com.onetoone.ssh.dao.*;
import com.onetoone.ssh.entity.*;
import com.onetoone.ssh.service.*;
import com.onetoone.ssh.serviceImpl.*;
import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.PRIVATE_MEMBER;

                                                 
public class AdminUserAction extends ActionSupport{
	Map<String,Object> returndata=new HashMap<String,Object>();
	
	//注入service
	private UserManager usermanager;
	
	public UserManager getUsermanager() {
		return usermanager;
	}

	public void setUsermanager(UserManager usermanager) {
		this.usermanager = usermanager;
	}

	
	//分页查询
	private Integer currPage = 1;
	private Integer pageSize = 5;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getUserByPage(){
		PageBean<User> pageBean = usermanager.getUserInfoByPage(currPage,pageSize);
		System.out.println("返回user的总条数"+pageBean.getTotalCount());
		System.out.println("返回user"+pageBean.getList());
		System.out.println("返回user的总页数"+pageBean.getTotalPage());
		returndata.put("data",pageBean);  
		returndata.put("status",0);
		returndata.put("success", true);
		System.out.println(returndata);
		return SUCCESS;
	}

	public Map<String, Object> getReturndata() {
		return returndata;
	}

	public void setReturndata(Map<String, Object> returndata) {
		this.returndata = returndata;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

}
