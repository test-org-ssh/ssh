package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.dao.FilmDao;

public interface FilmManager {
	public void saveFilm();
	/**
	 * ��ȡ����Ӱ��
	 * @return
	 */
	public List<FilmDao> getAllFilmDao();
}
