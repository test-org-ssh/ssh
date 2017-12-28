package com.onetoone.ssh.entity;

import java.io.Serializable;

public class Reply implements Serializable{

	private int id;//回复id
	/*private int postId;//帖子id
	private int replyUserId;//回复的用户id
	private int repliedUserId;//被回复的用户id*/
	private String content;//回复的内容
	
	private PostTie postTie;//映射一对多的关系
	private User giveuser;//映射一对多的关系 给予回复的用户id
	private User getuser;//映射一对多关系 被回复的用户id
	
	public PostTie getPostTie() {
		return postTie;
	}
	public void setPostTie(PostTie postTie) {
		this.postTie = postTie;
	}
	
	public User getGiveuser() {
		return giveuser;
	}
	public void setGiveuser(User giveuser) {
		this.giveuser = giveuser;
	}
	public User getGetuser() {
		return getuser;
	}
	public void setGetuser(User getuser) {
		this.getuser = getuser;
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
	public int getReplyUserId() {
		return replyUserId;
	}
	public void setReplyUserId(int replyUserId) {
		this.replyUserId = replyUserId;
	}
	public int getRepliedUserId() {
		return repliedUserId;
	}
	public void setRepliedUserId(int repliedUserId) {
		this.repliedUserId = repliedUserId;
	}*/
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
