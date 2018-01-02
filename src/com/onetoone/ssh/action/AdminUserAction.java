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
	
	//ע��service
	private UserManager usermanager;
	
	public UserManager getUsermanager() {
		return usermanager;
	}

	public void setUsermanager(UserManager usermanager) {
		this.usermanager = usermanager;
	}

	
	//��ҳ��ѯ
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
			msg="��ѯ�û�ʧ�ܣ�";
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
	
	
	//user������
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
	
	//����id�����û�
	public String getUserById(){
		String msg = "";
		Boolean flag = true;
		
		if(id == null){
			msg = "�û�id����Ϊ�գ�";
			flag = false;
		}
		
		List<User> list = usermanager.getUserById(id);
		
		if(list.size() == 0){
			msg = "û�д��û���";
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
	
	
	
	//��ӡ��޸�
	public String souUser(){
		String msg = "";
		Boolean flag = true;
		String temp1 = "";
		
		int count = 0;
		
		if(id == null){
			count = usermanager.addUser(username,photo,jianjie);
			temp1 = "����û�";
		}else{
			count = usermanager.updateUserById(id,username,photo,jianjie);
			temp1 = "�޸��û�";
		}
		
		if(count == 1){
			msg = temp1 + "�ɹ���";
			flag = true;
		}else{
			msg = temp1 + "ʧ�ܣ�";
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

	
	
	//�޸��û�״̬
	public String updateUserStatus(){
		String msg = "";
		Boolean flag = true;
		
		int count = 0;
		
		if(id == null){
			msg = "id����Ϊ�գ�";
		}else{
			count = usermanager.updateUserStatus(id,status);
		}
		
		if(count == 1){
			msg = "�޸��û�״̬�ɹ���";
			flag = true;
		}else{
			msg = "�޸��û�״̬ʧ�ܣ�";
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
