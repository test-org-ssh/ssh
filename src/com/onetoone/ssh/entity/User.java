package com.onetoone.ssh.entity;

import java.io.Serializable;

public class User implements Serializable{
	private int id;	//	用户ID
	private String username;	// 用户昵称
	private String password;	//用户密码
	private String photo;	//用户头像
	private String jianjie;	//用户简介
	private String bgimg;	//用户背景图片
	private int fnum;	//用户粉丝数
	private int status;	// 0:账号冻结	1:账号可用
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getJianjie() {
		return jianjie;
	}
	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}
	public String getBgimg() {
		return bgimg;
	}
	public void setBgimg(String bgimg) {
		this.bgimg = bgimg;
	}
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
