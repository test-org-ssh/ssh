package com.onetoone.ssh.entity;

public class Score {
	private int id;//����id
	/*private int filmId;//Ӱ��id*/
	private float score;//Ӱ������
	
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
	
}
