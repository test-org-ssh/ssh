package com.onetoone.ssh.entity;

import java.io.Serializable;

public class Fans implements Serializable{
	private User followed;
	private User follow;
	private int ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public User getFollowed() {
		return followed;
	}
	public void setFollowed(User followed) {
		this.followed = followed;
	}
	public User getFollow() {
		return follow;
	}
	public void setFollow(User follow) {
		this.follow = follow;
	}
	
	
}
