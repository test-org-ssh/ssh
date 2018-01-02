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
	
	//注入service
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

	//分页查询
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
		System.out.println("当前页"+currPage);
		PageBean<Comment> pageBean = commentmanager.getCommentByPage(currPage,pageSize);
		
		if(pageBean.getTotalCount() == 0){
			msg="查询评论失败！";
			flag = false;
		}
		//System.out.println("comment分页查询后");
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
	
	//Comment的属性
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	//根据id查找评论
	public String getCommentById(){
		String msg = "";
		Boolean flag = true;
		
		if(id == null){
			msg = "评论id不能为空！";
			flag = false;
		}
		
		List<Comment> list = commentmanager.getCommentById(id);
		
		if(list.size() == 0){
			msg = "没有此评论！";
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

	
	//删除用户
	public String deleteComment(){
	    Integer result = commentmanager.deleteComment(id);
	    
	    if(result==1) {
	    	returndata.put("msg","删除成功");  
			returndata.put("status",result);
			returndata.put("success", true);
	    } else {
	    	returndata.put("msg","删除失败");  
			returndata.put("status",result);
			returndata.put("success", false);
	    }
	    
	    return SUCCESS;
	}
	
}
