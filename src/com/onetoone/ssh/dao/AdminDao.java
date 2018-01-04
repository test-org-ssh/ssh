package com.onetoone.ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.entity.Admin;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.util.ApplicationContextUtil;

public class AdminDao {
	ClassPathXmlApplicationContext ac=(ClassPathXmlApplicationContext) ApplicationContextUtil.getApplicationContext();
	SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");
	
	/**
	 * �����û����������û���¼
	 * @param username
	 * @return ��ѯ�õ��ļ�¼����
	 */
	public List<Admin> getAdminByName(String username){
		System.out.println("û��");
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	Query query = session.createQuery("from Admin where username=?");
    	query.setParameter(0, username);
    	List<Admin> adminlist = query.list();
    	if (adminlist == null){
    		adminlist = new ArrayList<Admin>();
    	}
    	
        session.close();
    	
    	return adminlist;
	}
	
	/**
	 * ��ȡ�����û�
	 * @return
	 */
	public List<Admin> getAllAdmin(){
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
		List<Admin> list=null;
		
		session = factory.openSession();
		tx = session.beginTransaction();
		
		Query query = session.createQuery("from Admin");
		list = query.list();
		if (list == null){
			list = new ArrayList<Admin>();
		}
		
		tx.commit();
        session.close();
        
		return list;
	}
}
