package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.dao.FilmDao;
import com.onetoone.ssh.entity.*;

public interface FilmManager {
	public void saveFilm();
	/**
	 * ��ȡ����Ӱ��
	 * @return
	 */
	public List<FilmIntroduction> getAllFilmDao();
}
