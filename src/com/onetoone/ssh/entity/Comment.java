package com.onetoone.ssh.entity;

import java.io.Serializable;

public class Comment implements Serializable{
	private int id;//评论的id
	/*private int postId;//发帖表中对应的帖子id
	private int userId;//评论的用户的id*/
	private String content;//评论的内容
	
	private PostTie postTie;//映射一对多的关系
	private User user;//映射一对多的关系  
	
	
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
