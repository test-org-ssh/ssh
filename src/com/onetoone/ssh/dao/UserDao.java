package com.onetoone.ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.util.ApplicationContextUtil;

/**
 * �û����� Dao ��
 * @author wanghaixue
 *
 */
public class UserDao {
	ClassPathXmlApplicationContext ac=(ClassPathXmlApplicationContext) ApplicationContextUtil.getApplicationContext();
	SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");
	
	/**
	 * ����һ�����û�
	 * @param ��Ҫ���������û�����
	 * @return ����Ƿ� �ɹ�
	 */
	public int insertUser(User user){
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setFnum(user.getFnum());
        user.setJianjie(user.getJianjie());
        user.setPhoto(user.getPhoto());
        user.setStatus(user.getStatus());
        
        System.out.println(user.getUsername());
        session.save(user);
        tx.commit();
        session.close();
		return 0;
	}
	
	/**
	 * �����û����������û���¼
	 * @param username
	 * @return ��ѯ�õ��ļ�¼����
	 */
	public List<User> getUserByName(String username){
		Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	Query query = session.createQuery("from User where username=?");
    	query.setParameter(0, username);
    	List<User> userlist = query.list();
    	if (userlist == null){
    		System.out.println("������listΪnull");
    		userlist = new ArrayList<User>();
    	}
    	
    	tx.commit();
        session.close();
    	
    	return userlist;
	}
	
}
