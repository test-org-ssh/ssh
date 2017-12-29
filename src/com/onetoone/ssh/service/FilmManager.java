package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.dao.FilmDao;

public interface FilmManager {
	public void saveFilm();
	public List<FilmDao> getAllFilmDao();
}
