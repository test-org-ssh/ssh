package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.dao.FilmDao;

public interface FilmManager {
	public void saveFilm();
	/**
	 * 获取所有影视
	 * @return
	 */
	public List<FilmDao> getAllFilmDao();
}
