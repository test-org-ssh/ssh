package com.onetoone.ssh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.onetoone.ssh.service.CommentManager;
import com.onetoone.ssh.entity.Comment;
import com.onetoone.ssh.entity.Reply;
import com.onetoone.ssh.service.ReplyManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NoteDetailAction extends ActionSupport {
	private int tieid; //������������id
	

	Map<String,Object> returndata=new HashMap<String,Object>();//���ظ�ҳ���json
	private CommentManager commentmanager;
	private ReplyManager replymanager;
	
	public String execute() {
		System.out.println("�����������󵽴�action");
		return "success";
	}
	//����getNoteDetail
	public String getNoteDetailexecute() {
		ActionContext ac = ActionContext.getContext();
		System.out.println(tieid);
		List<Comment> commentlist = commentmanager.getAllComment(tieid);
		List<Reply> replylist = replymanager.getALLReply(tieid);
		ac.getSession().put("commentlist",commentlist);
		ac.getSession().put("replylist",replylist); //����session����
		return "success";
	}
	
	public CommentManager getCommentmanager() {
		return commentmanager;
	}
	public void setCommentmanager(CommentManager commentmanager) {
		this.commentmanager = commentmanager;
	}
	public ReplyManager getReplymanager() {
		return replymanager;
	}
	public void setReplymanager(ReplyManager replymanager) {
		this.replymanager = replymanager;
	}
	
	
	public Map<String, Object> getReturndata() {
		return returndata;
	}

	public void setReturndata(Map<String, Object> returndata) {
		this.returndata = returndata;
	}
	
	public int getTieid() {
		return tieid;
	}
	public void setTieid(int tieid) {
		this.tieid = tieid;
	}

	
}
