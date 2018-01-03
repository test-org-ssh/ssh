package com.onetoone.ssh.service;

import java.util.List;

import com.onetoone.ssh.dao.FilmDao;
import com.onetoone.ssh.entity.*;

public interface FilmManager {
	public void saveFilm();
	/**
	 * 获取所有影视
	 * @return
	 */
	public List<FilmIntroduction> getAllFilmDao();
	
	
	/**
	 * 根据分页获取影视信息
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<FilmIntroduction> getFilmByPage(Integer currPage,Integer pageSize);
	
	/**
	 *  根据id删除影视
	 * @param id
	 * @return
	 */
	public int deleteFilm(Integer id);

	/**
	 * 根据id获取影视
	 * @param id
	 * @return
	 */
	public FilmIntroduction getFilmById(Integer id);
	
	/**
	 * 添加影视
	 * @param name
	 * @param path
	 * @param desc
	 * @return
	 */
	public int addFilm(String name, String path, String desc);
	
	/**
	 * 根据id修改影视信息
	 * @param id
	 * @param name
	 * @param path
	 * @param desc
	 * @return
	 */
	public int updateFilmById(Integer id,String name, String path, String desc);
}
