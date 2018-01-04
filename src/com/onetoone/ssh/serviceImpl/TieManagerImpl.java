package com.onetoone.ssh.serviceImpl;

import com.onetoone.ssh.dao.TieDao;
import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.service.TieManager;

public class TieManagerImpl implements TieManager {

	private TieDao tieDao;
	public TieDao getTieDao() {
		return tieDao;
	}
	public void setTieDao(TieDao tieDao) {
		this.tieDao = tieDao;
	}
	@Override
	public void saveTie() {
		// TODO Auto-generated method stub

	}
	@Override
	public int updateCommentNumToTie(PostTie postTie) {
		
		return tieDao.updateCommentNumToTie(postTie);
	}
	@Override
	public int updateAgreeNumToTie(PostTie postTie) {
		
		return tieDao.updateAgreeNumToTie(postTie);
	}

}
