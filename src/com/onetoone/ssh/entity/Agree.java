package com.onetoone.ssh.entity;

public class Agree {

	private int id;//���޵�id
	/*private int giveAgreeId;//���޵��û�id
	private int getAgreeId;//�õ��޵�����id*/
	
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
