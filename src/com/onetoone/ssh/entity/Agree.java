package com.onetoone.ssh.entity;

import java.io.Serializable;

public class Agree implements Serializable{
	private int id;//���޵�id
	private PostTie postTie;//ӳ��һ�Զ�Ĺ�ϵ  postTieid
	private User user;//ӳ��һ�Զ�Ĺ�ϵ   userid
	
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
