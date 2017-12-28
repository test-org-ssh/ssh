package com.onetoone.ssh.serviceImpl;

import com.onetoone.ssh.dao.FilmDao;
import com.onetoone.ssh.service.FilmManager;

public class FilmManagerImpl implements FilmManager {

	private FilmDao filmDao;
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

}
