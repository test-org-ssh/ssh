package com.onetoone.ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.util.ApplicationContextUtil;

/**
 * �û����� Dao ��
 * @author wanghaixue
 *
 */
public class UserDao{
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
	
	/**
	 * ��ȡ�����û�
	 * @return
	 */
	public List<User> getAllUser(){
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List<User> list=null;
		
		session = factory.openSession();
		tx = session.beginTransaction();
		
		Query query = session.createQuery("from User");
		list = query.list();
		if (list == null){
			list = new ArrayList<User>();
		}
		
		tx.commit();
		session.close();
        
		return list;
	}

	
	public int findCount() {
		// TODO Auto-generated method stub
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List<User> list=null;
		
		session = factory.openSession();
		tx = session.beginTransaction();
		
		Query query = session.createQuery("from User");
		list = query.getResultList();
		if(list.size()>0){
			return list.size();
		}
		tx.commit();
		session.close();
		return 0;
	}
	
	
	/**
	 * ��ҳ��ѯ�û�
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<User> findByPage(int begin, Integer pageSize) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
        	Transaction tx = session.beginTransaction();
        	
        	Criteria criteria = session.createCriteria(User.class);
        	criteria.setFirstResult(begin);
        	criteria.setMaxResults(pageSize);
        	
        	List<User> list = criteria.list();
        	System.out.println(list.size());
        	tx.commit();
        	session.close();
		return list;
	}

	
}
