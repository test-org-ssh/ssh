package com.onetoone.ssh.serviceImpl;

import com.onetoone.ssh.dao.FilmDao;
import com.onetoone.ssh.service.FilmManager;
import java.util.List;

public class FilmManagerImpl implements FilmManager {

	//daoʵ��ʹ��ע�뷽ʽ
	private FilmDao filmDao;
	
	public FilmDao getFilmDao() {
		return filmDao;
	}
	//����ע��ʹ��
	public void setFilmDao(FilmDao filmDao) {
		this.filmDao = filmDao;
	}
	@Override
	public void saveFilm() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<FilmDao> getAllFilmDao(){
		List<FilmDao> filmDaoList = filmDao.getAllFilmDao();
		return filmDaoList;
	}
	

}
