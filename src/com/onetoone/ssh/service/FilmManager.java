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
	
	
	/**
	 * ���ݷ�ҳ��ȡӰ����Ϣ
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<FilmIntroduction> getFilmByPage(Integer currPage,Integer pageSize);
	
	/**
	 *  ����idɾ��Ӱ��
	 * @param id
	 * @return
	 */
	public int deleteFilm(Integer id);

	/**
	 * ����id��ȡӰ��
	 * @param id
	 * @return
	 */
	public FilmIntroduction getFilmById(Integer id);
	
	/**
	 * ���Ӱ��
	 * @param name
	 * @param path
	 * @param desc
	 * @return
	 */
	public int addFilm(String name, String path, String desc);
	
	/**
	 * ����id�޸�Ӱ����Ϣ
	 * @param id
	 * @param name
	 * @param path
	 * @param desc
	 * @return
	 */
	public int updateFilmById(Integer id,String name, String path, String desc);
}
