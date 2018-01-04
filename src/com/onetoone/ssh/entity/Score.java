package com.onetoone.ssh.entity;

import java.io.Serializable;

public class Score implements Serializable{
	private int id;//评分id
	/*private int filmId;//影视id*/
	private float score;//影视评分
	private User giver; //实现多对一    2017-12-31添加的字段 为了让用户不能重复给一个影视打分
	
	private FilmIntroduction fi;//实现多对一
	public FilmIntroduction getFi() {
		return fi;
	}
	public void setFi(FilmIntroduction fi) {
		this.fi = fi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}*/
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public User getGiver() {
		return giver;
	}
	public void setGiver(User giver) {
		this.giver = giver;
	}
	
}
