package com.onetoone.ssh.entity;

import java.io.Serializable;

public class User implements Serializable{
	private int id;	//	�û�ID
	private String username;	// �û��ǳ�
	private String password;	//�û�����
	private String photo;	//�û�ͷ��
	private String jianjie;	//�û����
	private String bgimg;	//�û�����ͼƬ
	private int fnum;	//�û���˿��
	private int status;	// 0:�˺Ŷ���	1:�˺ſ���
	
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
