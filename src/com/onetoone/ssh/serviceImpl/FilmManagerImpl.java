package com.onetoone.ssh.serviceImpl;

import com.onetoone.ssh.dao.FilmDao;
import com.onetoone.ssh.service.FilmManager;
import java.util.List;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.entity.*;
import com.onetoone.ssh.util.ApplicationContextUtil;

public class FilmManagerImpl implements FilmManager {

	//dao实例使用注入方式
	private FilmDao filmDao;
	
	@Override
	public List<FilmDao> getAllFilmDao(){
		List<FilmDao> filmDaoList = filmDao.getAllFilmDao();
		return filmDaoList;
	}
	
	public FilmDao getFilmDao() {
		return filmDao;
	}
	//用于注入使用
	public void setFilmDao(FilmDao filmDao) {
		this.filmDao = filmDao;
	}
	@Override
	public void saveFilm() {
		// TODO Auto-generated method stub

	}
	
	

}
