package com.onetoone.ssh.action;

import java.text.DecimalFormat;
import java.util.List;

import com.onetoone.ssh.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import com.onetoone.ssh.dao.FilmDao;
import com.onetoone.ssh.entity.*;
import com.onetoone.ssh.service.*;

public class TestAction extends ActionSupport{
	//����service
	private UserManager usermanager;
	private FilmManager filmManager;

	public String index() throws Exception {
		System.out.println("��ʼ����");
		System.out.println("���ý���");
		
		//��ȡFilmManagerʵ��������getAllFilmDao()����
		//��������浽List������
		List<FilmDao> filmDaoList = filmManager.getAllFilmDao();
		
		System.out.println("�������"+filmDaoList.size());
		
		//��ȡContext�����Ķ���
		ActionContext ac = ActionContext.getContext();
		//��filmDaoList������ӵ�session��
		ac.getSession().put("filmDaoList", filmDaoList);
		
		return SUCCESS;
	}
	public UserManager getUsermanager() {
		return usermanager;
		 //
	}
	public void setUsermanager(UserManager usermanager) {
		this.usermanager = usermanager;
	}
	
	public FilmManager getFilmManager() {
		return filmManager;
	}
	public void setFilmManager(FilmManager filmManager) {
		this.filmManager = filmManager;
	}
	
}
