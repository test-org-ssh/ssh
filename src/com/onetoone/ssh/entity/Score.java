package com.onetoone.ssh.entity;

import java.io.Serializable;

public class Score implements Serializable{
	private int id;//����id
	/*private int filmId;//Ӱ��id*/
	private float score;//Ӱ������
	private User giver; //ʵ�ֶ��һ    2017-12-31��ӵ��ֶ� Ϊ�����û������ظ���һ��Ӱ�Ӵ��
	
	private FilmIntroduction fi;//ʵ�ֶ��һ
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
