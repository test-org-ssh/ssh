package com.onetoone.ssh.entity;

import java.io.Serializable;

/**
 * 关注表信息类
 * @author wanghaixue
 *
 */
public class Follow implements Serializable{
	private int id;		// 关注
	private User follow;	// 关注者
	private User followed;	// 被关注者
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
