package com.onetoone.ssh.entity;

import java.util.HashSet;
import java.util.Set;

import com.onetoone.ssh.entity.Score;

public class FilmIntroduction {

	private int id;//Ӱ��id
	private String name;//Ӱ������
	private String picPath;//ͼƬ��ַ
	private String description;//��Ӱ�ӵ�����
	private float score;//��Ӱ�ӵ����� �����ֱ��е�ƽ����
	
	private Set<Score> scoreSet = new HashSet<>(); //ʵ��һ�Զ�
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
