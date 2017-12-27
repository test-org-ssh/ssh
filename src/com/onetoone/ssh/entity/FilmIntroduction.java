package com.onetoone.ssh.entity;

import java.util.HashSet;
import java.util.Set;

import com.onetoone.ssh.entity.Score;

public class FilmIntroduction {

	private int id;//影视id
	private String name;//影视名称
	private String picPath;//图片地址
	private String description;//对影视的描述
	private float score;//对影视的评分 求评分表中的平均分
	
	private Set<Score> scoreSet = new HashSet<>(); //实现一对多
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Set<Score> getScoreSet() {
		return scoreSet;
	}
	public void setScoreSet(Set<Score> scoreSet) {
		this.scoreSet = scoreSet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		picPath = picPath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
}
