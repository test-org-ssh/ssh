package com.onetoone.ssh.entity;

import java.io.Serializable;

public class Reply implements Serializable{

	private int id;//�ظ�id
	/*private int postId;//����id
	private int replyUserId;//�ظ����û�id
	private int repliedUserId;//���ظ����û�id*/
	private String content;//�ظ�������
	
	private PostTie postTie;//ӳ��һ�Զ�Ĺ�ϵ
	private User giveuser;//ӳ��һ�Զ�Ĺ�ϵ ����ظ����û�id
	private User getuser;//ӳ��һ�Զ��ϵ ���ظ����û�id
	
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
