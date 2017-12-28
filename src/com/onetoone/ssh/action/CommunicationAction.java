package com.onetoone.ssh.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.service.PostTieManager;
import com.onetoone.ssh.service.UserManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CommunicationAction extends ActionSupport{
	private Map<Integer,PostTie> posttiemap = new HashMap<Integer,PostTie>();
	private Map<Integer,User> usermap = new HashMap<Integer,User>();
	private List<PostTie> posttielist = null;
	private List<User> userlist = null;
	private PostTieManager manager;
	private UserManager usermanager;
	
	public String getexecute() throws Exception {
		ActionContext ac = ActionContext.getContext();
		posttielist = manager.getAllPostTie();
		userlist = usermanager.getAllUser();
		
		System.out.println("daxiao"+posttielist.size());
		for (PostTie posttie:posttielist){
			posttiemap.put(posttie.getId(), posttie);
			ac.getSession().put("posttiemap",posttiemap);
			System.out.println(posttielist.get(0).getTitle());	
		}
		for (User user:userlist){
			usermap.put(user.getId(), user);
			ac.getSession().put("usermap", usermap);
		}
		
		return SUCCESS;
	}

	// getter & setter method
	public PostTieManager getManager() {
		return manager;
	}
	public void setManager(PostTieManager manager) {
		this.manager = manager;
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

	public UserManager getUsermanager() {
		return usermanager;
	}

	public void setUsermanager(UserManager usermanager) {
		this.usermanager = usermanager;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
}
