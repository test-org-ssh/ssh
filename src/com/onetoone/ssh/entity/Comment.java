package com.onetoone.ssh.entity;

import java.io.Serializable;

public class Comment implements Serializable{
	private int id;//���۵�id
	/*private int postId;//�������ж�Ӧ������id
	private int userId;//���۵��û���id*/
	private String content;//���۵�����
	
	private PostTie postTie;//ӳ��һ�Զ�Ĺ�ϵ
	private User user;//ӳ��һ�Զ�Ĺ�ϵ  
	
	
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
	/*public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}*/
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
