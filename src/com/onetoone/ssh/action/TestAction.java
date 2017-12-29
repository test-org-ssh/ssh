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
	//声明service
	private UserManager usermanager;
	private FilmManager filmManager;

	public String index() throws Exception {
		System.out.println("开始调用");
		System.out.println("调用结束");
		
		//获取FilmManager实例，调用getAllFilmDao()方法
		//将结果保存到List集合里
		List<FilmDao> filmDaoList = filmManager.getAllFilmDao();
		
		System.out.println("结果集："+filmDaoList.size());
		
		//获取Context上下文对象
		ActionContext ac = ActionContext.getContext();
		//将filmDaoList集合添加到session里
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
