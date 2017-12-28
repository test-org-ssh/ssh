package com.onetoone.ssh.serviceImpl;

import com.onetoone.ssh.dao.ScoreDao;
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

}
