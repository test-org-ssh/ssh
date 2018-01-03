package com.onetoone.ssh.serviceImpl;

import com.onetoone.ssh.dao.FilmDao;
import com.onetoone.ssh.service.FilmManager;
import java.util.List;
import java.awt.FileDialog;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.entity.*;
import com.onetoone.ssh.util.ApplicationContextUtil;

public class FilmManagerImpl implements FilmManager {

	//daoʵ��ʹ��ע�뷽ʽ
	private FilmDao filmDao;
	
	@Override
	public List<FilmIntroduction> getAllFilmDao(){
		List<FilmIntroduction> filmDaoList = filmDao.getAllFilmDao();
		return filmDaoList;
	}

	public FilmDao getFilmDao() {
		return filmDao;
	}

	public void setFilmDao(FilmDao filmDao) {
		this.filmDao = filmDao;
	}

	@Override
	public void saveFilm() {
		// TODO Auto-generated method stub

	}
	
	

	// �����
	// ��ҳ��ѯ
	@Override
	public PageBean<FilmIntroduction> getFilmByPage(Integer currPage, Integer pageSize) {
	    	PageBean<FilmIntroduction> pageBean = new PageBean<FilmIntroduction>();
		
		//��װPageBean�������
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		int totalCount = filmDao.findCount();
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		
		//��װÿҳ����������
		int begin = (currPage - 1) * pageSize;
		List<FilmIntroduction> list = filmDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public int deleteFilm(Integer id) {
	    return filmDao.deleteFilmById(id);
	}

	@Override
	public FilmIntroduction getFilmById(Integer id) {
	    return filmDao.getFilmById(id);
	}

	@Override
	public int updateFilmById(Integer id, String name, String path, String desc) {
	    return filmDao.updateFilmById(id, name, path, desc);
	}

	@Override
	public int addFilm(String name, String path, String desc) {
	    return filmDao.addFilm(name, path, desc);
	}
}
