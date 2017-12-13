package com.onetoone.ssh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.util.ApplicationContextUtil;

public class UserDao {
	public int insertUser(){
		ClassPathXmlApplicationContext ac=(ClassPathXmlApplicationContext) ApplicationContextUtil.getApplicationContext();
		SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
        User user = new User();
        user.setUsername("Tom");
        user.setPassword("123");
        user.setBgimg("123");
        user.setFnum(12);
        user.setJianjie("jjjjj");
        user.setPhoto("456");
        user.setStatus(1);
        
        System.out.println(user.getUsername());
        session.save(user);
        tx.commit();
        session.close();
		return 0;
	}
}
