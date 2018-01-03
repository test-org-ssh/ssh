package com.onetoone.ssh.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


//测试 需要外键
public class PostTie implements Serializable{
	private int id;//发帖id
	private int userId;//发帖人id
	private String title;//标题
	private String topic;//话题
	private String content;//内容 
	private String picPath;//图片地址
	private int agreeNum;//点赞数
	private int commentNum;//评论条数
	
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public int getAgreeNum() {
		return agreeNum;
	}
	public void setAgreeNum(int agreeNum) {
		this.agreeNum = agreeNum;
	}
	
}
