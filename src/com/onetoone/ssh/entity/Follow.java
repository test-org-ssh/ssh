package com.onetoone.ssh.entity;

import java.io.Serializable;

/**
 * ��ע����Ϣ��
 * @author wanghaixue
 *
 */
public class Follow implements Serializable{
	private int id;		// ��ע
	private User follow;	// ��ע��
	private User followed;	// ����ע��
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getFollow() {
		return follow;
	}
	public void setFollow(User follow) {
		this.follow = follow;
	}
	public User getFollowed() {
		return followed;
	}
	public void setFollowed(User followed) {
		this.followed = followed;
	}
	
	
}
