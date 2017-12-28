package com.onetoone.ssh.serviceImpl;

import com.onetoone.ssh.dao.AgreeDao;
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

}
