package com.onetoone.ssh.action;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.service.PostTieManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 发帖 Action
 * @author wanghaixue
 *
 */
public class SendNoteAction extends ActionSupport{
	private Map<Integer,PostTie> posttiemap = new HashMap<Integer,PostTie>();
	private List<PostTie> posttielist = null;
	private List<PostTie> posttielist2 = null;
	private PostTieManager ptiemanager;
	private PostTie postTie;
	
	public String getsendnote(){
		return SUCCESS;
	}
	
	public String postsendnote(){
		PostTie ptie = new PostTie();
		ptie.setAgreeNum(0);
		ptie.setCommentNum(0);
		ptie.setContent(postTie.getContent());
		ptie.setPicPath("moren");
		ptie.setTitle(postTie.getTitle());
		ptie.setTopic(postTie.getTopic());
		ptie.setUserId(postTie.getUserId());
		
		ActionContext ac = ActionContext.getContext();
		ptiemanager.savePostTie(ptie);
		posttielist = ptiemanager.getAllPostTie();
		
		System.out.println("daxiao"+posttielist.size());
		ac.getSession().put("posttiemap", posttielist);
		
		System.out.println("帖子保存成功啦");
		return SUCCESS;
	}

	public Map<Integer, PostTie> getPosttiemap() {
		return posttiemap;
	}

	public void setPosttiemap(Map<Integer, PostTie> posttiemap) {
		this.posttiemap = posttiemap;
	}

	public List<PostTie> getPosttielist() {
		return posttielist;
	}

	public void setPosttielist(List<PostTie> posttielist) {
		this.posttielist = posttielist;
	}

	public PostTie getPostTie() {
		return postTie;
	}

	public void setPostTie(PostTie postTie) {
		this.postTie = postTie;
	}

	public PostTieManager getPtiemanager() {
		return ptiemanager;
	}

	public void setPtiemanager(PostTieManager ptiemanager) {
		this.ptiemanager = ptiemanager;
	}
	
}
