package com.onetoone.ssh.entity;

public class Agree {

	private int id;//点赞的id
	/*private int giveAgreeId;//点赞的用户id
	private int getAgreeId;//得到赞的贴的id*/
	
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
	/*public int getGiveAgreeId() {
		return giveAgreeId;
	}
	public void setGiveAgreeId(int giveAgreeId) {
		this.giveAgreeId = giveAgreeId;
	}
	public int getGetAgreeId() {
		return getAgreeId;
	}
	public void setGetAgreeId(int getAgreeId) {
		this.getAgreeId = getAgreeId;
	}*/
	
}
