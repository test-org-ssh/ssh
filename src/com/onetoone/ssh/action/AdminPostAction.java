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

public class AdminPostAction extends ActionSupport{
	Map<String,Object> returndata=new HashMap<String,Object>();
	
	//ע��service
	private PostTieManager posttiemanager;

	public PostTieManager getPosttiemanager() {
		return posttiemanager;
	}

	public void setPosttiemanager(PostTieManager posttiemanager) {
		this.posttiemanager = posttiemanager;
	}
	
	public Map<String, Object> getReturndata() {
		return returndata;
	}

	public void setReturndata(Map<String, Object> returndata) {
		this.returndata = returndata;
	}
	
	
	//��ҳ��ѯ
	private Integer currPage;
	private Integer pageSize;
	
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

	public String getPostByPage(){
		String msg = "";
		Boolean flag = true;
		
		PageBean<PostTie> pageBean = posttiemanager.getPostByPage(currPage,pageSize);
		
		if(pageBean.getTotalCount() == 0){
			msg="��ѯ����ʧ�ܣ�";
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
	
	//PostTie������
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	//����id�����û�
	public String getPostById(){
		String msg = "";
		Boolean flag = true;
		
		if(id == null){
			msg = "����id����Ϊ�գ�";
			flag = false;
		}
		
		List<PostTie> list = posttiemanager.getPostById(id);
		
		if(list.size() == 0){
			msg = "û�д����ӣ�";
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

	
	//ɾ���û�
	public String deletePost(){
	    Integer result = posttiemanager.deletePost(id);
	    
	    if(result == 1) {
			returndata.put("msg","ɾ���ɹ�");  
			returndata.put("status",result);
			returndata.put("success", true);
	    } else {
			returndata.put("msg","ɾ��ʧ��");  
			returndata.put("status",result);
			returndata.put("success", false);
	    }
	    
	    return SUCCESS;
	}
	
	
}
