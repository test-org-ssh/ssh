package com.onetoone.ssh.action;

import java.util.List;

import com.onetoone.ssh.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.ActionContext;
import com.onetoone.ssh.dao.FilmDao;
import com.onetoone.ssh.dao.PostTieDao;
import com.onetoone.ssh.entity.*;
import com.onetoone.ssh.service.*;
import com.onetoone.ssh.serviceImpl.*;
import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.ServletActionContext;



public class TestAction extends ActionSupport{
	//����service
	private UserManager usermanager;
	private FilmManager filmmanager;
	private PostTieManager posttiemanager;

	public String index() throws Exception {
		System.out.println("��ʼ����");
		System.out.println("���ý���");
		
		//��ȡFilmManagerʵ��������getAllFilmDao()����
		//��������浽List������
		List<FilmIntroduction> filmDaoList = filmmanager.getAllFilmDao();
		
		System.out.println("�������"+filmDaoList.size());
		
		//��ȡContext�����Ķ���
		ActionContext ac = ActionContext.getContext();
		//��filmDaoList������ӵ�session��
		ac.getSession().put("filmDaoList", filmDaoList);
		ac.put("filmDaoList", filmDaoList);
		
		
		List<PostTie> postTieList = posttiemanager.getAllPostTie();
		System.out.println("�������"+postTieList.size());
		ac.getSession().put("postTieList", postTieList);
		ac.put("postTieList", postTieList);
		
		
		return SUCCESS;
	}

	public UserManager getUsermanager() {
		return usermanager;
	}

	public void setUsermanager(UserManager usermanager) {
		this.usermanager = usermanager;
	}

	public FilmManager getFilmmanager() {
		return filmmanager;
	}

	public void setFilmmanager(FilmManager filmmanager) {
		this.filmmanager = filmmanager;
	}

	public PostTieManager getPosttiemanager() {
		return posttiemanager;
	}

	public void setPosttiemanager(PostTieManager posttiemanager) {
		this.posttiemanager = posttiemanager;
	}
	
}
