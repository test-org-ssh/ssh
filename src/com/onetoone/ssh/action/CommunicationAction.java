package com.onetoone.ssh.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.service.PostTieManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CommunicationAction extends ActionSupport{
	private Map<Integer,PostTie> posttiemap = new HashMap<Integer,PostTie>();
	private List<PostTie> posttielist = null;
	private PostTieManager manager;
	
	public String getexecute() throws Exception {
		posttielist = manager.getAllPostTie();
		System.out.println("daxiao"+posttielist.size());
		for (PostTie posttie:posttielist){
			posttiemap.put(posttie.getId(), posttie);
			ActionContext ac = ActionContext.getContext();
			ac.getSession().put("posttiemap",posttiemap);
			System.out.println(posttielist.get(0).getTitle());
			
			
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
}
