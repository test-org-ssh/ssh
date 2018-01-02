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

public class AdminCommentAction extends ActionSupport{
	Map<String,Object> returndata=new HashMap<String,Object>();
	
	//ע��service
	private CommentManager commentmanager;
	
	public Map<String, Object> getReturndata() {
		return returndata;
	}

	public void setReturndata(Map<String, Object> returndata) {
		this.returndata = returndata;
	}

	public CommentManager getCommentmanager() {
		return commentmanager;
	}

	public void setCommentmanager(CommentManager commentmanager) {
		this.commentmanager = commentmanager;
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

	public String getCommentByPage(){
		String msg = "";
		Boolean flag = true;
		System.out.println("��ǰҳ"+currPage);
		PageBean<Comment> pageBean = commentmanager.getCommentByPage(currPage,pageSize);
		
		if(pageBean.getTotalCount() == 0){
			msg="��ѯ����ʧ�ܣ�";
			flag = false;
		}
		//System.out.println("comment��ҳ��ѯ��");
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
	
	//Comment������
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	//����id��������
	public String getCommentById(){
		String msg = "";
		Boolean flag = true;
		
		if(id == null){
			msg = "����id����Ϊ�գ�";
			flag = false;
		}
		
		List<Comment> list = commentmanager.getCommentById(id);
		
		if(list.size() == 0){
			msg = "û�д����ۣ�";
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
	public String deleteComment(){
	    Integer result = commentmanager.deleteComment(id);
	    
	    if(result==1) {
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
