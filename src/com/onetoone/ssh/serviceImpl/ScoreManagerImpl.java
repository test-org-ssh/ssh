package com.onetoone.ssh.serviceImpl;

import com.onetoone.ssh.dao.ScoreDao;
import com.onetoone.ssh.entity.FilmIntroduction;
import com.onetoone.ssh.entity.Score;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.service.ScoreManager;

public class ScoreManagerImpl implements ScoreManager {

	private ScoreDao scoreDao;
	public ScoreDao getScoreDao() {
		return scoreDao;
	}
	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}
	@Override
	public void saveScore() {
		// TODO Auto-generated method stub

	}
	@Override
	public Score getScoreByFilmAndUser(int filmid, int userid) {
		// TODO Auto-generated method stub
		return scoreDao.getScoreByFilmAndUser(filmid, userid);
	}
	@Override
	public int insertNewScore(FilmIntroduction curfilm, User giver, int doGiving) {
	
		return scoreDao.insertNewScore(curfilm, giver, doGiving);
	}
	@Override
	public float GetAvgScoreByFilmId(int filmid) {
		// TODO Auto-generated method stub
		return scoreDao.GetAvgScoreByFilmId(filmid);
	}

}
