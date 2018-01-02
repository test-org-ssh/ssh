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
	
	public Integer getCurrPage() {
		return currPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public String getUserByPage(){
		String msg = "";
		Boolean flag = true;
		
		PageBean<User> pageBean = usermanager.getUserByPage(currPage,pageSize);
		
		if(pageBean.getTotalCount() == 0){
			msg="查询用户失败！";
			flag = false;
		}
		if(flag == true){
			returndata.put("data",pageBean);  
			returndata.put("status",0);
			returndata.put("success", true);
		}else{
			returndata.put("msg", msg);
			returndata.put("success", false);
		}
		return SUCCESS;
	}
	
	
	//user的属性
	private Integer id;
	private String username;
	private String photo;	
	private String jianjie;	
	private Integer status;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getJianjie() {
		return jianjie;
	}

	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	//根据id查找用户
	public String getUserById(){
		String msg = "";
		Boolean flag = true;
		
		if(id == null){
			msg = "用户id不能为空！";
			flag = false;
		}
		
		List<User> list = usermanager.getUserById(id);
		
		if(list.size() == 0){
			msg = "没有此用户！";
			flag = false;
		}
		
		if(flag == true){
			returndata.put("data",list);
			returndata.put("success", true);
		}else{
			returndata.put("msg", msg);
			returndata.put("success", false);
		}
		
		return SUCCESS;
	}
	
	
	
	//添加、修改
	public String souUser(){
		String msg = "";
		Boolean flag = true;
		String temp1 = "";
		
		int count = 0;
		
		if(id == null){
			count = usermanager.addUser(username,photo,jianjie);
			temp1 = "添加用户";
		}else{
			count = usermanager.updateUserById(id,username,photo,jianjie);
			temp1 = "修改用户";
		}
		
		if(count == 1){
			msg = temp1 + "成功！";
			flag = true;
		}else{
			msg = temp1 + "失败！";
			flag = false;
		}
		
		if(flag == true){
			returndata.put("msg", msg);
			returndata.put("success", true);
		}else{
			returndata.put("msg", msg);
			returndata.put("success", false);
		}
		return SUCCESS;
	}

	
	
	//修改用户状态
	public String updateUserStatus(){
		String msg = "";
		Boolean flag = true;
		
		int count = 0;
		
		if(id == null){
			msg = "id不能为空！";
		}else{
			count = usermanager.updateUserStatus(id,status);
		}
		
		if(count == 1){
			msg = "修改用户状态成功！";
			flag = true;
		}else{
			msg = "修改用户状态失败！";
			flag = false;
		}
		
		if(flag == true){
			returndata.put("msg", msg);
			returndata.put("success", true);
		}else{
			returndata.put("msg", msg);
			returndata.put("success", false);
		}
		return SUCCESS;
	}
	
	
	public Map<String, Object> getReturndata() {
		return returndata;
	}

	public void setReturndata(Map<String, Object> returndata) {
		this.returndata = returndata;
	}

}
