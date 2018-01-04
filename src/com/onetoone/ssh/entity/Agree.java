package com.onetoone.ssh.entity;

import java.io.Serializable;

public class Agree implements Serializable{
	private int id;//点赞的id
	private PostTie postTie;//映射一对多的关系  postTieid
	private User user;//映射一对多的关系   userid
	
	public PostTie getPostTie() {
		return postTie;
	}
	public void setPostTie(PostTie postTie) {
		this.postTie = postTie;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
