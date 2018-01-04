package com.onetoone.ssh.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.onetoone.ssh.dao.AgreeDao;
import com.onetoone.ssh.entity.Agree;
import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.service.AgreeManager;

public class AgreeManagerImpl implements AgreeManager {

	private AgreeDao agreeDao;
	
	
	public AgreeDao getAgreeDao() {
		return agreeDao;
	}


	public void setAgreeDao(AgreeDao agreeDao) {
		this.agreeDao = agreeDao;
	}


	@Override
	public void saveAgree() {
		// TODO Auto-generated method stub

	}

	public List<Agree> getAllAgree(int userid) {
		List<Agree> list = agreeDao.getAllAgree(userid);
		
		if (list == null){
			list = new ArrayList<Agree>();
		}
		return list;
	}


	@Override
	public int deleteAgreeById(int toAgreeid) {
		int res = agreeDao.deleteAgreeById(toAgreeid);
		return res;
	}


	@Override
	public int insertNewAgreeByTieAndUser(PostTie postTie, User myself) {
		int res = agreeDao.insertNewAgreeByTieAndUser(postTie, myself);
		return res;
	}

}
