package com.onetoone.ssh.serviceImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.dao.UserDao;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.service.UserManager;
import com.onetoone.ssh.util.ApplicationContextUtil;

public class UserManagerImpl implements UserManager{
	private UserDao userdao;
	@Override
	public void saveUser() {
		userdao.insertUser();
	}
	public UserDao getUserdao() {
		return userdao;
	}
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	
}
